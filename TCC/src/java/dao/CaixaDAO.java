package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Caixa;
import modelo.Documentos;
import modelo.Solicitacoes;
import util.ConectaBancoUsuario;

public class CaixaDAO {

    public static final String INSERT_SOL = "INSERT INTO solicitacoes(data_solicitacao, cd_usuario, cd_caixa) VALUES(CURRENT_DATE, (SELECT id FROM usuario WHERE email = ?), ?)";
    public static final String LISTAR_SOL = "SELECT * FROM view_solicitacoes";
    public static final String DELETE_SOL = "DELETE FROM solicitacoes WHERE id = ?";
    public static final String INSERT = "INSERT INTO caixa(tipo, descricao, quantidade, cd_usuario, data_confirm, total) VALUES(?, ?, ?, ?, CURRENT_DATE, ?)";
    public static final String LISTAR = "SELECT * FROM caixa";
    public static final String DELETE = "DELETE FROM caixa WHERE id = ?";
    public static final String UPDATE = "UPDATE caixa SET tipo = ?, descricao = ?, quantidade = ?, total = ? WHERE id = ?";

    public void CadastrarSolicitacao(Solicitacoes solicita) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_SOL);
            pstmt.setString(1, solicita.getEmail());
            pstmt.setInt(2, solicita.getCd_caixa());
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

    public void deletarSolicitacoes(Solicitacoes solicita) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_SOL);
            pstmt.setInt(1, solicita.getId_solicitacoes());
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

    public ArrayList<Solicitacoes> listarSolicitacoes() {
        ArrayList<Solicitacoes> resultado = new ArrayList();
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(LISTAR_SOL);

            while (rs.next()) {
                Solicitacoes sol = new Solicitacoes();
                sol.setId_solicitacoes(rs.getInt("id"));
                sol.setEmail(rs.getString("email"));
                sol.setDscricao(rs.getString("descricao"));
                resultado.add(sol);
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

    public void CadastrarCaixa(Caixa caixa) {
        Connection conexao = null;
        try {

            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, caixa.getTipo());
            pstmt.setString(2, caixa.getDescricao());
            pstmt.setInt(3, caixa.getQuantidade());
            pstmt.setInt(4, caixa.getCd_usuario());
            pstmt.setDouble(5, caixa.getTotal());
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

    public ArrayList<Caixa> listarCaixas() {
        ArrayList<Caixa> resultado = new ArrayList();
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(LISTAR);

            while (rs.next()) {
                Caixa ca = new Caixa();
                ca.setId_caixa(rs.getInt("id"));
                ca.setTipo(rs.getString("tipo"));
                ca.setDescricao(rs.getString("descricao"));
                ca.setQuantidade(rs.getInt("quantidade"));
                ca.setUsuario(rs.getInt("cd_usuario"));
                ca.setTotal(rs.getDouble("total"));
                resultado.add(ca);
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

    public void deletarCaixa(Caixa caixa) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE);
            pstmt.setInt(1, caixa.getId_caixa());
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
    
    public void updateCaixa(Caixa caixa){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, caixa.getTipo());
            pstmt.setString(2, caixa.getDescricao());
            pstmt.setInt(3, caixa.getQuantidade());
            pstmt.setDouble(4, caixa.getTotal());
            pstmt.setInt(5, caixa.getId_caixa());
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

}
