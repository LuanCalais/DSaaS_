package TesteDAO;

import dao.UsuarioDAO;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Pessoal;
import modelo.Usuario;

public class TesteAlterarUsuario {

    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        UsuarioDAO dao = new UsuarioDAO();
        /*
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
        */
        
        /*
        Pessoal user = new Pessoal();
        end.setCep("03030303");
        end.setLogadouro("Rua teste Update Pessoal");
        end.setBairro("Jardim teste Update Pessoal");
        end.setNumero(5941);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setNome("Update Pessoal");
        user.setSexo('F');
        user.setId(190);
        dao.updatePessoal(user);
        
        System.out.println("Alterado com sucesso!!!");*/
        /*
        Empresa user = new Empresa();
        
        user.setNomeSocial("TesteAltEmp");
        user.setNomeFantasia("testeAltEmpFant");
        user.setId(175);
        
        dao.updateEmpresa(user);
        
        System.out.println("Alterado com sucesso!!!");*/
        
        Funcionario user = new Funcionario();
        
        user.setFuncao("Teste Alt Func");
        user.setTurno("Teste Alt");
        user.setIdFunc(222);
        dao.updateFuncionario(user);
        
        System.out.println("Usuário Alterado com sucesso!!! ");
        
    }
        
        
    
}
