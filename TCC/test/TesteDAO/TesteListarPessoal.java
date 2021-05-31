package TesteDAO;

import dao.UsuarioDAO;
import java.util.ArrayList;
import modelo.Pessoal;

public class TesteListarPessoal {

    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Pessoal> listaPessoal = dao.listarPessoal();
        
        for(Pessoal p : listaPessoal){
            System.out.println("Id: " + p.getId());
            System.out.println("Nome: " + p.getNome());
        }
        
    }
    
}
