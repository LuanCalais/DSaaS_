<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal Estoquista</title>
        <link rel="stylesheet" href="..\CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <style>a {
                color: black;
                text-decoration: none;}</style>
        </head>

        <body>

            <img src="../CSS/Imagens_1/Gerente.png" style="
            position: absolute;
            top: 850px;
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

                            <li><a href="..\Estoquista\estoquista.jsp">Área do Estoquista</a></li>

                            <li><a href="..\Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>


        <div class="FormGerente">
            <h1>Página Principal do Estoquista</h1>
            <div class="GerenteUsuarios">
                <h2>Gerenciador de Estoque</h2>  

                <form id="F1" method="POST" action="ControleEstoque">
                    <input id="listarId" type="submit" name="Confirma" value="Buscar ID"><input id="listaId" type="number" nome="txtId"><br> 
                    <input id="listar" type="submit" name="Confirma" value="Listar"> 
                </form>

                <h2>Cadastrar novo estoque</h2>  
                <form id="F1" method="POST" action=".../ControleEstoque"> 

                    Referencia: <select name="txtReferencia">
                        <option value="A" >A</option><option value="B" >B</option><option value="C" >C</option><option value="D" >D</option><option value="E" >E</option><option value="F" >F</option>
                        <option value="G" >G</option><option value="H" >H</option><option value="I" >I</option><option value="J" >J</option><option value="K" >K</option><option value="L" >L</option>
                        <option value="M" >M</option><option value="M" >N</option><option value="O" >O</option><option value="P" >P</option><option value="Q" >Q</option><option value="R" >R</option>
                        <option value="S" >S</option><option value="T" >T</option><option value="U" >U</option><option value="V" >V</option><option value="W" >W</option><option value="X" >X</option>
                        <option value="Y" >Y</option><option value="Z" >Z</option>
                    </select><br>
                    Rua:<br> <input type="number" name="txtRua" maxlength="11" required><br>
                    
                    Status: <select name="txtStatus">
                        <option value="Ocupado">Ocupado</option>
                        <option value="Vazio">Vazio</option>
                    </select><br>

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
