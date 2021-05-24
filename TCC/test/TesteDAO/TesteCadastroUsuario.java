package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Usuario;

public class TesteCadastroUsuario {

    public static void main(String[] args) {
        
        Usuario usu = new Usuario();
        Endereco end = new Endereco();
        end.setId(3);
        usu.setEmail("usuario2@teste.com");
        usu.setTelefone("11111-1111");
        usu.setCelular("22222-2222");
        usu.setEndereco(end);
        usu.setSenha("TesteSenha2");
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.CadastrarUsuario(usu);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
