package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Estoque;
import modelo.Solicitacoes;
import util.ConectaBancoUsuario;

public class EstoqueDAO {

    public static final String INSERT = "INSERT INTO estoque(referencia, rua, data_entrada, status) VALUES(?, ?, CURRENT_DATE, ?)";
    public static final String DELETE = "DELETE FROM estoque WHERE id = ?";
    public static final String SELECT_ALL = "SELECT * FROM estoque";
    public static final String SELECT_ID = "SELECT * FROM estoque WHERE id = ?";
    public static final String ALTERAR = "UPDATE estoque SET rua = ?, status = ? WHERE id = ?";
    public static final String UPDATE = "UPDATE estoque SET cd_caixa = ?, status = 'Ocupado', data_entrada = CURRENT_DATE WHERE id = ?";
    public static final String CONFIRMA = "UPDATE estoque SET status = ?, cd_caixa = ? WHERE id = ?";
    
    
    public void cadastraEstoque(Estoque estoque) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);

            pstmt.setString(1, String.valueOf(estoque.getReferencia()));
            pstmt.setInt(2, estoque.getRua());
            pstmt.setString(3, estoque.getStatus());
            pstmt.execute();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    
    public void updateEstoque(Estoque estoque){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(ALTERAR);
            
            pstmt.setInt(1, estoque.getRua());
            pstmt.setString(2, estoque.getStatus());
            pstmt.setInt(3, estoque.getId());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            try{
                conexao.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }
    
    public void updateCadastroCaixa(Estoque estoque){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            
            pstmt.setInt(1, estoque.getId_caixa());
            pstmt.setInt(2, estoque.getId());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            try{
                conexao.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }
    
    public void confirmaEstoque(Solicitacoes solicita){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(CONFIRMA);
            
            pstmt.setString(1, solicita.getStatus());
            pstmt.setInt(2, solicita.getCd_caixa());
            pstmt.setInt(3, solicita.getCd_estoque());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }finally{
            try{
                conexao.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }

    public void deletarEstoque(Estoque estoque) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);

            pstmt.setInt(1, estoque.getId());
            pstmt.execute();

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public ArrayList<Estoque> listarEstoque() {
        ArrayList<Estoque> resultado = new ArrayList();
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                Estoque estoque = new Estoque();
                estoque.setId(rs.getInt("Id"));
                estoque.setRua(rs.getInt("rua"));
                estoque.setStatus(rs.getString("status"));
                estoque.setId_caixa(rs.getInt("cd_caixa"));
                resultado.add(estoque);
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return resultado;
    }

    public Estoque listarId(int id) {
        Connection conexao = null;
        Estoque estoque = new Estoque();
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                estoque.setId(rs.getInt("Id"));
                estoque.setRua(rs.getInt("rua"));
                estoque.setStatus(rs.getString("status"));
                estoque.setId_caixa(rs.getInt("cd_caixa"));
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return estoque;
    }
}
