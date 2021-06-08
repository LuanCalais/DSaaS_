package TesteDAO;

import dao.CaixaDAO;
import java.util.ArrayList;
import modelo.Caixa;

public class TesteListaCaixasUsuario {

    public static void main(String[] args) {

        CaixaDAO dao = new CaixaDAO();
        Caixa caixa = new Caixa();
        caixa.setEmail_usu("alterado@mail.com");
        ArrayList<Caixa> resultado = dao.listarCaixasUsuario(caixa);

        for (Caixa c : resultado) {
            System.out.println(c.getId_caixa());
            System.out.println(c.getTipo());
            System.out.println(c.getDescricao());
            System.out.println(c.getQuantidade());
            System.out.println(c.getCd_usuario());
            System.out.println(c.getTotal());
        }

    }

}
