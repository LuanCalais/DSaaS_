
package TesteDAO;

import dao.EstoqueDAO;
import modelo.Estoque;

public class TesteCadastroEstoque {

    public static void main(String[] args) {
        EstoqueDAO dao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        
        estoque.setReferencia('C');
        estoque.setRua(26);
        estoque.setStatus("Vazio");
        dao.cadastraEstoque(estoque);
        
        System.out.println("Estoque Cadastrado com Sucesso");
        
    }
    
}
