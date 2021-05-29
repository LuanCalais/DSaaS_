package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Caixa;
import modelo.Documentos;
import util.ConectaBancoUsuario;

public class CaixaDAO {

    public static final String INSERT = "INSERT INTO caixas(tipo, descricao, quantidade, cd_usuario) VALUES(?, ?, ?, ?)";
    
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
