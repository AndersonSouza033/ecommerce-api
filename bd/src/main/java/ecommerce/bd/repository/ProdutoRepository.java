package ecommerce.bd.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    List<Produto> findAllByNomeProdutoIgnoreCaseContaining(String nomeProduto);
    List<Produto> findByValorGreaterThan(BigDecimal valor);
    List<Produto> findByValorLessThan(BigDecimal valor);
    List<Produto> findByEstoqueNot(Integer estoque);
    List<Produto> findByValorGreaterThanOrEstoqueLessThan(BigDecimal valor,Integer estoque);
}

