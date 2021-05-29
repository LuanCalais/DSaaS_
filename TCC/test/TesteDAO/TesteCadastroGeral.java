
package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Pessoal;

public class TesteCadastroGeral {

    public static void main(String[] args) {

        Endereco end = new Endereco();
        Pessoal user = new Pessoal();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("11111111");
        end.setLogadouro("Rua TesteTeste");
        end.setBairro("Jardim Teste 2");
        end.setNumero(669);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("emailtesteGeralMaisUm@teste.com");
        user.setTelefone("11111111");
        user.setCelular("22222222");
        user.setEndereco(end);
        user.setSenha("senhaTesteMaisUm");
        int idUser = dao.CadastrarUsuario(user);
        
        user.setNome("Fulaninho de teste Geral3");
        user.setCpf("111111113");
        user.setSexo('M');
        user.setId(idUser);
        dao.CadastrarPessoal(user);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
