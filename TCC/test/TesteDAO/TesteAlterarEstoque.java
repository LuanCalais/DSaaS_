package TesteDAO;

import dao.EstoqueDAO;
import modelo.Estoque;

public class TesteAlterarEstoque {

    public static void main(String[] args) {
        
        EstoqueDAO dao = new EstoqueDAO();
        Estoque estoque = new Estoque();
        
        estoque.setRua(66);
        estoque.setStatus("Vazio");
        estoque.setId(104);
        dao.updateEstoque(estoque);
        
        System.out.println("Usuário alterado com sucesso!");
        
    }
    
}
