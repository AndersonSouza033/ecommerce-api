package ecommerce.bd.service;

import java.util.List;

import ecommerce.bd.entity.Pedido;
import ecommerce.bd.repository.PedidoRepository;

public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) { this.repository = repository; }

    public Pedido salvarPedido(Pedido pedido) { return repository.save(pedido); }

    public List<Pedido> listarPedidos() { return repository.findAll(); }

    public Pedido buscarPorId(String idPedido){
        return repository.findById(idPedido).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
