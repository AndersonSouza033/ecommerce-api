package ecommerce.bd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Categoria;

public interface CategoriaRepository extends MongoRepository<Categoria, String>{
    
}
