package TesteDAO;

import dao.CaixaDAO;
import modelo.Solicitacoes;

public class TesteCadastroSolicitacoes {

    public static void main(String[] args) {
        
        CaixaDAO dao = new CaixaDAO();
        Solicitacoes solicita = new Solicitacoes();
        
        solicita.setEmail("joaquim@mail.com");
        solicita.setCd_caixa(3);
        dao.CadastrarSolicitacao(solicita);
        
        System.out.println("Solicitação efetuada com sucesso!");
    }
    
}
