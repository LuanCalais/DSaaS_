package modelo;

public class Solicitacoes{

    private int id_solicitacoes;
    private int cd_usuario;
    private String email;
    private int cd_caixa;
    private int cd_estoque;
    private String dscricao;
    private String tipo;
    private int quantidade;
    private String status;

    public int getId_solicitacoes() {
        return id_solicitacoes;
    }

    public void setId_solicitacoes(int id_solicitacoes) {
        this.id_solicitacoes = id_solicitacoes;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCd_caixa() {
        return cd_caixa;
    }

    public void setCd_caixa(int cd_caixa) {
        this.cd_caixa = cd_caixa;
    }

    public int getCd_estoque() {
        return cd_estoque;
    }

    public void setCd_estoque(int cd_estoque) {
        this.cd_estoque = cd_estoque;
    }
    
    public String getDscricao() {
        return dscricao;
    }

    public void setDscricao(String dscricao) {
        this.dscricao = dscricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
