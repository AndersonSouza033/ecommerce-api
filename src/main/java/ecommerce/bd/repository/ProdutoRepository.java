package ecommerce.bd.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findAllByNomeProdutoIgnoreCaseContaining(String nomeProduto);
}