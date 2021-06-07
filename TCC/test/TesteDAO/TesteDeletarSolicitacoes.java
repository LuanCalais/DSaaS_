package TesteDAO;

import dao.CaixaDAO;
import modelo.Solicitacoes;

public class TesteDeletarSolicitacoes {

    public static void main(String[] args) {
        
        CaixaDAO dao = new CaixaDAO();
        Solicitacoes sol = new Solicitacoes();
        
        sol.setId_solicitacoes(1);
        dao.deletarSolicitacoes(sol);
        
        System.out.println("Solicitacao Deletada com sucesso!!!");
        
    }
    
}
