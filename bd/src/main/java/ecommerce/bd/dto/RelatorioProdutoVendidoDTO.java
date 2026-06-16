package ecommerce.bd.dto;

public class RelatorioProdutoVendidoDTO {

    private String produtoId;
    private Integer quantidadeVendida;

    public RelatorioProdutoVendidoDTO(){}

    public String getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(Integer quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }
}