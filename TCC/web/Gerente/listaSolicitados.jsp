<%@page import="modelo.Solicitacoes"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <title>Lista de Solicitacoes</title>
        <style>a {color: black;
           text-decoration: none;}</style>
        </head>

        <body>



            <div class="div2">

            <%
                ArrayList<Solicitacoes> listaSolicitados = (ArrayList<Solicitacoes>) request.getAttribute("ListaSolicitados");
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
                            
                            <li><a href="Cliente\cliente.jsp">Área do Cliente</a></li>

                            <li><a href="Gerente\gerente.jsp">Área do Gerente</a></li>

                            <li><a href="Estoquista\estoquista.jsp">Área do Estoquista</a></li>

                            <li><a href="Recepcao\recepcao.jsp">Área do Recepcionista</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="tabelasUser" style="left:273px;" >
            <h1>Lista De Solicitações</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Usuário</th>
                        <th>Caixa</th>
                        <th>E-mail</th>
                        <th>Tipo</th>
                        <th>Descrição</th>
                        <th>Quantidade</th>
                        <th>Status</th>
                        <th>Excluir</th>
                        <th>Confirmar</th>
                    </tr>
                </thead>

                <tbody>

                    <%                for (Solicitacoes solicita : listaSolicitados) {
                    %>

                    <tr>
                        <td><%=solicita.getId_solicitacoes()%></td> 
                        <td> <%=solicita.getCd_usuario()%> </td>
                        <td> <%=solicita.getCd_caixa()%></td>
                        <td><%=solicita.getEmail()%></td>
                        <td> <%=solicita.getTipo()%></td>
                        <td> <%=solicita.getDscricao()%></td>
                        <td> <%=solicita.getQuantidade()%> </td>
                        <td> <%=solicita.getStatus()%></td>
                        <td> <a href="<%=request.getContextPath()%>/ControleCaixas?Confirma=Excluir_Sol&txtId=<%=solicita.getId_solicitacoes()%>">
                                <img id="excluir" src="CSS/Imagens_1/excluir.png" style="width: 30px;">
                            </a></td>
                        <td> <a href="<%=request.getContextPath()%>/ControleCaixas?Confirma=Confirmar_1&txtId=<%=solicita.getId_solicitacoes()%>&txtIdCaixa=<%=solicita.getCd_caixa()%>">
                                <img id="editar" src="CSS/Imagens_1/check.png" style="width: 30px;">
                            </a></td>

                    </tr>


                    <%
                        }
                    %>

           
                </tbody>
            </table>
        </div>         



        <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  




        <footer class="fotterHome" style="top: 1070px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
        </footer>

    </body>
</html>
