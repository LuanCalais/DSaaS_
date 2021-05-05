<%-- 
    Document   : listarId
    Created on : 24/04/2021, 14:36:55
    Author     : luanc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Documentos"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            Integer id = (Integer) request.getAttribute("MostrarId");
        %>
        <h1>Seu id é</h1>
        <h1><%= id %></h1>
    </body>
</html>
