<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Caixa</title>
    </head>
    <body>
        
        <h1>Cadastrar Caixa de Documentos</h1>
        <form id="FCadastro" method="POST" action="ControleCaixas">
            Tipo de Documentos: <input type="text" name="txtTipo" maxlength="11" required placeholder="Recibos"><br>
            Descrição: <input type="text" name="txtDescricao" maxlength="50" required placeholder="Serviços prestados" ><br>
            Quantidade: <input type="number" name="txtQuantidade" max="100" required><br>
            
            <input id="confirma" type="submit" name="Confirma" value="Cadastrar">
            
        </form>
        
        <a href="home.jsp" >Home</a>
        
        
    </body>
</html>
