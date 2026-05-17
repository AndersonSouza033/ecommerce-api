package ecommerce.bd.service;

import java.util.List;

import ecommerce.bd.entity.Categoria;
import ecommerce.bd.repository.CategoriaRepository;

public class CategoriaService {
    private final CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository){ this.repository =  repository; }

    public Categoria saveCategoria(Categoria categoria) { return repository.save(categoria); }

    public List<Categoria> listarCategorias(){ return repository.findAll(); }

    public Categoria buscarPorId(String idCategoria) { 
        return repository.findById(idCategoria).orElseThrow(() -> new RuntimeException("Categoria não encontrada!"));
    }
}
