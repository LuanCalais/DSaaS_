package TesteDAO;

import dao.UsuarioDAO;
import modelo.Usuario;

public class TesteDelecaoDeDados {

    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = new Usuario();
        
        user.setId(20);
        dao.deletarUsuario(user);
        
        System.out.println("Delecao efetuada!!!");
    }
    
}
