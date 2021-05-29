package TesteDAO;

import static java.lang.System.in;
import modelo.Funcionario;

public class TesteHerancaFunc {

    public static void main(String[] args) {
        
        Funcionario func = new Funcionario();
        
        func.setNome("Mônica");
        func.setCelular("11975522122");
        func.setCpf("451.434.242-34");
        func.setEmail("Joca@gmail.com");
        func.setFuncao("Gerente");
        func.setIdFunc(1920);
        func.setSexo('F');
        func.setTurno("Diurno");
        
        System.out.println(func.getNome() + " \n" +
                           func.getFuncao() + " \n" +
                           func.getSexo() + " \n" +
                           func.getTurno());
        
    }
    
}
