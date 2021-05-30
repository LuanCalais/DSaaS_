<%-- 
    Document   : FEmpresa
    Created on : 29/05/2021, 16:46:33
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro Empresa</h1>
            
            <form id="FCadastro" method="POST" action="ControleCadastro">
                <fieldset>
                    <legend>Informações de cadastro</legend>
                    <input id="btn1" type="radio" name="rdTipo" value="Pessoal" onclick="location.href = 'FPessoal.jsp'">
                    <input id="btn2" type="radio" name="rdTipo" value="Empresa" required autofocus>
                    <input id="btn3" type="radio" name="rdTipo" value="Funcionario" onclick="location.href = 'FFuncionario.jsp'">
                    Nome Social: <input type="text" name="txtNomeSoc" required><br>
                    Nome Fantasia: <input type="text" name="txtNomeFant" required><br>
                    CNPJ: <input type="text" name="txtCNPJ" required><br>
                    E-mail: <input type="email" name="txtEmail" required><br>
                    
                    <fieldset>
                    CEP: <input type="text" name="txtCep" required><br>
                    Logadouro: <input type="text" name="txtLogadouro" required><br>
                    Bairro: <input type="text" name="txtBairro" required><br>
                    Nº: <input type="number" name="txtNumero" required><br>
                    Complemento(Opicional): <input type="text" name="txtComplemento">
                    </fieldset>
                    
                    Telefone: <input type="text" name="txtTelefone" maxlength="11"  placeholder="xxxxx-xxxx"><br>
                    Celular: <input type="text" name="txtCelular" maxlength="11" placeholder="xxxxx-xxxx"><br>
                    Senha: <input type="password" name="txtSenha" required>
                </fieldset>
                
                <input id="confirma" type="submit" name="Confirma" value="Cadastrar">
                
            </form>
        
    </body>
</html>
