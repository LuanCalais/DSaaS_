package TesteDAO;

import dao.CaixaDAO;
import modelo.Caixa;
import modelo.CaixaBuilder;
import modelo.Usuario;

public class TesteCaixaBuilder {

    public static void main(String[] args) {

        CaixaDAO dao = new CaixaDAO();

        Caixa caixa = new CaixaBuilder()
                .comId_caixa(2)
                .comTipo("Documentos3")
                .comDescricao("Recibos Pagos2")
                .comQuantidade(15)
                .comCd_usuario(200)
                .constroi();

        dao.CadastrarCaixa(caixa);

        System.out.println("Id: " + caixa.getId_caixa()
                + "\nTipo: " + caixa.getTipo()
                + "\nDescrição: " + caixa.getDescricao()
                + "\nQuantidade: " + caixa.getQuantidade()
                + "\nUsuario: " + caixa.getCd_usuario()
                + "\nTotal: " + caixa.getTotal());

    }

}
