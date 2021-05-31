package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaBancoUsuario {
    
    public static Connection getConexao(){
        Connection conexao = null;
        try{
            
            Class.forName("org.postgresql.Driver");//Driver de conexão 
            conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/PFC_", "postgres", "125678943");
            
        }catch(ClassNotFoundException ex){
            throw new RuntimeException(ex);
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
        
        return conexao;   
    }
}
