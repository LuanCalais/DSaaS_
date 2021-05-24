package TesteDAO;

import dao.UsuarioDAO;
import modelo.Endereco;

public class TesteCadastroEndereco {

    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        end.setCep("08775029");
        end.setLogadouro("Rua A");
        end.setBairro("Jardim B");
        end.setNumero(65);
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.CadastrarEndereco(end);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
