package TesteDAO;

import dao.CaixaDAO;
import java.util.ArrayList;
import modelo.Caixa;

public class TesteListarCaixas {

    public static void main(String[] args) {
        
        CaixaDAO dao = new CaixaDAO();
        ArrayList<Caixa> caixa = dao.listarCaixas();
        
        for(Caixa c : caixa){
            System.out.println(c.getId_caixa());
            System.out.println(c.getTipo());
            System.out.println(c.getDescricao());
            System.out.println(c.getQuantidade());
            System.out.println(c.getCd_usuario());
            System.out.println(c.getTotal());
        }
        
    }
    
}
