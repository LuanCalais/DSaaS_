package controle;

import dao.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Login;

@WebServlet(name = "ControleLogin", urlPatterns = {"/ControleLogin"})
public class ControleLogin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Login logar = new Login();
            logar.setEmail(request.getParameter("txtEmail"));
            logar.setSenha(request.getParameter("txtSenha"));

            HttpSession sessao = request.getSession();
            String uri = request.getContextPath();

            LoginDAO dao = new LoginDAO();
            Login log = dao.confirmaLogin(logar);
            String perfil = log.getPerfil();

                switch (perfil) {
                    case "Gerente":
                        uri += "/Gerente/gerente.jsp";
                        break;

                    case "Recepcao":
                        uri += "/Recepcao/recepcao.jsp";
                        break;

                    case "Estoque":
                        uri += "/Estoquista/estoquista.jsp";
                        break;

                    default:
                        uri += "/LogarFuncionario.jsp";
                }

                sessao.setAttribute("login", "true");
                sessao.setAttribute("Perfil", perfil);

                response.sendRedirect(uri);
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
