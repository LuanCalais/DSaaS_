package modelo;

public class CaixaBuilder{

    private int id_caixa;
    private String tipo = " ";
    private String descricao = " ";
    private int quantidade = 0;
    private int cd_usuario = 0;
    private double total = 0;
    
    public CaixaBuilder comId_caixa(int id_caixa){
        this.id_caixa = id_caixa;
        return this;
    }

    public CaixaBuilder comTipo(String tipo){
        this.tipo = tipo;
        return this;
    }
    
    public CaixaBuilder comDescricao(String descricao){
        this.descricao = descricao;
        return this;
    }
    
    public CaixaBuilder comQuantidade(int quantidade){
        this.quantidade = quantidade;
        return this;
    }
    
    public CaixaBuilder comCd_usuario(int cd_usuario){
        this.cd_usuario = cd_usuario;
        return this;
    }
    
    public double comTotal(){
        double total = quantidade * 5.0;
        this.total = total;
        return total;
    }
    
    public Caixa constroi(){
        return new Caixa(id_caixa, tipo, descricao, quantidade, cd_usuario, comTotal());
    } 
    
}
