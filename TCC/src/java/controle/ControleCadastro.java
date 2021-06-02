package controle;

import dao.Autenticador;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Funcionario;
import modelo.Pessoal;

@WebServlet(name = "ControleCadastro", urlPatterns = {"/ControleCadastro"})
public class ControleCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String opc = request.getParameter("rdTipo");
            UsuarioDAO dao = new UsuarioDAO();
            Endereco end = new Endereco();
            end.setCep(request.getParameter("txtCep"));
            end.setLogadouro(request.getParameter("txtLogadouro"));
            end.setBairro(request.getParameter("txtBairro"));
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            end.setNumero(numero);
            int idEnd = dao.CadastrarEndereco(end);
            end.setId(idEnd);
            if("Pessoal".equals(opc)){
                
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
                }
                */
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
                
            }else{
                
                if("Empresa".equals(opc)){
                    
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
                    
                }else{
                    if("Funcionario".equals(opc)){
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
                    
                        switch(funcao){
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
        }catch(Exception e){
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
