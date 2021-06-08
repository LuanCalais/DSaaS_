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

    public static final String INSERT_SOL = "INSERT INTO solicitacoes(data_solicitacao, cd_usuario, cd_caixa, status) VALUES(CURRENT_DATE, (SELECT id FROM usuario WHERE email = ?), ?, ?)";
    public static final String LISTAR_SOL = "SELECT * FROM view_solicitacoes";
    public static final String LISTAR_ID_SOL = "SELECT * FROM view_solicitacoes WHERE id = ?";
    public static final String LISTAR_SOL_USU = "SELECT * FROM view_solicitacoes WHERE email = ?";
    public static final String DELETE_SOL = "DELETE FROM solicitacoes WHERE id = ?";
    public static final String INSERT_CAIXA_SOL = "INSERT INTO caixa(tipo, descricao, quantidade, cd_usuario, data_confirm, total) VALUES(?, ?, ?, (SELECT id FROM usuario WHERE email = ?), CURRENT_DATE, ?)";
    public static final String INSERT = "INSERT INTO caixa(tipo, descricao, quantidade, cd_usuario, data_confirm, total) VALUES(?, ?, ?, ?, CURRENT_DATE, ?)";
    public static final String LISTAR = "SELECT * FROM caixa";
    public static final String LISTAR_ID = "SELECT * FROM caixa WHERE cd_usuario = (SELECT id FROM usuario WHERE email = ?)";
    public static final String DELETE = "DELETE FROM caixa WHERE id = ?";
    public static final String UPDATE = "UPDATE caixa SET tipo = ?, descricao = ?, quantidade = ?, total = ? WHERE id = ?";
    public static final String CONFIRMA = "UPDATE solicitacoes SET status = ?";

    public void CadastrarSolicitacao(Solicitacoes solicita) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_SOL);
            pstmt.setString(1, solicita.getEmail());
            pstmt.setInt(2, solicita.getCd_caixa());
            pstmt.setString(3, solicita.getStatus());
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

    public int cadastrarCaixaSolicitacao(Caixa caixa) {
        Connection conexao = null;
        int returnedId = 0;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_CAIXA_SOL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, caixa.getTipo());
            pstmt.setString(2, caixa.getDescricao());
            pstmt.setInt(3, caixa.getQuantidade());
            pstmt.setString(4, caixa.getEmail_usu());
            pstmt.setDouble(5, caixa.getTotal());
            returnedId = pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) {
                returnedId = keys.getInt("id");
            } else {
                returnedId = -1;
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
        return returnedId;
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
                sol.setCd_usuario(rs.getInt("cd_usuario"));
                sol.setEmail(rs.getString("email"));
                sol.setTipo(rs.getString("tipo"));
                sol.setDscricao(rs.getString("descricao"));
                sol.setQuantidade(rs.getInt("quantidade"));
                sol.setStatus(rs.getString("status"));
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

    public Solicitacoes listarIdSol(int id) {
        Connection conexao = null;
        Solicitacoes sol = new Solicitacoes();
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR_ID_SOL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sol.setId_solicitacoes(rs.getInt("id"));
                sol.setCd_usuario(rs.getInt("cd_usuario"));
                sol.setEmail(rs.getString("email"));
                sol.setTipo(rs.getString("tipo"));
                sol.setDscricao(rs.getString("descricao"));
                sol.setQuantidade(rs.getInt("quantidade"));
                sol.setStatus(rs.getString("status"));
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

        return sol;
    }

    public void Confirma(Solicitacoes solicitacoes) {
        Connection conexao = null;
        try {

            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(CONFIRMA);
            pstmt.setString(1, solicitacoes.getStatus());
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

    public int CadastrarCaixa(Caixa caixa) {
        Connection conexao = null;
        int returnedId = 0;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, caixa.getTipo());
            pstmt.setString(2, caixa.getDescricao());
            pstmt.setInt(3, caixa.getQuantidade());
            pstmt.setInt(4, caixa.getCd_usuario());
            pstmt.setDouble(5, caixa.getTotal());
            returnedId = pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) {
                returnedId = keys.getInt("id");
            } else {
                returnedId = -1;
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

        return returnedId;

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

    public ArrayList<Caixa> listarCaixasUsuario(Caixa caixa) {
        ArrayList<Caixa> resultado = new ArrayList();
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR_ID);
            pstmt.setString(1, caixa.getEmail_usu());
            pstmt.execute();

            ResultSet rs = pstmt.executeQuery();

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
    
        public ArrayList<Solicitacoes> listarSolicitacoesUsuario(Solicitacoes solicita) {
        ArrayList<Solicitacoes> resultado = new ArrayList();
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(LISTAR_SOL_USU);
            pstmt.setString(1, solicita.getEmail());
            pstmt.execute();

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Solicitacoes sol = new Solicitacoes();
                sol.setId_solicitacoes(rs.getInt("id"));
                sol.setCd_usuario(rs.getInt("cd_usuario"));
                sol.setEmail(rs.getString("email"));
                sol.setTipo(rs.getString("tipo"));
                sol.setDscricao(rs.getString("descricao"));
                sol.setQuantidade(rs.getInt("quantidade"));
                sol.setStatus(rs.getString("status"));
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

    public void updateCaixa(Caixa caixa) {
        Connection conexao = null;
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, caixa.getTipo());
            pstmt.setString(2, caixa.getDescricao());
            pstmt.setInt(3, caixa.getQuantidade());
            pstmt.setDouble(4, caixa.getTotal());
            pstmt.setInt(5, caixa.getId_caixa());
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
}
