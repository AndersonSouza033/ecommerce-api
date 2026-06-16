package ecommerce.bd.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.bd.entity.Produto;
import ecommerce.bd.repository.ProdutoRepository;

@Service
public class ProdutoService {
    // Métodos auxilares de validação
    public void validarNome(String nome){ if (nome == null || nome.isBlank()) { throw new IllegalArgumentException("Nome Inválido!");} }

    private final ProdutoRepository repository;

    // Construtor
    public ProdutoService(ProdutoRepository repository){ this.repository = repository; }

    // Cadastrar Produto POST
    public Produto salvarProduto(Produto produto){ return repository.save(produto); }

    // Listar Produtos GET
    public List<Produto> listarProdutos(){ return repository.findAll(); }
        public List<Produto> buscarPorNome(String nomeProduto){
        validarNome(nomeProduto);

        List<Produto> produtos = repository.findAllByNomeProdutoIgnoreCaseContaining(nomeProduto);

        if(produtos.isEmpty()) { throw new RuntimeException("Nenhum produto encontrado!");}

        return produtos;
    }

    // Atualizar Produto PUT
    public Produto atualizarProduto(String id, Produto produtoAtualizado){
        Produto produtoExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        produtoExistente.setNomeProduto(produtoAtualizado.getNomeProduto());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setValor(produtoAtualizado.getValor());
        produtoExistente.setEstoque(produtoAtualizado.getEstoque());

        return repository.save(produtoExistente);
    }

    // Métodos buscar GET
    public Produto buscarPorId(String idProduto){
        return repository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public List<Produto> buscarValorGt(BigDecimal valor){
        if(valor == null){ throw new IllegalArgumentException("Valor inválido!"); }

        return repository.findByValorGreaterThan(valor);
    }

    public List<Produto> buscarValorLt(BigDecimal valor){
        if(valor == null){ throw new IllegalArgumentException("Valor inválido!"); }

        return repository.findByValorLessThan(valor);
    }

    public List<Produto> buscarEstoqueDiferente(Integer estoque){
        return repository.findByEstoqueNot(estoque);
    }

    public List<Produto> buscarValorOuEstoque(BigDecimal valor,Integer estoque){
        return repository.findByValorGreaterThanOrEstoqueLessThan(valor,estoque);
    }
}