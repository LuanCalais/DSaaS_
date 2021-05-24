package TesteDAO;

import dao.UsuarioDAO;
import modelo.Empresa;

public class TesteCadastroEmpresa {

    public static void main(String[] args) {
        
        Empresa usuario = new Empresa();
        usuario.setNomeSocial("Fulanos.inc");
        usuario.setNomeFantasia("Armarinhos Fulano's");
        usuario.setCnpj("00000000000000");
        usuario.setId(15);
        
        UsuarioDAO dao = new UsuarioDAO();
        dao.CadastrarEmpresa(usuario);
        
        System.out.println("Cadastrado com sucesso!");
        
    }
    
}
