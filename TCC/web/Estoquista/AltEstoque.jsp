<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <title>Tela de Alteracao Estoque</title>
    </head>
    <body>

        <%
            if (session.getAttribute("login") != "true") {
                session.setAttribute("Mensagem", "Infelizmente você não tem acesso a isso :(<br>Se autentique para acessar");
                response.sendRedirect("../LogarFuncionario.jsp");
            }
        %>

        <h1>Alteração Dados Estoque</h1>

        <img src="CSS/Imagens_1/Logo.png" style="
             position: absolute;
             top: 600px;
             left: 600px;
             width: 700px;
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

                            <li><a href="http://localhost:8080/TCC/util/logout.jsp">Logout</a></li>
                            
                            <li><a href="home.jsp">Home</a></li>    

                            <li> <a href="Cliente\cliente.jsp">Área do Cliente</a></li>

                            <li><a href="Gerente\gerente.jsp">Área do Gerente</a></li>

                            <li><a href="Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <% int id = (Integer) request.getAttribute("id");%>

        <div class="cadastroEmp">
            <form id="FCadastro" method="POST" action="ControleEstoque?Confirma=Alterar&txtId=<%=id%>">

                <legend>Alteração Estoque</legend>
                Id do Estoque: <input type="text" value="<%=id%>" disabled style="width: 55px; text-align: center;" ><br>
                Rua:<br> <input type="number" name="txtRua" maxlength="11" required><br>

                Status: <select name="txtStatus">
                    <option value="Ocupado">Ocupado</option>
                    <option value="Vazio">Vazio</option>
                </select>

                <input id="BtnConfirma" type="submit" name="Confirma" value="Alterar">
            </form>
        </div>


        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  


        <footer class="fotterHome" style="top: 997px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
        </footer>


    </body>
</html>
