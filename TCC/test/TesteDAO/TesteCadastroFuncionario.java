package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;
import modelo.Funcionario;


public class TesteCadastroFuncionario {


    public static void main(String[] args) {
        
        
        Endereco end = new Endereco();
        Funcionario user = new Funcionario();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("CEPCEP2432");
        end.setLogadouro("Rua TesteFunc4332");
        end.setBairro("Jardim TesteFunc4332");
        end.setNumero(111);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("FuncLucas@teste.com");
        user.setTelefone("TELTEL423");
        user.setCelular("CELCE2L433");
        user.setEndereco(end);
        user.setSenha("senhaTesteFunc2");
        int idUser = dao.CadastrarUsuario(user);
        
        user.setNome("Funcionario Lucas");
        user.setCpf("CPFC32323");
        user.setSexo('M');
        user.setId(idUser);
        int idPessoal = dao.CadastrarPessoal(user);
        
        user.setIdFunc(1232);
        user.setFuncao("Gerente");
        user.setTurno("Diurno");
        user.setId(idUser);
        user.setIdPessoal(idPessoal);
        dao.CadastrarFuncionario(user);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
