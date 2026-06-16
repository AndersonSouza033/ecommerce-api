package ecommerce.bd.dto;

import java.util.List;

import ecommerce.bd.entity.Cliente;

public class PedidoClienteLookupDTO {

    private String idPedido;
    private String clienteId;
    private List<Cliente> cliente;

    public PedidoClienteLookupDTO(){}

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<Cliente> getCliente() {
        return cliente;
    }

    public void setCliente(List<Cliente> cliente) {
        this.cliente = cliente;
    }
}