package ecommerce.bd.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import ecommerce.bd.entity.Pedido;
import ecommerce.bd.entity.StatusPedido;
import ecommerce.bd.repository.PedidoRepository;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    // Construtor
    public PedidoService(PedidoRepository repository) { this.repository = repository; }

    // CRUD Básico
    public Pedido salvarPedido(Pedido pedido) { return repository.save(pedido); }

    public List<Pedido> listarPedidos() { return repository.findAll(); }

    public Pedido buscarPorId(String idPedido) {
        return repository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido atualizarPedido( String idPedido, Pedido pedidoAtualizado) {
        Pedido pedido = repository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setClienteId( pedidoAtualizado.getClienteId());
        pedido.setStatus(pedidoAtualizado.getStatus());
        pedido.setItens(pedidoAtualizado.getItens());

        return repository.save(pedido);
    }

    // Consultar Básicas com Find
    public List<Pedido> buscarPorClienteId(String clienteId) {
        if (clienteId == null || clienteId.isBlank()) { throw new IllegalArgumentException("Id inválido!"); }

        return repository.findByClienteId(clienteId);
    }
    
    public List<Pedido> buscarTotal(BigDecimal total) {
        if (total == null){ throw new IllegalArgumentException("Erro no total do pedido!");}
        if (total.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Total não pode ser negativo!"); }

        return repository.findByTotal(total);
    }

    public List<Pedido> buscarDataPedido(LocalDate dataPedido){
        if (dataPedido == null) { throw new IllegalArgumentException("Data inválida!"); }
        
        return repository.findByDataPedido(dataPedido);
    }

    public List<Pedido> buscarStatus(StatusPedido status) {
        if (status == null) { throw new IllegalArgumentException("Status inválido!"); }

        return repository.findByStatus(status);
    }

    // Consultas Avançadas GET
    public List<Pedido> buscarTotalGte(BigDecimal total) {
        if (total == null){ throw new IllegalArgumentException("Erro no total do pedido!");}
        if (total.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Total não pode ser negativo!"); }

        return repository.findByTotalGreaterThanEqual(total);
    }

    public List<Pedido> buscarTotalLte(BigDecimal total) {
        if (total == null){ throw new IllegalArgumentException("Erro no total do pedido!");}
        if (total.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Total não pode ser negativo!"); }

        return repository.findByTotalLessThanEqual(total);
    }

    public List<Pedido> buscarPorDataPedidoAndStatus(LocalDate dataPedido, StatusPedido status){
        if (dataPedido == null) { throw new IllegalArgumentException("Data inválida!"); }
        if (status == null) { throw new IllegalArgumentException("Status inválido!"); }

        return repository.findByDataPedidoAndStatus(dataPedido, status);
    }
}