package TesteDAO;

import dao.EstoqueDAO;
import modelo.Estoque;

public class TesteListarIDEstoque {

    public static void main(String[] args) {

        EstoqueDAO dao = new EstoqueDAO();
        int id = 105;
        Estoque e = dao.listarId(id);

        System.out.println("Id: " + e.getId());
        System.out.println("Rua: " + e.getRua());
        System.out.println("Status: " + e.getStatus());
        System.out.println("Caixa: " + e.getId_caixa());

    }

}
