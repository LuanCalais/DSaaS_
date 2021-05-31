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
                    Nome Social: <input type="text" name="txtNomeSoc" maxlength="50" required><br>
                    Nome Fantasia: <input type="text" name="txtNomeFant" maxlength="50" required><br>
                    CNPJ: <input type="text" name="txtCNPJ" maxlength="14" required><br>
                    E-mail: <input type="email" name="txtEmail" maxlength="50" required><br>
                    
                    <fieldset>
                    CEP: <input type="text" name="txtCep" maxlength="15" required><br>
                    Logadouro: <input type="text" name="txtLogadouro" maxlength="50" required><br>
                    Bairro: <input type="text" name="txtBairro" maxlength="30" required><br>
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
