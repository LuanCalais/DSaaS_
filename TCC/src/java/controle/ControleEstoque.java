package controle;

import dao.EstoqueDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estoque;

@WebServlet(name = "ControleEstoque", urlPatterns = {"/ControleEstoque"})
public class ControleEstoque extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String opc = request.getParameter("Confirma");

            if ("Cadastrar".equals(opc)) {

                EstoqueDAO dao = new EstoqueDAO();
                Estoque estoque = new Estoque();

                String aux = (request.getParameter("txtReferencia"));
                char referencia = aux.charAt(0);
                estoque.setReferencia(referencia);
                int rua = Integer.parseInt(request.getParameter("txtRua"));
                estoque.setRua(rua);
                estoque.setStatus(request.getParameter("txtStatus"));

                dao.cadastraEstoque(estoque);

                request.setAttribute("Mensagem", "Estoque cadastrado com sucesso com sucesso!");
                request.getRequestDispatcher("operaSucesso.jsp").forward(request, response);

            } else {
                if ("Listar".equals(opc)) {

                    EstoqueDAO dao = new EstoqueDAO();
                    ArrayList<Estoque> estoque = dao.listarEstoque();

                    request.setAttribute("ListaEstoque", estoque);

                    RequestDispatcher rd = request.getRequestDispatcher("Estoquista/listaEstoque.jsp");
                    rd.forward(request, response);

                } else {
                    if ("Excluir".equals(opc)) {
                        EstoqueDAO dao = new EstoqueDAO();
                        Estoque estoque = new Estoque();

                        int id = Integer.parseInt(request.getParameter("txtId"));
                        estoque.setId(id);

                        dao.deletarEstoque(estoque);

                        request.setAttribute("Mensagem", "Estoque deletado com sucesso com sucesso!");
                        request.getRequestDispatcher("operaSucesso.jsp").forward(request, response);

                    } else {
                        if ("Alterar_1".equals(opc)) {

                            int id = Integer.parseInt(request.getParameter("txtId"));
                            request.setAttribute("id", id);

                            RequestDispatcher rd = request.getRequestDispatcher("Estoquista/AltEstoque.jsp");
                            rd.forward(request, response);

                        } else {
                            if ("Alterar".equals(opc)) {

                                EstoqueDAO dao = new EstoqueDAO();
                                Estoque estoque = new Estoque();

                                int id = Integer.parseInt(request.getParameter("txtId"));
                                estoque.setId(id);
                                int rua = Integer.parseInt(request.getParameter("txtRua"));
                                estoque.setRua(rua);
                                estoque.setStatus(request.getParameter("txtStatus"));

                                dao.updateEstoque(estoque);

                                request.setAttribute("Mensagem", "Estoque alterado com sucesso com sucesso!");
                                request.getRequestDispatcher("operaSucesso.jsp").forward(request, response);

                            } else {
                                if ("Buscar ID".equals(opc)) {

                                    EstoqueDAO dao = new EstoqueDAO();
                                    Estoque estoque = new Estoque();
                                    int id = Integer.parseInt(request.getParameter("txtId"));

                                    estoque = dao.listarId(id);

                                    request.setAttribute("BuscaId", estoque);

                                    RequestDispatcher rd = request.getRequestDispatcher("Estoquista/listaId.jsp");
                                    rd.forward(request, response);
                                }
                            }
                        }
                    }
                }
            }
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
