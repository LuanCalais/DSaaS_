package modelo;

public class Estoque{
    
    private int id;
    private char referencia;
    private int rua;
    private String status;
    private int id_caixa;

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

    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }
    
}
