package ecommerce.bd.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import ecommerce.bd.entity.Pedido;
import ecommerce.bd.entity.StatusPedido;


public interface PedidoRepository extends MongoRepository<Pedido,String> {
    List<Pedido> findByClienteId(String clienteId);
    List<Pedido> findByTotalGreaterThanEqual(BigDecimal total);
    List<Pedido> findByTotalLessThanEqual(BigDecimal total);
    List<Pedido> findByTotal(BigDecimal total);
    List<Pedido> findByDataPedidoAndStatus(LocalDate dataPedido, StatusPedido status);
    List<Pedido> findByDataPedido(LocalDate dataPedido);
    List<Pedido> findByStatus(StatusPedido status);
}
