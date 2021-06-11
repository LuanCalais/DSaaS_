<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina principal da Recepcao</title>
        <link rel="stylesheet" href="..\CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <style>a {
                color: black;
                text-decoration: none;}
            </style>
        </head>
        <body>

            <%
                if (session.getAttribute("login") != "true") {
                    session.setAttribute("Mensagem", "Infelizmente você não tem acesso a isso :(<br>Se autentique para acessar");
                    response.sendRedirect("../LogarFuncionario.jsp");
                }
            %>


            <img src="../CSS/Imagens_1/Gerente.png" style="
            position: absolute;
            top: 850px;
            left: -70px;
            ">

        <div class="div2">
            <p id="p1_home"> Unidade São Paulo-SP (11) 4546-6464 <br>
                Unidade Sorocaba-SP  (15) 4230-4204<br>
                Mogi das Cruzes-SP  (11) 4736-6238
            </p>

            <div class="wrapper">
                <div class="nav">
                    <div class="logo">
                        <img id="logo" src="../CSS/Imagens_1/DSaaS_Logotipo.png">
                    </div>

                    <div class="menu" >
                        <ul>

                            <li><a href="..\home.jsp">Home</a></li>    

                            <li><a href="..\Cliente\cliente.jsp">Área do Cliente</a></li>

                            <li><a href="..\Gerente\gerente.jsp"> Área do Gerente</a></li>

                            <li><a href="..\Estoquista\estoquista.jsp">Área do Estoquista</a></li>


                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="FormGerente" style="top: 400px;">
            <h1>Página Principal do Recepcionista</h1>
            <div class="GerenteUsuarios">
                <h2>Gerenciador de Solicitações</h2>  

                <form id="F1" method="POST" action=".../ControleCaixas">

                    <fieldset>
                        <legend>Solicitações</legend>
                        <input id="listarId" type="submit" name="Confirma" value="Buscar ID Solicitados"><input id="listaId" type="number" name="txtId"><br> 
                        <input id="listar" type="submit" name="Confirma" value="Listar Solicitados"> 
                    </fieldset>
                </form>    

                <form id="F1" method="POST" action=".../ControleCaixas">    
                    <fieldset>
                        <legend>Caixas Armazenadas</legend>
                        <input id="listarId" type="submit" name="Confirma" value="Buscar ID Caixa"><input id="listaId" type="number" name="txtId"><br>
                        <input id="lista" type="submit" name="Confirma" value="Listar Caixas">
                    </fieldset>
                </form>


                <h2>Cadastrar nova caixa</h2>  
                <form id="F1" method="POST" action=".../ControleCaixas"> 

                    Tipo: <select name="txtTipo" required>
                        <option value="Documento">Documento</option>
                        <option value="Recibo">Recibo</option>
                        <option value="Pessoal">Pessoal</option>
                        <option value="Outros" >Outros</option>
                    </select><br>

                    Descrição:<br> <input id="descricao" type="text" name="txtDescricao" maxlength="30" required style="background-color: white;"><br>

                    Quantidade:<br> <input id="Quantidade" type="number" name="txtQuantidade" required style="background-color: white;"><br>

                    Código do Usuário: <br> <input id="cd_usuario" type="number" name="txtUsuario" required style="background-color: white; width: 80px;"><br>

                    Código do Estoque: <br> <input id="cd_estoque" type="number" name="txtEstoque" required style="background-color: white; width: 80px;"><br>

                    <input id="BtnConfirma" type="submit" name="Confirma" value="Cadastrar Caixa" style="position: absolute;
                           left: 237px; top: 620px;">

                </form>


            </div>
        </div> 

        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  


        <footer class="fotterHome" style="top: 1170px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="../CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="../CSS/Imagens_1/insta_logo.png"></a>
        </footer>

    </body>
</html>
