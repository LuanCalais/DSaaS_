<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela de Cadastros</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
    </head>
    <body>
            <h1>Cadastro Pessoal</h1>
            
            <img src="CSS/Imagens_1/cad_Pessoal.png" style="
                                                    position: absolute;
                                                    top: 600px;
                                                    left: 750px;
                                                    " >
            
            <div class="div2">
            <p id="p1_home"> Unidade São Paulo-SP (11) 4546-6464 <br>
                Unidade Sorocaba-SP  (15) 4230-4204<br>
                Mogi das Cruzes-SP  (11) 4736-6238
            </p>
        
        <div class="wrapper">
        <div class="nav">
            <div class="logo">
                <img id="logo" src="CSS/Imagens_1/DSaaS_Logotipo.png">
            </div>
            
            <div class="menu" >
            <ul>
                
                <li><a href="home.jsp">Home</a></li>    
            
                <li><a href="Logar.jsp">Logar</a></li>  
        
                <li><a href="Gerente\gerente.jsp" >Área do Gerente</a></li>
        
                <li><a href="Estoquista\estoquista.jsp">Área do Estoquista</a></li>
        
                <li><a href="Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
            </ul>
        </div>
       </div>
      </div>
     </div>
            
            <div class="cadastroPes">
            <form id="FCadastro" method="POST" action="ControleCadastro">

                    <legend>Cadastro de Pessoa Física</legend>
                    Pessoal <input id="btn1" type="radio" name="rdTipo" value="Pessoal" required autofocus ><br>
                    Empresa <input id="btn2" type="radio" name="rdTipo" value="Empresa" onclick="location.href = 'FEmpresa.jsp'"><br>
                    Funcionário <input id="btn3" type="radio" name="rdTipo" value="Funcionario" onclick="location.href='FFuncionario.jsp'"><br>
                    Nome:<br><input type="text" name="txtNome" maxlength="50" required><br>
                    CPF:<br> <input type="text" name="txtCpf" maxlength="11" required><br>
                    Sexo: <select name="txtSexo">
                            <option value="M">M</option>
                            <option value="F">F</option>
                          </select><br>
                    E-mail:<br> <input type="email" name="txtEmail" maxlength="50" required><br>
                    
                    <fieldset>
                    CEP:<br> <input type="text" name="txtCep" maxlength="15" required><br>
                    Logadouro:<br> <input type="text" name="txtLogadouro" maxlength="50" required><br>
                    Bairro:<br> <input type="text" name="txtBairro" maxlength="30" required><br>
                    Nº:<br> <input type="number" name="txtNumero" required><br>
                    Complemento(Opicional):<br> <input type="text" name="txtComplemento">
                    </fieldset>
                    
                    Dara de Nascimento:<br> <input type="date" name="txtDataNasc"><br>
                    Telefone:<br> <input type="text" name="txtTelefone" maxlength="11"  placeholder="xxxxx-xxxx"><br>
                    Celular:<br> <input type="text" name="txtCelular" maxlength="11" placeholder="xxxxx-xxxx"><br>
                    Senha:<br> <input type="password" name="txtSenha" required>
                
                <input id="BtnConfirma" type="submit" name="Confirma" value="Cadastrar">
                
             </form>
            </div>
            
        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  
            
        
        <footer class="fotterHome" style="top: 1380px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
        </footer>
        
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
