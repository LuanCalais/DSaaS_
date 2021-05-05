/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConectaBanco;
import modelo.Documentos;

/**
 *
 * @author luanc
 */
public class DocumentosDAO {
    
    public static final String INSERT = "INSERT INTO documento (id_doc, descricao, data_doc, tipo_doc) VALUES(?, ?, ?, ?)";
    public static final String SELECT_ALL = "SELECT * FROM documento";
    public static final String SELECT_ID = "SELECT * FROM documento WHERE id_doc = ?";
    public static final String DELETE = "DELETE FROM documento WHERE id_doc = ?";
    public static final String UPDATE = "UPDATE documento SET descricao = ?,  data_doc = ?, tipo_doc = ?  WHERE id_doc = ?";
    
        public void cadastrar(Documentos documentos){
        Connection conexao = null;
        try{
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setInt(1, documentos.getId());
            pstmt.setString(2, documentos.getDescricao());
            pstmt.setString(3,  documentos.getData());
            pstmt.setString(4, documentos.getTipo());
            pstmt.execute();
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        finally{
            try{
                conexao.close();
            }catch(SQLException el){
                throw new RuntimeException(el);
            }
        }
    }
    
    
    public ArrayList<Documentos> listar(){
        ArrayList<Documentos> resultado = new ArrayList();
        try{
            Connection conexao = ConectaBanco.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            
            while(rs.next()){
                Documentos doc = new Documentos();
                //doc.setId(rs.getInt(SELECT_ALL));
                doc.setId(rs.getInt("id_doc"));
                doc.setDescricao(rs.getString("descricao"));
                doc.setData(rs.getString("data_doc"));
                doc.setTipo(rs.getString("tipo_doc"));
                resultado.add(doc);
            }
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
    
    public ArrayList<Documentos> listarId(int id){
        ArrayList<Documentos> resultado = new ArrayList();
        try{
            Connection conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
            
            ResultSet rs = pstmt.executeQuery();
           
            while(rs.next()){
                Documentos doc = new Documentos();
                doc.setId(rs.getInt("id_doc"));
                doc.setDescricao(rs.getString("descricao"));
                doc.setData(rs.getString("data_doc"));
                doc.setTipo(rs.getString("tipo_doc"));
                resultado.add(doc);
                }
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return resultado;
    }
    
    
       public void delete(Documentos documento) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        try{
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, documento.getId());
            pstmt.execute();
            conexao.close();
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        finally{
            try{
                conexao.close();
            }catch(Exception e){
                throw new RuntimeException(e);
            }
        }
        
    }
    
           public void atualizar(Documentos documento) throws ClassNotFoundException, SQLException{
        Connection conexao = null;
        try{
            
            conexao = ConectaBanco.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, documento.getDescricao());
            pstmt.setString(2, documento.getData());
            pstmt.setString(3, documento.getTipo());
            pstmt.setInt(4, documento.getId());
            
            pstmt.execute();
            
            conexao.close();
            
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
        try{
            conexao.close();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    } 
       
    
    /*
    public ArraysList<Documentos>listarID(int id){
        Arraylist<Documentos> resultado = new ArrayList();
        
        
        
        return 0;
    }*/
    
}
