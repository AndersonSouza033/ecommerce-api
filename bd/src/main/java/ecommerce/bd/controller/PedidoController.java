package ecommerce.bd.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bd.entity.Pedido;
import ecommerce.bd.entity.StatusPedido;
import ecommerce.bd.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService service;

    // Construtor
    public PedidoController(PedidoService service) { this.service = service; }

    // CRUD Básico
    @PostMapping
    public Pedido salvarPedido(@RequestBody Pedido pedido) { return service.salvarPedido(pedido); }

    @GetMapping
    public List<Pedido> listarPedidos() { return service.listarPedidos(); }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable String id) { return service.buscarPorId(id); }

    @PutMapping("/{id}")
    public Pedido atualizarPedido(@PathVariable String id, @RequestBody Pedido pedido) { return service.atualizarPedido(id, pedido); }

    // Consultar Básicas com Find
    @GetMapping("/cliente")
    public List<Pedido> buscarPorClienteId(@RequestParam String clienteId) { return service.buscarPorClienteId(clienteId); }

    @GetMapping("/total")
    public List<Pedido> buscarTotal(@RequestParam BigDecimal total) { return service.buscarTotal(total); }

    @GetMapping("/status")
    public List<Pedido> buscarStatus(@RequestParam StatusPedido status) { return service.buscarStatus(status); }

    @GetMapping("/data")
    public List<Pedido> buscarDataPedido(@RequestParam LocalDate dataPedido) { return service.buscarDataPedido(dataPedido); }

    // Consultas Avançadas GET
    @GetMapping("/total/gte")
    public List<Pedido> buscarTotalGte(@RequestParam BigDecimal total) { return service.buscarTotalGte(total); }

    @GetMapping("/total/lte")
    public List<Pedido> buscarTotalLte(@RequestParam BigDecimal total) { return service.buscarTotalLte(total); }

    @GetMapping("/data-status")
    public List<Pedido> buscarPorDataPedidoAndStatus(@RequestParam LocalDate dataPedido, @RequestParam StatusPedido status) {
        return service.buscarPorDataPedidoAndStatus(dataPedido, status);
    }
}