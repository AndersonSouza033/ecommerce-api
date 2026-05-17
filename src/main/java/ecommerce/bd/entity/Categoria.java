package ecommerce.bd.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categorias")
public class Categoria {
    // Atributos
    @Id
    private String idCategoria;
    private String nomeCategoria;
    private String descricao;

    // Getters
    public String getIdCategoria() { return idCategoria; }
    public String getNomeCategoria() { return nomeCategoria; }
    public String getDescricao() { return descricao; }

    // Setters
    public void setIdCategoria(String idCategoria) { this.idCategoria = idCategoria; }
    public void setNomeCategoria(String nomeCategoria) { this.nomeCategoria = nomeCategoria; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
