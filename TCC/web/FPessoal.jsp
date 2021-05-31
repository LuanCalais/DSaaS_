<%-- 
    Document   : FPessoal
    Created on : 30/05/2021, 17:38:39
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela de Cadastros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div lang="pt-br">
            <h1>Cadastro Pessoal</h1>
            
            <form id="FCadastro" method="POST" action="ControleCadastro">
                <fieldset>
                    <legend>Informações de cadastro</legend>
                    <input id="btn1" type="radio" name="rdTipo" value="Pessoal" required autofocus >
                    <input id="btn2" type="radio" name="rdTipo" value="Empresa" onclick="location.href = 'FEmpresa.jsp'">
                    <input id="btn3" type="radio" name="rdTipo" value="Funcionario" onclick="location.href='FFuncionario.jsp'">
                    Nome: <input type="text" name="txtNome" maxlength="50" required><br>
                    CPF: <input type="text" name="txtCpf" maxlength="11" required><br>
                    Sexo: <select name="txtSexo">
                            <option value="M">M</option>
                            <option value="F">F</option>
                          </select><br>
                    E-mail: <input type="email" name="txtEmail" maxlength="50" required><br>
                    
                    <fieldset>
                    CEP: <input type="text" name="txtCep" maxlength="15" required><br>
                    Logadouro: <input type="text" name="txtLogadouro" maxlength="50" required><br>
                    Bairro: <input type="text" name="txtBairro" maxlength="30" required><br>
                    Nº: <input type="number" name="txtNumero" required><br>
                    Complemento(Opicional): <input type="text" name="txtComplemento">
                    </fieldset>
                    
                    Dara de Nascimento: <input type="date" name="txtDataNasc"><br>
                    Telefone: <input type="text" name="txtTelefone" maxlength="11"  placeholder="xxxxx-xxxx"><br>
                    Celular: <input type="text" name="txtCelular" maxlength="11" placeholder="xxxxx-xxxx"><br>
                    Senha: <input type="password" name="txtSenha" required>
                </fieldset>
                
                <input id="confirma" type="submit" name="Confirma" value="Cadastrar">
                
            </form>
            
        </div>
        
            <%/*
                Integer verifica = (Integer) request.getAttribute("Verifica");
                if(verifica == null){
                    */
            %>
               <!-- <h1>E-mail já cadastrado</h1> -->
            <% 
               // }
            %>
        
    </body>
</html>
