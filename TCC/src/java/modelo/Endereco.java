package modelo;

public class Endereco {
    
    private int id;
    private String cep;
    private String logadouro;
    private String bairro;
    private int numero;
    private String complemento;

    public Endereco(int id, String cep, String logadouro, String bairro, int numero, String complemento) {
        this.id = id;
        this.cep = cep;
        this.logadouro = logadouro;
        this.bairro = bairro;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    public Endereco() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
}
