package TesteDAO;

import dao.CaixaDAO;
import java.util.ArrayList;
import modelo.Solicitacoes;

public class TesteListarSolicitacoes {

    public static void main(String[] args) {
        
        CaixaDAO dao = new CaixaDAO();
        ArrayList<Solicitacoes> lista = dao.listarSolicitacoes();
        
        for(Solicitacoes s : lista){
            System.out.println("ID: " + s.getId_solicitacoes());
            System.out.println("E-mail: " + s.getEmail());
            System.out.println("Descrição: " + s.getDscricao());
    }
  }
}
