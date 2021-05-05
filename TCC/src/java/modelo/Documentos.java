/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author luanc
 */
public class Documentos {
    private int id;
    private String descricao;
    private String data;
    private String tipo;
    
    public int getId(){
        return id;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String  getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
        public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
