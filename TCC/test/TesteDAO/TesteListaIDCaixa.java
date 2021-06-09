package TesteDAO;

import dao.CaixaDAO;
import modelo.Caixa;

class TesteListaIDCaixa {

    public static void main(String[] args) {

        CaixaDAO dao = new CaixaDAO();
        int id = 143;

        Caixa c = dao.listarCaixaId(id);

        System.out.println(c.getId_caixa());
        System.out.println(c.getTipo());
        System.out.println(c.getDescricao());
        System.out.println(c.getQuantidade());
        System.out.println(c.getCd_usuario());
        System.out.println(c.getTotal());

    }

}
