package TesteDAO;

import dao.CaixaDAO;
import dao.UsuarioDAO;
import modelo.Caixa;
import modelo.Endereco;
import modelo.Pessoal;

public class TesteCadastroCaixa {

    public static void main(String[] args) {
        
        Endereco end = new Endereco();
        Pessoal user = new Pessoal();
        UsuarioDAO dao = new UsuarioDAO();
        
        end.setCep("lalalalala2");
        end.setLogadouro("Rua TesteTesteCaixa2");
        end.setBairro("Jardim Teste Caixa2");
        end.setNumero(6124);
        int idEnd = dao.CadastrarEndereco(end);
        end.setId(idEnd);
        
        user.setEmail("emailtesteCaixa2@teste.com");
        user.setTelefone("lololo2");
        user.setCelular("lilili2");
        user.setEndereco(end);
        user.setSenha("senhaTesteCaixa2");
        int idUser = dao.CadastrarUsuario(user);
        
        user.setNome("Fulaninha de teste Caixa2");
        user.setCpf("lululu2");
        user.setSexo('F');
        user.setId(idUser);
        dao.CadastrarPessoal(user);
        
        Caixa caixa = new Caixa();
        CaixaDAO daob = new CaixaDAO();
        
        
        caixa.setTipo("Documento");
        caixa.setDescricao("Exames em desuso");
        caixa.setQuantidade(3);
        caixa.setUsuario(user);
        daob.CadastrarCaixa(caixa);
        
        System.out.println("Caixa Cadastrada!!!");
        
    }
    
}
