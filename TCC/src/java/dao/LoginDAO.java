package dao;

import static dao.EstoqueDAO.SELECT_ID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Login;
import util.ConectaBancoUsuario;

public class LoginDAO {

    public static final String CONFIRMA = "SELECT * FROM view_login WHERE email = ? AND senha = ? ";

    public Login confirmaLogin(Login login) {
        Connection conexao = null;
        Login funcao = new Login();
        try {
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(CONFIRMA);
            pstmt.setString(1, login.getEmail());
            pstmt.setString(2, login.getSenha());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){ 
            funcao.setPerfil(rs.getString("funcao"));
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
        return funcao;
    }

}
