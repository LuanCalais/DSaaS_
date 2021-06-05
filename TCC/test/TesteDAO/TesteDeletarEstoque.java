package TesteDAO;

import dao.EstoqueDAO;
import modelo.Estoque;

public class TesteDeletarEstoque {

    public static void main(String[] args) {
        
        EstoqueDAO dao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        
        estoque.setId(103);
        dao.deletarEstoque(estoque);
        
        System.out.println("Estoque deletado com sucesso!");
    }
    
}
