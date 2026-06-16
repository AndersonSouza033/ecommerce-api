package ecommerce.bd.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bd.entity.Produto;
import ecommerce.bd.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService service;

    // Construtor
    public ProdutoController(ProdutoService service){ this.service = service; }

    // CRUD Básico
    @GetMapping
    public List<Produto> listarProdutos() { return service.listarProdutos(); }

    @PostMapping
    public Produto salvarProduto(@RequestBody Produto produto) { return service.salvarProduto(produto); }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable String id,@RequestBody Produto produto){
        return service.atualizarProduto(id,produto);
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable String id) { return service.buscarPorId(id); }

    // Consultar Básicas com Find
    @GetMapping("/nome")
    public List<Produto> buscarPorNome(@RequestParam String nomeProduto) { return service.buscarPorNome(nomeProduto); }


    // Consultas Avançadas GET
    @GetMapping("/valor/gt")
    public List<Produto> buscarValorGt(@RequestParam BigDecimal valor){
        return service.buscarValorGt(valor);
    }

    @GetMapping("/valor/lt")
    public List<Produto> buscarValorLt(@RequestParam BigDecimal valor){
        return service.buscarValorLt(valor);
    }

    @GetMapping("/estoque/ne")
    public List<Produto> buscarEstoqueDiferente(@RequestParam Integer estoque){
        return service.buscarEstoqueDiferente(estoque);
    }

    @GetMapping("/or")
    public List<Produto> buscarValorOuEstoque(@RequestParam BigDecimal valor, @RequestParam Integer estoque){
        return service.buscarValorOuEstoque(valor,estoque);
    }
}