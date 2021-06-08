package TesteDAO;

import dao.CaixaDAO;
import java.util.ArrayList;
import modelo.Solicitacoes;

public class TesteListagemSolicitaUsu {

    public static void main(String[] args) {

        CaixaDAO dao = new CaixaDAO();
        Solicitacoes solicita = new Solicitacoes();
        solicita.setEmail("alterado@mail.com");
        ArrayList<Solicitacoes> resultado = dao.listarSolicitacoesUsuario(solicita);

        for (Solicitacoes s : resultado) {
            System.out.println(s.getId_solicitacoes());
            System.out.println(s.getCd_usuario());
            System.out.println(s.getEmail());
            System.out.println(s.getTipo());
            System.out.println(s.getDscricao());
            System.out.println(s.getQuantidade());
            System.out.println(s.getStatus());
        }

    }

}
