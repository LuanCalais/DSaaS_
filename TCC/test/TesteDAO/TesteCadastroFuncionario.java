package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Funcionario;


public class TesteCadastroFuncionario {


    public static void main(String[] args) {
        
        
        Endereco end = new Endereco();
        Funcionario user = new Funcionario();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("CEPCEP");
        end.setLogadouro("Rua TesteFunc");
        end.setBairro("Jardim TesteFunc");
        end.setNumero(324);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("testeFunc@teste.com");
        user.setTelefone("TELTEL");
        user.setCelular("CELCEL");
        user.setEndereco(end);
        user.setSenha("senhaTesteFunc");
        int idUser = dao.CadastrarUsuario(user);
        
        user.setNome("Funcionario 1");
        user.setCpf("CPFCPFCPF");
        user.setSexo('M');
        user.setId(idUser);
        int idPessoal = dao.CadastrarPessoal(user);
        
        user.setIdFunc(123);
        user.setFuncao("Gerente");
        user.setTurno("Diurno");
        user.setId(idUser);
        user.setIdPessoal(idPessoal);
        dao.CadastrarFuncionario(user);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
