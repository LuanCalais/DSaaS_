
<%@page import="modelo.Funcionario"%>
<%@page import="modelo.Empresa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Pessoal"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS\style_1.css">
        <link href="https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap" rel="stylesheet">
        <title>Lista de Usuarios</title>
        <style>a {color: black;
           text-decoration: none;}</style>
        </head>
        
        <body>

            <div class="div2">

            <%
                ArrayList<Pessoal> listaPessoal = (ArrayList<Pessoal>) request.getAttribute("ListaPessoal");
                ArrayList<Empresa> listaEmpresa = (ArrayList<Empresa>) request.getAttribute("ListaEmpresa");
                ArrayList<Funcionario> listaFuncionario = (ArrayList<Funcionario>) request.getAttribute("ListaFuncionario");
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
            <h1>Lista de Pessoa Física</h1>
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Excluir</th>
                        <th>Editar</th>
                    </tr>
                </thead>

                <tbody>

                    <%
                        for (Pessoal pes : listaPessoal) {
                    %>

                    <tr>
                        <td><%= pes.getId()%></td> 
                        <td><%= pes.getNome()%></td>
                        <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Excluir&txtId=<%=pes.getId()%>">
                                <img id="excluir" src="CSS/Imagens_1/excluir.png" style="width: 30px;">
                            </a></td>
                        <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Alterar_1&Tipo=Pessoal&txtId=<%=pes.getId()%>">
                                <img id="editar" src="CSS/Imagens_1/editar.png" style="width: 30px;">
                            </a></td>
                    </tr>


                    <%
                        }
                    %>

                </tbody>
            </table>


            <h1>Lista de Empresas</h1>        
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome Social</th>
                        <th>Nome Fantasia</th>
                        <th>Excluir</th>
                        <th>Editar</th>
                    </tr>
                </thead>

                <tbody>

                    <%
                        for (Empresa emp : listaEmpresa) {
                    %>

                    <tr>
                        <td><%= emp.getId()%></td> 
                        <td><%= emp.getNomeSocial()%></td>
                        <td> <%= emp.getNomeFantasia()%> </td>
                        <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Excluir&txtId=<%=emp.getId()%>">
                                <img id="excluir" src="CSS/Imagens_1/excluir.png" style="width: 30px;">
                            </a></td>
                        <td> <a name="lTipo" value="Empresa" href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Alterar_1&Tipo=Empresa&txtId=<%=emp.getId()%>">
                                <img id="editar" src="CSS/Imagens_1/editar.png" style="width: 30px;">
                            </a></td>
                    </tr>


                    <%
                        }
                    %>

                </tbody>
            </table>

            <h1>Lista de Funcionários</h1>        
            <table border="1">
                <thead>
                    <tr>
                        <th>ID do Usuário</th>
                        <th>ID Funcionario</th>
                        <th>Nome</th>
                        <th>Função</th>
                        <th>Excluir</th>
                        <th>Editar</th>
                    </tr>
                </thead>

                <tbody>

                    <%
                        for (Funcionario func : listaFuncionario) {
                    %>

                    <tr>
                        <td><%= func.getId()%></td>
                        <td><%= func.getIdFunc()%></td> 
                        <td><%= func.getNome()%></td>
                        <td> <%= func.getFuncao()%> </td>
                        <td> <a href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Excluir&txtId=<%=func.getId()%>">
                                <img id="excluir" src="CSS/Imagens_1/excluir.png" style="width: 30px;">
                            </a></td>
                        <td> <a name="lTipo" value="Empresa" href="<%=request.getContextPath()%>/ControleUsuarios?Confirma=Alterar_1&Tipo=Funcionario&txtId=<%=func.getId()%>&txtIdFunc=<%=func.getIdFunc()%>">
                                <img id="editar" src="CSS/Imagens_1/editar.png" style="width: 30px;">
                            </a></td>
                    </tr>


                    <%
                        }
                    %>

                </tbody>
            </table>
                    
            <a id="voltar" href="http://localhost:8080/TCC/Gerente/gerente.jsp">Voltar</a>
                    
        </div>
                    
        <img id="galera" src="CSS/Imagens_1/Config.jpg" style="position: absolute; top: 1090px; left: 800px; width: 540px;">
                    
                <div class="header">
            <span class="title">DSaaS</span>
            <p class="subtitle">Estocagem</p>
            <button><a id="SobreNos" href="http://localhost:8080/TCC/SobreNos.html">Sobre Nós</a></button>
        </div>  


        <footer class="fotterHome" style="top: 1770px;" >
            <h2>Fale Conosco</h2>
            <a href="https://www.facebook.com/profile.php?id=100068708837828" target="_blank"><img id="face" src="CSS/Imagens_1/face_logo.png"></a>
            <a href="https://www.instagram.com/dsaas_estocagem/" target="_blank"> <img id="insta" src="CSS/Imagens_1/insta_logo.png"></a>
        </footer>
        
        
        <a href="http://localhost:8080/TCC/Gerente/gerente.jsp">Voltar</a>         

    </body>
</html>
