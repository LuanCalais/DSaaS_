package TesteDAO;

import dao.EstoqueDAO;
import java.util.ArrayList;
import modelo.Estoque;

public class TesteListarEstoque {

    public static void main(String[] args) {
        
        EstoqueDAO dao = new EstoqueDAO();
        ArrayList<Estoque> listaEstoque = dao.listarEstoque();
        
        for(Estoque e : listaEstoque){
            System.out.println("Id: " + e.getId());
            System.out.println("Rua: " + e.getRua());
            System.out.println("Status: " + e.getStatus());
            System.out.println("Caixa: " + e.getId_caixa());
        }   
    }
}
