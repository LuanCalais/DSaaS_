package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Funcionario;


public class TesteCadastroFuncionario {


    public static void main(String[] args) {
        
        
        Endereco end = new Endereco();
        Funcionario user = new Funcionario();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("CEPCEP243");
        end.setLogadouro("Rua TesteFunc433");
        end.setBairro("Jardim TesteFunc433");
        end.setNumero(11);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("testeFunc43@teste.com");
        user.setTelefone("TELTEL433");
        user.setCelular("CELCEL433");
        user.setEndereco(end);
        user.setSenha("senhaTesteFunc433");
        int idUser = dao.CadastrarUsuario(user);
        
        user.setNome("Funcionario 4");
        user.setCpf("CPFCPF448");
        user.setSexo('M');
        user.setId(idUser);
        int idPessoal = dao.CadastrarPessoal(user);
        
        user.setIdFunc(242);
        user.setFuncao("Gerente");
        user.setTurno("Noturno");
        user.setId(idUser);
        user.setIdPessoal(idPessoal);
        dao.CadastrarFuncionario(user);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
