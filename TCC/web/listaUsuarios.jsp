
<%@page import="modelo.Funcionario"%>
<%@page import="modelo.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pessoal"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Usuarios</title>
        <style>a {color: black;
           text-decoration: none;}</style>
    </head>
    <body>
        <h1>Lista de Pessoa Física</h1>
        <%
            ArrayList<Pessoal> listaPessoal = (ArrayList<Pessoal>) request.getAttribute("ListaPessoal");
            ArrayList<Empresa> listaEmpresa = (ArrayList<Empresa>) request.getAttribute("ListaEmpresa");
            ArrayList<Funcionario> listaFuncionario = (ArrayList<Funcionario>) request.getAttribute("ListaFuncionario");
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Excluir</th>
                    <th>Editar</th>
                </tr>
            </thead>

            <tbody>

                <%
                    for (Pessoal pes : listaPessoal) {
                %>

                <tr>
                    <td><%= pes.getId()%></td> 
                    <td><%= pes.getNome()%></td>
                    <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Excluir&txtId=<%=pes.getId()%>">X</a></td>  
                </tr>


                <%
                    }
                %>

            </tbody>
        </table>


        <h1>Lista de Empresas</h1>        
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome Social</th>
                    <th>Nome Fantasia</th>
                    <th>Excluir</th>
                    <th>Editar</th>
                </tr>
            </thead>

            <tbody>

                <%
                    for (Empresa emp : listaEmpresa) {
                %>

                <tr>
                    <td><%= emp.getId()%></td> 
                    <td><%= emp.getNomeSocial()%></td>
                    <td> <%= emp.getNomeFantasia()%> </td>
                    <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Excluir&txtId=<%=emp.getId()%>">X</a></td>
                </tr>


                <%
                    }
                %>

            </tbody>
        </table>

        <h1>Lista de Funcionários</h1>        
        <table border="1">
            <thead>
                <tr>
                    <th>ID Funcionario</th>
                    <th>Nome</th>
                    <th>Função</th>
                    <th>Excluir</th>
                    <th>Editar</th>
                </tr>
            </thead>

            <tbody>

                <%
                    for (Funcionario func : listaFuncionario) {
                %>

                <tr>
                    <td><%= func.getIdFunc()%></td> 
                    <td><%= func.getNome()%></td>
                    <td> <%= func.getFuncao()%> </td>
                    <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Excluir&txtId=<%=func.getIdFunc()%>">X</a></td>
                </tr>


                <%
                    }
                %>

            </tbody>
        </table>               


        <a href="http://localhost:8080/TCC/Gerente/gerente.jsp">Voltar</a>         

    </body>
</html>
