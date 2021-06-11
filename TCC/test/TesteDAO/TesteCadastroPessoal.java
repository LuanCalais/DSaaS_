package TesteDAO;

import dao.UsuarioDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Pessoal;

public class TesteCadastroPessoal {

    public static void main(String[] args) {
        //Pesquisar Passagem de date pra sql
        
        Pessoal usuario = new Pessoal();
        usuario.setNome("Fulaninho");
        usuario.setCpf("44444444444");
        usuario.setSexo('M');
        usuario.setId(295);
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.CadastrarPessoal(usuario);
        
        System.out.println("Cadastrado com sucesso!!!");
        
    }
    
}
