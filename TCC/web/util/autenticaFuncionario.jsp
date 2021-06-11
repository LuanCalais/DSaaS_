
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="util.ConectaBancoUsuario"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>

<%
    String email = request.getParameter("txtEmail");
    String senha = request.getParameter("txtSenha");

    String VERIFICA = "SELECT * FROM view_login WHERE email = '" + email + "' AND senha = '" + senha + "' ";

    try {

        Connection conexao = ConectaBancoUsuario.getConexao();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(VERIFICA);
        if (rs.next()) {
            String funcao = rs.getString("funcao");
            HttpSession sessao = request.getSession(true);
            session.setAttribute("Mensagem", "Usuário Autenticado!");
            session.setAttribute("Funcao", funcao);
            response.sendRedirect("../Cliente/cliente.jsp");
        } else {
            session.setAttribute("Mensagem", "Funcionário não existe!<br> Favor se autenticar, ou efetuar cadastro");
            session.setAttribute("login", "false");
            response.sendRedirect("../LogarFuncionario.jsp");
        }

    } catch (SQLException ex) {
        throw new RuntimeException(ex);
    }


%>
