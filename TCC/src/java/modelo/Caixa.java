package modelo;

import java.sql.Date;

public class Caixa {

    private int id_caixa;
    private String tipo;
    private String descricao;
    private int quantidade;
    private int cd_usuario;
    private double total;
    private String email_usu;

    public Caixa(int id_caixa, String tipo, String descricao, int quantidade, int usuario, double total, String email_usu) {
        this.id_caixa = id_caixa;
        this.tipo = tipo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.cd_usuario = usuario;
        this.total = total;
        this.email_usu = email_usu;
    }
    
    public Caixa(){
      
    }

    public int getId_caixa() {
        return id_caixa;
    }

    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setUsuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEmail_usu() {
        return email_usu;
    }

    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

}
