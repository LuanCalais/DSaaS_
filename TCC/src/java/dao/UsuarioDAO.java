package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Pessoal;
import modelo.Usuario;
import util.ConectaBancoUsuario;

public class UsuarioDAO {
    
    public static final String INSERT_END = "INSERT INTO endereco(cep, logadouro, bairro, numero) VALUES(?, ?, ?, ?)";
    public static final String INSERT_USU = "INSERT INTO usuario(email, telefone, celular, cd_endereco, senha) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_PESSOAL = "INSERT INTO pessoal(nome, cpf, sexo, data_nasc, cd_usuario) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_EMPRESA = "INSERT INTO empresa(nomeSocial, nomeFantasia, cnpj, cd_usuario) VALUES(?, ?, ?, ?)";
    
    public void CadastrarEndereco(Endereco endereco){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_END);
            pstmt.setString(1, endereco.getCep());
            pstmt.setString(2, endereco.getLogadouro());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setInt(4, endereco.getNumero());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        finally{
            try{
                conexao.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }
    
    public void CadastrarUsuario(Usuario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_USU);
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getTelefone());
            pstmt.setString(3, usuario.getCelular());
            pstmt.setInt(4, usuario.getEndereco().getId());
            pstmt.setString(5, usuario.getSenha());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        finally{
           try{
               conexao.close();
           }catch(SQLException ex){
               throw new RuntimeException(ex);
           } 
        }   
    }
    
    public void CadastrarPessoal(Pessoal usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_PESSOAL);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, String.valueOf(usuario.getSexo()));
            pstmt.setDate(4, usuario.getData_nasc());
            pstmt.setInt(5, usuario.getId());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        finally{
            try{
                conexao.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }
            
    
    public void CadastrarEmpresa(Empresa usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_EMPRESA);
            
            pstmt.setString(1, usuario.getNomeSocial());
            pstmt.setString(2, usuario.getNomeFantasia());
            pstmt.setString(3, usuario.getCnpj());
            pstmt.setInt(4, usuario.getId());
            pstmt.execute();
            
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
        finally{
            try{
                conexao.close();
            }catch(SQLException ex){
                throw new RuntimeException(ex);
            }
        }
    }
    
        /*  TESTAR SE ESSA É UMA BOA SOLUÇÃO===================================
    
        conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_EMPRESA);
            PreparedStatement pstmt2 = conexao.prepareStatement(INSERT_USU);
            pstmt2.setString(1, usuario.getEmail());
            pstmt2.setString(2, usuario.getTelefone());
            pstmt2.setString(3, usuario.getCelular());
            pstmt2.setInt(4, usuario.getEndereco().getId());
            
            pstmt.setString(1, usuario.getNomeSocial());
            pstmt.setString(2, usuario.getNomeFantasia());
            pstmt.setString(3, usuario.getCnpj());
            pstmt.setInt(4, usuario.getId());
    */
    
    
}
