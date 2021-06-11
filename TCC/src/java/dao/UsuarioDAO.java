package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Pessoal;
import modelo.Usuario;
import util.ConectaBancoUsuario;

public class UsuarioDAO {
    
    public static final String INSERT_END = "INSERT INTO endereco(cep, logadouro, bairro, numero, complemento) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_USU = "INSERT INTO usuario(email, telefone, celular, cd_endereco, senha) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_PESSOAL = "INSERT INTO pessoal(nome, cpf, sexo, data_nasc, cd_usuario) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_EMPRESA = "INSERT INTO empresa(nomeSocial, nomeFantasia, cnpj, cd_usuario) VALUES(?, ?, ?, ?)";
    public static final String INSERT_FUNC = "INSERT INTO funcionario(idFunc, funcao, turno, cd_usuario, cd_pessoal) VALUES(?, ?, ?, ?, ?)";
    public static final String INSERT_GERENTE = "INSERT INTO gerente(nomeFunc, cd_funcionario) VALUES(?, ?)";
    public static final String INSERT_RECEPCAO = "INSERT INTO recepcao(nomeFunc, cd_funcionario) VALUES(?, ?)";
    public static final String INSERT_ESTOQUE = "INSERT INTO estoquista(nomeFunc, cd_funcionario) VALUES(?, ?)";
    public static final String SELECT_ALL_PES = "SELECT * FROM view_usuarios";
    public static final String SELECT_ALL_EMP = "SELECT * FROM view_empres";
    public static final String SELECT_ALL_FUNC = "SELECT * FROM view_func";
    public static final String DELETE_USER = "DELETE FROM usuario WHERE id = ?";
    public static final String UPDATE_USUARIO = "UPDATE usuario SET email = ?, telefone = ?, celular = ?, senha = ? WHERE id = ?";
    public static final String UPDATE_PESSOAL = "UPDATE pessoal SET nome = ?, sexo = ? WHERE cd_usuario = ?";
    public static final String UPDATE_EMPRESA = "UPDATE empresa SET nomeSocial = ?, nomeFantasia = ? WHERE cd_usuario = ?";
    public static final String UPDATE_FUNC = "UPDATE funcionario SET funcao = ?, turno = ? WHERE idFunc = ?";
    public static final String SELECT_MAIL = "SELECT * FROM usuario WHERE email = ?";
    
    
    public int CadastrarEndereco(Endereco endereco){
        Connection conexao = null;
        int returnedId = 0;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_END, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, endereco.getCep());
            pstmt.setString(2, endereco.getLogadouro());
            pstmt.setString(3, endereco.getBairro());
            pstmt.setInt(4, endereco.getNumero());
            pstmt.setString(5, endereco.getComplemento());
            returnedId = pstmt.executeUpdate();
            
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()){
                returnedId = keys.getInt("id");
            }
            else returnedId = -1; 
            
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
        return returnedId;
    }
    
    public int CadastrarUsuario(Usuario usuario){
        Connection conexao = null;
        int returnedId = 0;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_USU, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getTelefone());
            pstmt.setString(3, usuario.getCelular());
            pstmt.setInt(4, usuario.getEndereco().getId());
            pstmt.setString(5, usuario.getSenha());
            returnedId = pstmt.executeUpdate();
            
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()){
                returnedId = keys.getInt("Id");
            }
            else returnedId = -1;
            
            
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
        
        return returnedId;
        
    }
    
    public int CadastrarPessoal(Pessoal usuario){
        Connection conexao = null;
        int returnedId;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_PESSOAL, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getCpf());
            pstmt.setString(3, String.valueOf(usuario.getSexo()));
            pstmt.setDate(4, usuario.getData_nasc());
            pstmt.setInt(5, usuario.getId());
            returnedId = pstmt.executeUpdate();
            
            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()){
                returnedId = keys.getInt("Id");
            }
            else returnedId = -1;
            
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
        
        return returnedId;
        
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
    
    public void CadastrarFuncionario(Funcionario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_FUNC);
            
            pstmt.setInt(1, usuario.getIdFunc());
            pstmt.setString(2, usuario.getFuncao());
            pstmt.setString(3, usuario.getTurno());
            pstmt.setInt(4, usuario.getId());
            pstmt.setInt(5, usuario.getIdPessoal());
            pstmt.execute();
            
        }catch(Exception ex){
            System.out.println("Erro Cadastrar Funcionario: " + ex.getMessage());
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
    
    public void CadastrarGerente(Funcionario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_GERENTE);
            pstmt.setString(1, usuario.getNome());
            pstmt.setInt(2, usuario.getIdFunc());
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
    
    public void CadastrarRecepcao(Funcionario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_RECEPCAO);
            pstmt.setString(1, usuario.getNome());
            pstmt.setInt(2, usuario.getIdFunc());
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
    
    public void CadastrarEstoque(Funcionario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_ESTOQUE);
            pstmt.setString(1, usuario.getNome());
            pstmt.setInt(2, usuario.getIdFunc());
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
    
    public ArrayList<Pessoal> listarPessoal(){
        ArrayList<Pessoal> resultado = new ArrayList();
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_PES);
            
            while(rs.next()){
                Pessoal user = new Pessoal();
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                resultado.add(user);
            }
            
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
        return resultado;
    }
    
    public ArrayList<Empresa> listaEmpresa(){
        ArrayList<Empresa> resultado = new ArrayList();
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_EMP);
            
            while(rs.next()){
                Empresa user = new Empresa();
                user.setId(rs.getInt("Id"));
                user.setNomeSocial(rs.getString("nomeSocial"));
                user.setNomeFantasia(rs.getString("nomeFantasia"));
                resultado.add(user);
            }
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
        return resultado;
    }
    
    public ArrayList<Funcionario> listaFuncionario(){
        ArrayList<Funcionario> resultado = new ArrayList();
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL_FUNC);
            
            while(rs.next()){
                Funcionario user = new Funcionario();
                user.setId(rs.getInt("id"));
                user.setIdFunc(rs.getInt("idFunc"));
                user.setNome(rs.getString("nome"));
                user.setFuncao(rs.getString("funcao"));
                resultado.add(user);
            }
            
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
        return resultado;
    }
    
    public void deletarUsuario(Usuario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_USER);
            pstmt.setInt(1, usuario.getId());
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
    
    
    public void updateUsuario(Usuario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_USUARIO);
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getTelefone());
            pstmt.setString(3, usuario.getCelular());
            pstmt.setString(4, usuario.getSenha());
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
    
    public void updatePessoal(Pessoal usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_PESSOAL);
            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, String.valueOf(usuario.getSexo()));
            //pstmt.setDate(3, usuario.getData_nasc());
            pstmt.setInt(3, usuario.getId());
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
    
    public void updateEmpresa(Empresa usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_EMPRESA);
            pstmt.setString(1, usuario.getNomeSocial());
            pstmt.setString(2, usuario.getNomeFantasia());
            pstmt.setInt(3, usuario.getId());
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
    
    public void updateFuncionario(Funcionario usuario){
        Connection conexao = null;
        try{
            conexao = ConectaBancoUsuario.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_FUNC);
            pstmt.setString(1, usuario.getFuncao());
            pstmt.setString(2, usuario.getTurno());
            pstmt.setInt(3, usuario.getIdFunc());
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
}
