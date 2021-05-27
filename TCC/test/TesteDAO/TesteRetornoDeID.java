package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Usuario;

public class TesteRetornoDeID {

    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        Usuario user = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("011111111");
        end.setLogadouro("Rua AAA");
        end.setBairro("Jardim Sicraninho");
        end.setNumero(903);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        System.out.println("Id do endereço: " + end.getId());
        
        user.setEmail("NaoAguentoMais@teste.com");
        user.setTelefone("912332323");
        user.setCelular("123092323");
        user.setEndereco(end);
        user.setSenha("RodaPorFavor");
        int idUser = dao.CadastrarUsuario(user);
        user.setId(idUser);
        
        System.out.println("Id do usuário: " + user.getId());
    }
}
