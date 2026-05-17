package ecommerce.bd.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pedidos")
public class Pedido {
    // Atributos
    @Id
    private String idPedido;
    private String clienteId;
    private BigDecimal total = BigDecimal.ZERO;

    private List<ItemPedido> itens = new ArrayList<>();

    public void adicionarItem(ItemPedido item){
        if (item == null) { throw new IllegalArgumentException("Item inválido!"); }

        if (item.getProdutoId() == null || item.getProdutoId().isBlank()) { throw new IllegalArgumentException("Produto inválido!"); }

        if (item.getQuantidade() == null || item.getQuantidade() <= 0) {throw new IllegalArgumentException("Quantidade inválida!"); }

        if (item.getPreco() == null) { throw new IllegalArgumentException("Preço inválido!"); }

        itens.add(item); calcularTotal();
    }

    public void removerItem(ItemPedido item){
        if (item == null) { throw new IllegalArgumentException("Item inválido!"); }
        itens.remove(item); calcularTotal();
    }

    public void limparItens(){ itens.clear(); calcularTotal(); }

    public boolean temItens(){ return itens != null && !itens.isEmpty(); }

    public void calcularTotal(){
        total = BigDecimal.ZERO;

        for (ItemPedido item : itens){ total = total.add(item.calcularSubtotal()); }
    }

    // Getters
    public String getIdPedido() { return idPedido; }
    public String getClienteId() { return clienteId; }
    public BigDecimal getTotal() { return total; }
    public List<ItemPedido> getItens() { return itens; }

    // Setters
    public void setIdPedido(String idPedido) { this.idPedido = idPedido; }
    public void setClienteId(String clienteId) { this.clienteId = clienteId; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public void setItens(List<ItemPedido> itens) { this.itens = itens; }
}