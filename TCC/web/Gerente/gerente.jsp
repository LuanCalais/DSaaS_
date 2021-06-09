<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal Gerente</title>
        <link rel="stylesheet" href="..\CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <style>a {
                color: black;
                text-decoration: none;}</style>
        </head>

        <body>

            <img src="../CSS/Imagens_1/Gerente.png" style="
            position: absolute;
            top: 750px;
            left: 550px;
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

                            <li> <a href="..\Cliente\cliente.jsp">Área do Cliente</a></li>

                            <li><a href="..\Estoquista\estoquista.jsp">Área do Estoquista</a></li>

                            <li><a href="..\Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="FormGerente" style="top: 400px;" >
            <h1>Página Principal do gerente</h1>
            <div class="GerenteUsuarios">
                <h2>Gerenciador de Caixas</h2>  

                <form id="F1" method="POST" action=".../ControleCaixas">

                    <fieldset>
                        <legend>Solicitações</legend>
                        <input id="listarId" type="submit" name="Confirma" value="Buscar ID"><input id="listaId" type="number" name="txtId"><br> 
                        <input id="listar" type="submit" name="Confirma" value="Listar Solicitados"> 
                    </fieldset>

                    <fieldset>
                        <legend>Caixas Armazenadas</legend>
                        <input id="listarId" type="submit" name="Confirma" value="Buscar ID"><input id="listaId" type="number" name="txtId"><br>
                        <input id="lista" type="submit" name="Confirma" value="Listar Caixas">
                    </fieldset>
                </form>


                <form id="F1" method="POST" action=".../ControleUsuarios"> 
                    <fieldset style="width: 300px;">
                        <legend>Gerenciador de Usuários</legend>
                        Ver todos os usuários: <input id="listar" type="submit" name="Confirma" value="Listar" style="position:absolute; left: 240px; top: 390px;"> <br>
                    </fieldset>
                </form>
            </div>
        </div> 

        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  


        <footer class="fotterHome" style="top: 1070px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="../CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="../CSS/Imagens_1/insta_logo.png"></a>
        </footer>

    </body>
</html>
