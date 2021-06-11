
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="util.ConectaBancoUsuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%
    String email = request.getParameter("txtEmail");
    String senha = request.getParameter("txtSenha");

    String VERIFICA = "SELECT * FROM usuario WHERE email = '" + email + "' AND senha = '" + senha + "' ";

    try {
        
        Connection conexao = ConectaBancoUsuario.getConexao();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(VERIFICA);
        if(rs.next()){
            session.setAttribute("Mensagem", "Usuário Autenticado!");
            session.setAttribute("login", "true");
            response.sendRedirect("../Cliente/cliente.jsp");
        }else{
            session.setAttribute("Mensagem", "Usuário não existe!<br> Favor se autenticar, ou efetuar cadastro");
            session.setAttribute("login", "false");
            response.sendRedirect("../Logar.jsp");
        }
        
    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }


%>
