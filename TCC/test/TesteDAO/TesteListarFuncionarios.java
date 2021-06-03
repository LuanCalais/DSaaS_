package TesteDAO;

import dao.UsuarioDAO;
import java.util.ArrayList;
import modelo.Funcionario;

public class TesteListarFuncionarios {

    public static void main(String[] args) {
        
        UsuarioDAO dao = new UsuarioDAO();
        ArrayList<Funcionario> func = dao.listaFuncionario();
        
        for(Funcionario f : func){
            System.out.println("Id de funcionario: " + f.getIdFunc());
            System.out.println("Nome: " + f.getNome());
            System.out.println("Função: " + f.getFuncao());
        }
        
    }
    
}
