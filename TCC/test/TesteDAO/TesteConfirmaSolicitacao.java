package TesteDAO;

import dao.CaixaDAO;
import modelo.Solicitacoes;

public class TesteConfirmaSolicitacao {

    public static void main(String[] args) {
        
        CaixaDAO dao = new CaixaDAO();
        Solicitacoes solicita = new Solicitacoes();
        
        solicita.setStatus("Confirmado");
        solicita.setId_solicitacoes(9);
        
        dao.confirmaSolicitacao(solicita);
        
        System.out.println("Confirmado com sucesso!");
        
    }
    
}
