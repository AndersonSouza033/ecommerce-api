package ecommerce.bd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bd.entity.Categoria;
import ecommerce.bd.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService service;

    // Construtor
    public CategoriaController(CategoriaService service) { this.service = service; }

    // CRUD Básico
    @PostMapping
    public Categoria salvarCategoria(@RequestBody Categoria categoria) { return service.salvarCategoria(categoria); }

    @GetMapping
    public List<Categoria> listarCategorias() { return service.listarCategorias(); }

    @GetMapping("/{id}")
    public Categoria buscarPorId( @PathVariable String id) { return service.buscarPorId(id); }

    @PutMapping("/{id}")
    public Categoria atualizarCategoria(@PathVariable String id, @RequestBody Categoria categoria) {
        return service.atualizarCategoria(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable String id) { service.deletarCategoria(id); }

    // Consultas básicas
    @GetMapping("/nome")
    public List<Categoria> buscarPorNome(@RequestParam String nomeCategoria) {
        return service.buscarPorNome(nomeCategoria);
    }

    // Consultas Avançadas GET
    @GetMapping("/or")
    public List<Categoria> buscarPorNomeOuDescricao(@RequestParam String nomeCategoria, @RequestParam String descricao) {
        return service.buscarPorNomeOuDescricao(nomeCategoria,descricao);
    }
}