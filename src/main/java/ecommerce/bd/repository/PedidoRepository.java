package ecommerce.bd.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido,String>{
    
}
