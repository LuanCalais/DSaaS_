
package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Pessoal;

public class TesteCadastroGeral {

    public static void main(String[] args) {

        Endereco end = new Endereco();
        Pessoal user = new Pessoal();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("000000000");
        end.setLogadouro("Rua Jocalhão");
        end.setBairro("Jardim Teste 1");
        end.setNumero(111);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("emailtesteGeralUfa@teste.com");
        user.setTelefone("90239230");
        user.setCelular("012392332");
        user.setEndereco(end);
        user.setSenha("senhaTesteGeralUltima2");
        int idUser = dao.CadastrarUsuario(user);
        
        user.setNome("Fulaninho de teste Geral2");
        user.setCpf("111111112");
        user.setSexo('M');
        user.setId(idUser);
        dao.CadastrarPessoal(user);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
