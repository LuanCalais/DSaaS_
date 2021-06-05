package modelo;

public class Estoque extends Caixa{
    
    private int id;
    private char referencia;
    private int rua;
    private String status;
    private Caixa caixa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getReferencia() {
        return referencia;
    }

    public void setReferencia(char referencia) {
        this.referencia = referencia;
    }

    public int getRua() {
        return rua;
    }

    public void setRua(int rua) {
        this.rua = rua;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
    
}
