package controle;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Pessoal;
import modelo.Usuario;

@WebServlet(name = "ControleUsuarios", urlPatterns = {"/ControleUsuarios"})
public class ControleUsuarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String opc = request.getParameter("Confirma");

            if ("Cadastrar".equals(opc)) {

                String tipo = request.getParameter("rdTipo");
                
                UsuarioDAO dao = new UsuarioDAO();
                Endereco end = new Endereco();
                end.setCep(request.getParameter("txtCep"));
                end.setLogadouro(request.getParameter("txtLogadouro"));
                end.setBairro(request.getParameter("txtBairro"));
                int numero = Integer.parseInt(request.getParameter("txtNumero"));
                end.setNumero(numero);
                end.setComplemento(request.getParameter("txtComplemento"));
                int idEnd = dao.CadastrarEndereco(end);
                end.setId(idEnd);

                if ("Pessoal".equals(tipo)) {

                    Pessoal usuario = new Pessoal();
                    usuario.setEmail(request.getParameter("txtEmail"));
                    usuario.setTelefone(request.getParameter("txtTelefone"));
                    usuario.setCelular(request.getParameter("txtCelular"));
                    usuario.setEndereco(end);
                    usuario.setSenha(request.getParameter("txtSenha"));

                    /*
                Usuario verifica = Autenticador.AutenticaEmail(usuario);
                if(verifica == null){
                request.setAttribute("Verifica", verifica);
                request.getRequestDispatcher("FPessoal.jsp").forward(request, response);
                }*/
                    int idUser = dao.CadastrarUsuario(usuario);

                    usuario.setNome(request.getParameter("txtNome"));
                    usuario.setCpf(request.getParameter("txtCpf"));
                    String aux = (request.getParameter("txtSexo"));
                    char sexo = aux.charAt(0);
                    usuario.setSexo(sexo);
                    usuario.setId(idUser);

                    dao.CadastrarPessoal(usuario);

                    request.setAttribute("Mensagem", "Usuário cadastrado com sucesso com sucesso!");
                    request.getRequestDispatcher("sucesso.jsp").forward(request, response);

                } else {

                    if ("Empresa".equals(tipo)) {

                        Empresa usuario = new Empresa();
                        usuario.setEmail(request.getParameter("txtEmail"));
                        usuario.setTelefone(request.getParameter("txtTelefone"));
                        usuario.setCelular(request.getParameter("txtCelular"));
                        usuario.setEndereco(end);
                        usuario.setSenha(request.getParameter("txtSenha"));
                        int idUser = dao.CadastrarUsuario(usuario);

                        usuario.setNomeSocial(request.getParameter("txtNomeSoc"));
                        usuario.setNomeFantasia(request.getParameter("txtNomeFant"));
                        usuario.setCnpj(request.getParameter("txtCNPJ"));
                        usuario.setId(idUser);
                        dao.CadastrarEmpresa(usuario);

                        request.setAttribute("Mensagem", "Empresa cadastrada com sucesso com sucesso!");
                        request.getRequestDispatcher("sucesso.jsp").forward(request, response);

                    } else {

                        if ("Funcionario".equals(tipo)) {
                            System.out.println("Passei aqui 1");
                            Funcionario usuario = new Funcionario();
                            usuario.setEmail(request.getParameter("txtEmail"));
                            usuario.setTelefone(request.getParameter("txtTelefone"));
                            usuario.setCelular(request.getParameter("txtCelular"));
                            usuario.setEndereco(end);
                            usuario.setSenha(request.getParameter("txtSenha"));
                            int idUser = dao.CadastrarUsuario(usuario);

                            usuario.setNome(request.getParameter("txtNome"));
                            usuario.setCpf(request.getParameter("txtCpf"));
                            String aux = (request.getParameter("txtSexo"));
                            char sexo = aux.charAt(0);
                            usuario.setSexo(sexo);
                            usuario.setId(idUser);
                            int idPessoal = dao.CadastrarPessoal(usuario);

                            int idFunc = Integer.parseInt(request.getParameter("txtIdFunc"));
                            usuario.setIdFunc(idFunc);
                            usuario.setFuncao(request.getParameter("txtFuncao"));
                            usuario.setTurno(request.getParameter("txtTurno"));
                            usuario.setId(idUser);
                            usuario.setIdPessoal(idPessoal);
                            dao.CadastrarFuncionario(usuario);

                            String funcao = request.getParameter("txtFuncao");

                            switch (funcao) {
                                case "Gerente":
                                    dao.CadastrarGerente(usuario);
                                    break;

                                case "Recepcao":
                                    dao.CadastrarRecepcao(usuario);
                                    break;

                                case "Estoque":
                                    dao.CadastrarEstoque(usuario);
                                    break;
                            }

                            request.setAttribute("Mensagem", "Funcionario cadastrado com sucesso com sucesso!");
                            request.getRequestDispatcher("sucesso.jsp").forward(request, response);

                        }
                    }
                }
            } else {
                if ("Listar".equals(opc)) {

                    UsuarioDAO dao = new UsuarioDAO();
                    ArrayList<Pessoal> user = dao.listarPessoal();
                    ArrayList<Empresa> user2 = dao.listaEmpresa();
                    ArrayList<Funcionario> user3 = dao.listaFuncionario();

                    request.setAttribute("ListaPessoal", user);
                    request.setAttribute("ListaEmpresa", user2);
                    request.setAttribute("ListaFuncionario", user3);

                    RequestDispatcher rd = request.getRequestDispatcher("listaUsuarios.jsp");
                    rd.forward(request, response);

                } else {
                    if ("Excluir".equals(opc)) {

                        UsuarioDAO dao = new UsuarioDAO();
                        Usuario user = new Usuario();

                        int id = Integer.parseInt(request.getParameter("txtId"));
                        user.setId(id);

                        dao.deletarUsuario(user);

                        RequestDispatcher rd = request.getRequestDispatcher("operaSucesso.jsp");
                        rd.forward(request, response);

                    } else {
                        if ("Alterar_1".equals(opc)) {

                            String tipo = request.getParameter("Tipo");

                            if ("Pessoal".equals(tipo)) {

                                int id = Integer.parseInt(request.getParameter("txtId"));
                                request.setAttribute("id", id);

                                RequestDispatcher rd = request.getRequestDispatcher("Gerente/AltUsuarioPes.jsp");
                                rd.forward(request, response);

                            } else {
                                if ("Empresa".equals(tipo)) {

                                    int id = Integer.parseInt(request.getParameter("txtId"));
                                    request.setAttribute("id", id);

                                    RequestDispatcher rd = request.getRequestDispatcher("Gerente/AltUsuarioEmp.jsp");
                                    rd.forward(request, response);

                                } else {
                                    if ("Funcionario".equals(tipo)) {

                                        int id = Integer.parseInt(request.getParameter("txtId"));
                                        request.setAttribute("id", id);
                                        int idFunc = Integer.parseInt(request.getParameter("txtIdFunc"));
                                        request.setAttribute("idFunc", idFunc);

                                        RequestDispatcher rd = request.getRequestDispatcher("Gerente/AltUsuarioFunc.jsp");
                                        rd.forward(request, response);

                                    }
                                }
                            }

                        } else {
                            if ("Alterar".equals(opc)) {

                                String tipo = request.getParameter("Tipo");
                                UsuarioDAO dao = new UsuarioDAO();

                                switch (tipo) {
                                    case "Pessoal":
                                        Pessoal user = new Pessoal();

                                        user.setEmail(request.getParameter("txtEmail"));
                                        user.setTelefone(request.getParameter("txtTelefone"));
                                        user.setCelular(request.getParameter("txtCelular"));
                                        user.setSenha(request.getParameter("txtSenha"));
                                        int idUser = Integer.parseInt(request.getParameter("txtId"));
                                        user.setId(idUser);
                                        dao.updateUsuario(user);

                                        user.setNome(request.getParameter("txtNome"));
                                        String aux = (request.getParameter("txtSexo"));
                                        char sexo = aux.charAt(0);
                                        user.setSexo(sexo);
                                        dao.updatePessoal(user);

                                        RequestDispatcher rd = request.getRequestDispatcher("operaSucesso.jsp");
                                        rd.forward(request, response);

                                    case "Empresa":
                                        Empresa emp = new Empresa();

                                        emp.setEmail(request.getParameter("txtEmail"));
                                        emp.setTelefone(request.getParameter("txtTelefone"));
                                        emp.setCelular(request.getParameter("txtCelular"));
                                        emp.setSenha(request.getParameter("txtSenha"));
                                        int idUserEmp = Integer.parseInt(request.getParameter("txtId"));
                                        emp.setId(idUserEmp);
                                        dao.updateUsuario(emp);

                                        emp.setNomeSocial(request.getParameter("txtNomeSoc"));
                                        emp.setNomeFantasia(request.getParameter("txtNomeFant"));
                                        dao.updateEmpresa(emp);

                                        RequestDispatcher rdEmp = request.getRequestDispatcher("operaSucesso.jsp");
                                        rdEmp.forward(request, response);

                                    case "Funcionario":
                                        Funcionario func = new Funcionario();

                                        func.setEmail(request.getParameter("txtEmail"));
                                        func.setTelefone(request.getParameter("txtTelefone"));
                                        func.setCelular(request.getParameter("txtCelular"));
                                        func.setSenha(request.getParameter("txtSenha"));
                                        int idUser1 = Integer.parseInt(request.getParameter("txtId"));
                                        func.setId(idUser1);
                                        dao.updateUsuario(func);

                                        func.setNome(request.getParameter("txtNome"));
                                        String auxFunc = (request.getParameter("txtSexo"));
                                        char sexo1 = auxFunc.charAt(0);
                                        func.setSexo(sexo1);
                                        dao.updatePessoal(func);

                                        func.setFuncao(request.getParameter("txtFuncao"));
                                        func.setTurno(request.getParameter("txtTurno"));
                                        int idFunc = Integer.parseInt(request.getParameter("txtIdFunc"));
                                        func.setIdFunc(idFunc);
                                        dao.updateFuncionario(func);

                                        RequestDispatcher rdFunc = request.getRequestDispatcher("operaSucesso.jsp");
                                        rdFunc.forward(request, response);

                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            request.setAttribute("erro", e);
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
