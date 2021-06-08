package TesteDAO;

import dao.CaixaDAO;
import modelo.Caixa;
import modelo.CaixaBuilder;

public class TesteDeletarCaixa {

    public static void main(String[] args) {

        CaixaDAO dao = new CaixaDAO();
        Caixa caixa = new Caixa();
        
        caixa.setId_caixa(18);
        
        dao.deletarCaixa(caixa);
        
        System.out.println("Caixa deletada com sucesso!");

    }

}
