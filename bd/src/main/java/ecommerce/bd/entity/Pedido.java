package ecommerce.bd.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private StatusPedido status;
    private LocalDate dataPedido = LocalDate.now();
    private BigDecimal total = BigDecimal.ZERO;

    private List<ItemPedido> itens = new ArrayList<>();

    // Contrutor
    public Pedido(String clienteId, StatusPedido status, BigDecimal total) {
        if (clienteId == null || clienteId.isBlank()) { throw new IllegalArgumentException("Cliente inválido!");}

        if (status == null) { throw new IllegalArgumentException("Status inválido!"); }

        if (total == null || total.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Total inválido!"); }

        this.clienteId = clienteId;
        this.status = status;
        this.total = total;
    }

    // Contrutor Vázio
    public Pedido(){}

    // Adicionar Item no Pedido
    public void adicionarItem(ItemPedido item){
        if (item == null) { throw new IllegalArgumentException("Item inválido!"); }

        if (item.getProdutoId() == null || item.getProdutoId().isBlank()) { throw new IllegalArgumentException("Produto inválido!"); }

        if (item.getQuantidade() == null || item.getQuantidade() <= 0) {throw new IllegalArgumentException("Quantidade inválida!"); }

        if (item.getPreco() == null) { throw new IllegalArgumentException("Preço inválido!"); }

        itens.add(item); calcularTotal();
    }

    // Remover Item do Pedido
    public void removerItem(ItemPedido item){
        if (item == null) { throw new IllegalArgumentException("Item inválido!"); }
        itens.remove(item); calcularTotal();
    }

    // Remove Todos os Itens
    public void limparItens(){ itens.clear(); calcularTotal(); }

    // Verificar se Existe Itens
    public boolean temItens(){ return itens != null && !itens.isEmpty(); }

    // Calcular Total do Pedido
    public void calcularTotal(){
        total = BigDecimal.ZERO;

        for (ItemPedido item : itens){ total = total.add(item.calcularSubtotal()); }
    }

    // Getters
    public String getIdPedido() { return idPedido; }
    public String getClienteId() { return clienteId; }
    public StatusPedido getStatus() { return status; }
    public BigDecimal getTotal() { return total; }
    public List<ItemPedido> getItens() { return itens; }
    public LocalDate getDataPedido() { return dataPedido; }

    // Setters
    public void setIdPedido(String idPedido) { this.idPedido = idPedido;}
    public void setClienteId(String clienteId) {
        if (clienteId == null || clienteId.isBlank()) { throw new IllegalArgumentException("Cliente inválido!");}

        this.clienteId = clienteId;
    }

    public void setStatus(StatusPedido status) {
        if (status == null) { throw new IllegalArgumentException("Status inválido!");}

        this.status = status;
    }

    public void setTotal(BigDecimal total) {
        if (total == null || total.compareTo(BigDecimal.ZERO) < 0) { throw new IllegalArgumentException("Total inválido!"); }

        this.total = total;
    }

    public void setItens(List<ItemPedido> itens) {
        if (itens == null) { throw new IllegalArgumentException("Lista inválida!"); }

        this.itens = itens;
        calcularTotal();
    }

    public void setDataPedido(LocalDate dataPedido) {
        if (dataPedido == null) { throw new IllegalArgumentException("Data inválida!"); }

        this.dataPedido = dataPedido;
    }
}