package ecommerce.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.bd.entity.Produto;
import ecommerce.bd.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){ this.repository = repository; }

    public Produto salvarProduto(Produto produto){ return repository.save(produto); }

    public List<Produto> listarProdutos(){ return repository.findAll(); }

    // Métodos auxilares de validação
    public void validarNome(String nome){ if (nome == null || nome.isBlank()) { throw new IllegalArgumentException("Nome Inválido!");} }

    // Métodos buscar
    public Produto buscarPorId(String idProduto){
        return repository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public List<Produto> buscarPorNome(String nomeProduto){
        validarNome(nomeProduto);

        List<Produto> produtos = repository.findAllByNomeProdutoIgnoreCaseContaining(nomeProduto);

        if(produtos.isEmpty()) { throw new RuntimeException("Nenhum produto encontrado!");}

        return produtos;
    }
}