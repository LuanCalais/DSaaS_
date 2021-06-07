package modelo;

public class Solicitacoes {

    private int id_solicitacoes;
    private String email;
    private int cd_caixa;

    public int getId_solicitacoes() {
        return id_solicitacoes;
    }

    public void setId_solicitacoes(int id_solicitacoes) {
        this.id_solicitacoes = id_solicitacoes;
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
}
