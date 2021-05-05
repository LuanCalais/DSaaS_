<%-- 
    Document   : listaestoque
    Created on : 24/04/2021, 12:27:32
    Author     : luanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Documentos"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Documentos</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Lista Documentos</h1>
        
        <%
            ArrayList<Documentos> listaDocumentos = (ArrayList<Documentos>) request.getAttribute("listaDocumentos");
        %>
        
          <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Descrição</th>
                    <th>Data</th>
                    <th>Tipo</th>
                </tr>
            </thead>
            
            <tbody>
                
                <%
                    //Para cada cliente c na listaCliente executar...
                    for(Documentos d : listaDocumentos){
                %>
                
                <tr>
                    <td><%=d.getId()%></td> 
                   <td><%= d.getDescricao() %></td>
                    <td><%= d.getData() %></td>
                    <td><%= d.getTipo() %></td>
                </tr>
                
                
                <%
                    }
                %>
                
            </tbody>
            
        </table>
        
    </body>
</html>
