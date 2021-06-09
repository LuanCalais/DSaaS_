package modelo;

public class EnderecoBuilder {

    private int id;
    private String cep;
    private String logadouro;
    private String bairro;
    private int numero;
    private String complemento;

    public EnderecoBuilder comId(int id){
        this.id = id;
        return this;
    }
    
    public EnderecoBuilder comCep(String cep){
        this.cep = cep;
        return this;
    }
    
    public EnderecoBuilder comLogadouro(String logadouro){
        this.logadouro = logadouro;
        return this;
    }
    
    public EnderecoBuilder comBairro(String bairro){
        this.bairro = bairro;
        return this;
    }
    
    public EnderecoBuilder comNumero(int numero){
        this.numero = numero;
        return this;
    }
    
    public EnderecoBuilder comComplemento(String complemento){
        this.complemento = complemento;
        return this;
    }
    
    public Endereco constroi(){
        return new Endereco(id, cep, logadouro, bairro, numero, complemento);
    }
    
}
