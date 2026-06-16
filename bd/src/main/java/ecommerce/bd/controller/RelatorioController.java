package ecommerce.bd.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.bd.dto.PedidoClienteLookupDTO;
import ecommerce.bd.dto.RelatorioProdutoVendidoDTO;
import ecommerce.bd.dto.RelatorioStatusDTO;
import ecommerce.bd.service.RelatorioService;

@RestController
public class RelatorioController {
    private final RelatorioService service;

    // Construtor
    public RelatorioController(RelatorioService service){ this.service = service; }

    @GetMapping("/relatorios/pedidos-status")
    public List<RelatorioStatusDTO> pedidosPorStatus(){ return service.pedidosPorStatus(); }

    @GetMapping("/produtos-mais-vendidos")
    public List<RelatorioProdutoVendidoDTO> produtosMaisVendidos(){ return service.produtosMaisVendidos(); }

    @GetMapping("/pedidos-clientes")
    public List<PedidoClienteLookupDTO> pedidosComCliente(){ return service.pedidosComCliente();    }
}