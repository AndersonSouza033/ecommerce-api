package ecommerce.bd.entity;

import java.math.BigDecimal;

public class ItemPedido {
    // Atributos
    private String produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private BigDecimal preco;

    public BigDecimal calcularSubtotal(){
        if (produtoId == null || produtoId.isBlank()) { throw new IllegalArgumentException("Produto inválido!"); }

        if (preco == null || preco.compareTo(BigDecimal.ZERO) <= 0){ throw new IllegalArgumentException("Preço inválido!");}

        if (quantidade == null || quantidade <= 0) { throw new IllegalArgumentException("Quantidade inválida!"); }

        return preco.multiply(BigDecimal.valueOf(quantidade));
    }

    // Getters
    public String getProdutoId() { return produtoId; }
    public String getNomeProduto() { return nomeProduto; }
    public Integer getQuantidade() { return quantidade; }
    public BigDecimal getPreco() { return preco; }

    // Setters
    public void setProdutoId(String produtoId) { this.produtoId = produtoId;}
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}