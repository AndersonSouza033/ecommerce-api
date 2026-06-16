package ecommerce.bd.entity;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
public class Cliente {
    // Atributos
    @Id
    private String idCliente;
    private String nomeCliente;
    private String cpf;
    private String telefone;
    private Integer idade;
    private boolean ativo;
    private String email;

    private List<Endereco> enderecos = new ArrayList<>();

    public void adicionarEndereco(Endereco endereco){
        if (endereco == null || endereco.getNumero() == null) { throw new IllegalArgumentException("Endereço inválido!"); }
        enderecos.add(endereco);
    }

    public void removerEndereco(Endereco endereco){
        if (endereco == null) { throw new IllegalArgumentException("Endereço inválido!"); }
        enderecos.remove(endereco);
    }

    public boolean possuiEndereco(){ return enderecos != null && !enderecos.isEmpty(); }

    public void atualizarTelefone(String novoTelefone){
        if (novoTelefone == null || novoTelefone.isBlank()) { throw new IllegalArgumentException("Telefone inválido!"); }
        this.telefone = novoTelefone;
    }

    public boolean validarCpf(){ return cpf != null && cpf.matches("\\d{11}"); }

    // Getters
    public String getIdCliente() { return idCliente; }
    public String getNomeCliente() { return nomeCliente; }
    public String getCpf() { return cpf; }
    public String getTelefone() { return telefone; }
    public List<Endereco> getEnderecos() { return enderecos; }
    public Integer getIdade() { return idade; }
    public boolean getAtivo() { return ativo; }
    public String getEmail() { return email; }

    // Setters
    public void setIdCliente(String idCliente) { this.idCliente = idCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public void setEnderecos(List<Endereco> enderecos) { this.enderecos = enderecos; }
    public void setIdade(Integer idade) { this.idade = idade; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
    public void setEmail(String email) { this.email = email; }
}