<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <title>Página Home</title>
    </head>
    <body>
        
        
        <img id="logo_1" src="CSS/Imagens_1/Logo.png" title="logo">
        <img id="estoque_1" src="CSS/Imagens_1/Estoque_1.jpg" title="Estoque">
        
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
                
                <li><a href="Logar.jsp">Logar</a></li>    
            
                <li><a href="FPessoal.jsp">Cadastrar</a></li>
        
                <li><a href="Gerente\gerente.jsp" >Área do Gerente</a></li>
        
                <li><a href="Estoquista\estoquista.jsp">Área do Estoquista</a></li>
        
                <li><a href="Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
            </ul>
        </div>
       </div>
      </div>
     </div>
        
        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  
        
        <div class="desc1" >
            <h2>O que é gestão de documentos?</h2>
            <p>A gestão de documentos é um conjunto de procedimentos <br>que permite a organização de forma eficiente e<br>
                segura, visando a localização rápida e o descarte no momento determinado.</p>
        </div>
            
        <div class="desc2" >
            <h2>Para quem é o nosso trabalho?</h2>
            <p>Nosso trabalho é destinado a pessoa física ou jurídica <br>
                que tenha o interesse de estocar quaisquer arquivos<br>
               que estejam em desuso, mas que possam ter sua importância futuramente<br>
               impossibilitando assim o descarte dos mesmos.</p>
        </div>
        
        <footer class="fotterHome" style="top: 1570px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
        </footer>
            
    </body>
</html>
