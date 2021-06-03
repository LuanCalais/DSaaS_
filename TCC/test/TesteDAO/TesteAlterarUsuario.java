package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Usuario;

public class TesteAlterarUsuario {

    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        UsuarioDAO dao = new UsuarioDAO();
        Usuario user = new Usuario();
        
        end.setCep("02020202");
        end.setLogadouro("Rua teste Update");
        end.setBairro("Jardim teste Update");
        end.setNumero(5940);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("testeUpdateJava@mail.com");
        user.setTelefone("UpdateJava");
        user.setCelular("UpdateJava");
        user.setEndereco(end);
        user.setSenha("testeSenhaUpdateJ");
        user.setId(175);
        dao.updateUsuario(user);
        
        System.out.println("Alterado com Sucesso!!!");
        
    }
    
}
