package controle;

import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.Empresa;
import modelo.Endereco;
import modelo.Pessoal;

@WebServlet(name = "ControleCadastro", urlPatterns = {"/ControleCadastro"})
public class ControleCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            UsuarioDAO dao = new UsuarioDAO();

            Endereco end = new Endereco();
            end.setCep(request.getParameter("txtCep"));
            end.setLogadouro(request.getParameter("txtLogadouro"));
            end.setBairro(request.getParameter("txtBairro"));
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            end.setNumero(numero);
            dao.CadastrarEndereco(end);

            Usuario usuario = new Usuario();
            usuario.setEmail(request.getParameter("txtEmail"));
            usuario.setTelefone(request.getParameter("txtTelefone"));
            usuario.setCelular(request.getParameter("txtCelular"));
            usuario.setSenha(request.getParameter("txtSenha"));
            
            Pessoal pessoa = new Pessoal();
            pessoa.setNome(request.getParameter("txtNome"));
            pessoa.setCpf(request.getParameter("txtCpf"));
            String aux = (request.getParameter("txtSexo"));
            char sexo = aux.charAt(0);
            pessoa.setSexo(sexo);
      
            dao.CadastrarPessoal(pessoa);
            
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
