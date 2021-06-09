package TesteDAO;

import dao.EstoqueDAO;
import modelo.Solicitacoes;

public class TesteConfirmaEstoque {

    public static void main(String[] args) {
        
        EstoqueDAO dao = new EstoqueDAO();
        Solicitacoes sol = new Solicitacoes();
        
        sol.setCd_caixa(108);
        sol.setStatus("Ocupado");
        sol.setCd_estoque(116);
        
        dao.confirmaEstoque(sol);
        
        System.out.println("Confirmado com sucesso!");
        
    }
    
}
