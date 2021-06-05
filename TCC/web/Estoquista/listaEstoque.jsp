<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Estoque"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <title>Lista de Estoque</title>
        <style>a {color: black;
           text-decoration: none;}</style>
        </head>

        <body>



            <div class="div2">

            <%
                ArrayList<Estoque> listaEstoque = (ArrayList<Estoque>) request.getAttribute("ListaEstoque");
            %>

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

                            <li><a href="Estoquista\estoquista.jsp">Área do Estoquista</a></li>

                            <li><a href="Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="tabelasUser">
            <h1>Lista Estoque</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Rua</th>
                        <th>Status</th>
                        <th>Id Caixa</th>
                        <th>Excluir</th>
                        <th>Editar</th>
                    </tr>
                </thead>

                <tbody>

                    <%                for (Estoque estoque : listaEstoque) {
                    %>

                    <tr>
                        <td><%=estoque.getId()%></td> 
                        <td><%=estoque.getRua()%></td>
                        <td> <%=estoque.getStatus()%> </td>
                        <td> <%=estoque.getId_caixa()%> </td>
                        <td> <a href="<%=request.getContextPath()%>/ControleEstoque?Confirma=Excluir&txtId=<%=estoque.getId()%>">
                                <img id="excluir" src="CSS/Imagens_1/excluir.png" style="width: 30px;">
                            </a></td>
                        <td> <a href="<%=request.getContextPath()%>/ControleEstoque?Confirma=Alterar_1&txtId=<%=estoque.getId()%>">
                                <img id="editar" src="CSS/Imagens_1/editar.png" style="width: 30px;">
                            </a></td>
                    </tr>


                    <%
                        }
                    %>

                </tbody>
            </table>

            <a id="voltar" href="http://localhost:8080/TCC/Estoquista/estoquista.jsp">Voltar</a>

            <div class="header">
                <span class="title">DSaaS</span>
                <p class="subtitle">Estocagem</p>
                <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
            </div>  

            <footer class="fotterHome" style="top: 670px;
                                        background-color: white;" >
                <h2>Fale Conosco</h2>
                <div style="position:absolute;top:5px; left: -462px;">
                <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
                <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
                </div>
            </footer>

    </body>
</html>
