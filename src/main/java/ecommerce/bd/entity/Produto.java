package ecommerce.bd.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "produtos")
public class Produto {
    // Atributos
    @Id
    private String idProduto;
    private String nomeProduto;
    private String descricao;
    private BigDecimal valor;
    private Integer estoque;
    private String idCategoria;

    public void adicionarEstoque(Integer quantidade){
        if (quantidade == null || quantidade <= 0 ) { throw new IllegalArgumentException("Quantidade inválida!"); }

        if (estoque == null){ estoque = 0; }

        this.estoque += quantidade;
    }

    public void baixarEstoque(Integer quantidade){
        if (quantidade == null || quantidade <= 0 ) { throw new IllegalArgumentException("Quantidade inválida!"); }

        if (quantidade > estoque) { throw new IllegalArgumentException("Saldo insuficiente!"); }

        this.estoque -= quantidade;
    }

    // Getters
    public boolean temEstoque(){ return estoque != null && estoque > 0; }
    public String getIdProduto() { return idProduto;}
    public String getNomeProduto() { return nomeProduto; }
    public String getDescricao() { return descricao; }
    public BigDecimal getValor() { return valor; }
    public Integer getEstoque() { return estoque; }
    public String getIdCategoria() { return idCategoria; }

    // Setters
    public void setIdProduto(String idProduto) { this.idProduto = idProduto; }
    public void setNomeProduto(String nomeProduto) { this.nomeProduto = nomeProduto; }
    public void setDescricao(String descricao) { this.descricao = descricao;}
    public void setValor(BigDecimal valor) { this.valor = valor;}
    public void setEstoque(Integer estoque) { this.estoque = estoque;}
    public void setIdCategoria(String idCategoria) { this.idCategoria = idCategoria; }
}
