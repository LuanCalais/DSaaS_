package TesteDAO;

import dao.CaixaDAO;
import modelo.Caixa;
import modelo.CaixaBuilder;

public class TesteDeletarCaixa {

    public static void main(String[] args) {

        CaixaDAO dao = new CaixaDAO();

        Caixa caixa = new CaixaBuilder()
                .comId_caixa(3)
                .comTipo("Revistas")
                .comDescricao("Quadrinhos antigos 2")
                .comQuantidade(32)
                .constroi();

        dao.updateCaixa(caixa);

        System.out.println("Caixa alterada com sucesso!!!");

    }

}
