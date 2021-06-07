package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Caixa;
import modelo.Documentos;
import modelo.Solicitacoes;
import util.ConectaBancoUsuario;

public class CaixaDAO {

    public static final String INSERT_SOL = "INSERT INTO solicitacoes(data_solicitacao, cd_usuario, cd_caixa) VALUES(CURRENT_DATE, (SELECT id FROM usuario WHERE email = ?), ?)";
    public static final String INSERT = "INSERT INTO caixas(tipo, descricao, quantidade, cd_usuario) VALUES(?, ?, ?, ?)";
    
        public void CadastrarSolicitacao(Solicitacoes solicita){
            Connection conexao = null;
            try{
                conexao = ConectaBancoUsuario.getConexao();
                PreparedStatement pstmt = conexao.prepareStatement(INSERT_SOL);
                pstmt.setString(1, solicita.getEmail());
                pstmt.setInt(2, solicita.getCd_caixa());
                pstmt.execute();
                
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }
            finally{
                try{
                    conexao.close();
                }catch(SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        }
    
    
        public void CadastrarCaixa(Caixa caixa){
            Connection conexao = null;
            try{
                
                conexao = ConectaBancoUsuario.getConexao();
                PreparedStatement pstmt = conexao.prepareStatement(INSERT);
                pstmt.setString(1, caixa.getTipo());
                pstmt.setString(2, caixa.getDescricao());
                pstmt.setInt(3, caixa.getQuantidade());
                pstmt.setInt(4, caixa.getUsuario().getId());
                pstmt.execute();
                
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }
            finally{
                try{
                    conexao.close();
                }catch(SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        }
    
}
