<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionario</title>
    </head>
    <body>
        <h1>Cadastro Funcionário</h1>
        
                    <form id="FCadastro" method="POST" action="ControleCadastro">
                <fieldset>
                    <legend>Informações de cadastro</legend>
                    <input id="btn1" type="radio" name="rdTipo" value="Pessoal" onclick="location.href = 'FPessoal.jsp'">
                    <input id="btn2" type="radio" name="rdTipo" value="Empresa" onclick="location.href='FEmpresa.jsp'">
                    <input id="btn3" type="radio" nome="rdTipo" value="Funcionario" required autofocus>
                    
                    Nome: <input type="text" name="txtNome" maxlength="50" required><br>
                    Identificador DSaaS: <input type="number" name="txtIdFunc" maxlength="10" required><br>
                    Função DSaaS: <select name="txtFuncao">
                                    <option value="Gerente">Gerente</option>
                                    <option value="Recepcao" >Recepcionista</option>
                                    <option value="Estoque" >Estoquista</option>
                                  </select><br>
                    Turno: <select name="txtTurno">
                            <option value = "Noturno">Noturno</option>
                            <option value="Diurno" >Diurno</option>
                           </select><br>
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
        
            <a href="home.jsp" >Home</a>
        
        
    </body>
</html>
