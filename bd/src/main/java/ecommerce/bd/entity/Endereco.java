package ecommerce.bd.entity;

public class Endereco {
    // Atributos
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public boolean validarCep(){
        if (cep == null && cep.isBlank() && cep.length() != 8){ return false; }
        return cep.matches("\\d{8}");
    }

    // Getters
    public String getRua() { return rua; }
    public String getNumero() { return numero; }
    public String getBairro() { return bairro; }
    public String getCidade() { return cidade; }
    public String getEstado() { return estado; }
    public String getCep() { return cep; }

    // Setters
    public void setRua(String rua) { this.rua = rua; }
    public void setNumero(String numero) { this.numero = numero; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setCep(String cep) { this.cep = cep; }
}   
