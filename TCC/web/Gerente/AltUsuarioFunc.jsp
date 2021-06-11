<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela de Alteracao Funcionario</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
    </head>
    <body>

        <%
            if (session.getAttribute("login") != "true") {
                session.setAttribute("Mensagem", "Infelizmente você não tem acesso a isso :(<br>Se autentique para acessar");
                response.sendRedirect("../LogarFuncionario.jsp");
            }
        %>

        <h1>Alteração Funcionário</h1>

        <img src="CSS/Imagens_1/cad_Funcionario.png" style="
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

                            <li> <a href="Cliente\cliente.jsp">Área do Cliente</a></li>

                            <li><a href="Estoquista\estoquista.jsp">Área do Estoquista</a></li>

                            <li><a href="Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <%
            int id = (Integer) request.getAttribute("id");
            int idFunc = (Integer) request.getAttribute("idFunc");
        %>

        <div class="CadastroFunc" >
            <form id="FCadastro" method="POST" action="ControleUsuarios?Tipo=Funcionario&txtId=<%=id%>&txtIdFunc=<%=idFunc%>">
                <legend>Alteração Funcionário DSaaS</legend>

                Id do Usuário: <input type="text" value="<%=id%>" disabled style="width: 55px; text-align: center;"><br>
                Id DSaaS: <br> <input type="text" value="<%=idFunc%>" disabled style="width: 55px; text-align: center;"><br>
                Nome: <br><input type="text" name="txtNome" maxlength="50" required><br>
                Função DSaaS: <br><select name="txtFuncao">
                    <option value="Gerente">Gerente</option>
                    <option value="Recepcao" >Recepcionista</option>
                    <option value="Estoque" >Estoquista</option>
                </select><br>
                Turno: <br><select name="txtTurno">
                    <option value = "Noturno">Noturno</option>
                    <option value="Diurno" >Diurno</option>
                </select><br>
                Sexo: <select name="txtSexo">
                    <option value="M">M</option>
                    <option value="F">F</option>
                </select><br>
                E-mail: <br><input type="email" name="txtEmail" maxlength="50" required><br>

                Dara de Nascimento: <br> <input type="date" name="txtDataNasc"><br>
                Telefone: <br> <input type="text" name="txtTelefone" maxlength="11"  placeholder="xxxxx-xxxx"><br>
                Celular: <br> <input type="text" name="txtCelular" maxlength="11" placeholder="xxxxx-xxxx"><br>
                Senha: <br> <input type="password" name="txtSenha" required>

                <input id="BtnConfirma" type="submit" name="Confirma" value="Alterar">

            </form>
        </div>           

        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  


        <footer class="fotterHome" style="top: 1470px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
        </footer>



    </body>
</html>
