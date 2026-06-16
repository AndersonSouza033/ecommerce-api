package ecommerce.bd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.bd.entity.Categoria;
import ecommerce.bd.repository.CategoriaRepository;

@Service
public class CategoriaService {
    private final CategoriaRepository repository;

    // Construtor
    public CategoriaService(CategoriaRepository repository) { this.repository = repository; }

    // CRUD Básico
    public Categoria salvarCategoria(Categoria categoria) { return repository.save(categoria); }

    public List<Categoria> listarCategorias() { return repository.findAll(); }

    public Categoria buscarPorId(String id) {
        if(id == null || id.isBlank()) { throw new IllegalArgumentException("Id inválido!"); }

        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
    }

    public Categoria atualizarCategoria(String id, Categoria categoriaAtualizada) {
        Categoria categoriaExistente = repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));

        categoriaExistente.setNomeCategoria(categoriaAtualizada.getNomeCategoria());

        categoriaExistente.setDescricao(categoriaAtualizada.getDescricao());

        return repository.save(categoriaExistente);
    }

    public void deletarCategoria(String id) {
        if(id == null || id.isBlank()) { throw new IllegalArgumentException("Id inválido!"); }

        if(!repository.existsById(id)) { throw new RuntimeException("Categoria não encontrada!"); }

        repository.deleteById(id);
    }

    // Consultas básicas
    public List<Categoria> buscarPorNome(String nomeCategoria) {
        if(nomeCategoria == null || nomeCategoria.isBlank()) { throw new IllegalArgumentException("Nome inválido!"); }

        List<Categoria> categorias = repository.findByNomeCategoriaIgnoreCaseContaining(nomeCategoria);

        if(categorias.isEmpty()) { throw new RuntimeException("Nenhuma categoria encontrada!");}

        return categorias;
    }

    // Consultas Avançadas GET
    public List<Categoria> buscarPorNomeOuDescricao(String nomeCategoria, String descricao) {
        if(nomeCategoria == null || nomeCategoria.isBlank()) { throw new IllegalArgumentException("Nome inválido!"); }

        if(descricao == null || descricao.isBlank()) { throw new IllegalArgumentException("Descrição inválida!"); }

        List<Categoria> categorias = 
        repository.findByNomeCategoriaIgnoreCaseContainingOrDescricaoIgnoreCaseContaining(nomeCategoria,descricao);

        if(categorias.isEmpty()) { throw new RuntimeException("Nenhuma categoria encontrada!"); }

        return categorias;
    }
}