package ecommerce.bd.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String>{
    List<Categoria> findByNomeCategoriaIgnoreCaseContaining(String nomeCategoria);
    List<Categoria>findByNomeCategoriaIgnoreCaseContainingOrDescricaoIgnoreCaseContaining(String nomeCategoria,String descricao);
}