package TesteDAO;

import dao.UsuarioDAO;
import modelo.Empresa;
import modelo.Endereco;

public class TesteCadastroGeralEmpresa {

    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        Empresa emp = new Empresa();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("01010101");
        end.setLogadouro("Rua teste Empresa");
        end.setBairro("Jardim teste Empresa");
        end.setNumero(505);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
       
        emp.setEmail("testeEmpresa4@teste.com");
        emp.setEndereco(end);
        emp.setCelular("00294444");
        emp.setTelefone("02444432");
        emp.setSenha("senhaTeste4");
        int idUser = dao.CadastrarUsuario(emp);
        
        emp.setNomeSocial("Teste Fulano INK");
        emp.setNomeFantasia("Lojão do João");
        emp.setCnpj("02444442");
        emp.setId(idUser);
        dao.CadastrarEmpresa(emp);
        
        System.out.println("Cadastrado com Sucesso!!!");
    }
    
}
