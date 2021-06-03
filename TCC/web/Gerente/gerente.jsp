<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal Gerente</title>
        <style>a {
                color: black;
                text-decoration: none;}</style>
        </head>
        <body>
            <h1>Página Principal do gerente</h1>

            <h2>Gerenciador de Caixas</h2>  
            <form id="F1" method="POST" action="ControleCaixas">

            <input id="confirma" type="submit" name="Confirma" value="Cadastrar" href=".../index.html"> 
            <input id="listar" type="submit" name="Confirma" value="Listar"> 
            <input id="listarId" type="submit" name="Confirma" value="Listar ID"> 
            <input id="deletar" type="submit" name="Confirma" value="Deletar"> 
            <input id="alterar" type="submit" name="Confirma" value="Alterar"><br>

        </form>

        <h2>Gerenciador de Usuários</h2>  
        <form id="F1" method="POST" action=".../ControleUsuarios"> 
            <input id="listar" type="submit" name="Confirma" value="Listar"> <br>
            <input id='listarId' type="submit" name="Confirma" value="Listar ID"> <input type="number" nome="txtId">
        </form>
        <a href=".../FPessoal.jsp">Cadastrar Novo Usuário</a><br>
        <a href=".../home.jsp" >Home</a>

    </body>
</html>
