package controle;

import dao.CaixaDAO;
import dao.EstoqueDAO;
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
import modelo.Caixa;
import modelo.CaixaBuilder;
import modelo.Endereco;
import modelo.Estoque;
import modelo.Pessoal;

@WebServlet(name = "ControleCaixas", urlPatterns = {"/ControleCaixas"})
public class ControleCaixas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String opc = request.getParameter("Confirma");

            if ("Cadastrar Caixa".equals(opc)) {

                CaixaDAO dao = new CaixaDAO();
                EstoqueDAO daoEstoque = new EstoqueDAO();

                int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
                int cd_usuario = Integer.parseInt(request.getParameter("txtUsuario"));
                int cd_estoque = Integer.parseInt(request.getParameter("txtEstoque"));

                Caixa caixa = new CaixaBuilder()
                        .comTipo(request.getParameter("txtTipo"))
                        .comDescricao(request.getParameter("txtDescricao"))
                        .comQuantidade(quantidade)
                        .comCd_usuario(cd_usuario)
                        .constroi();

                int idCaixa = dao.CadastrarCaixa(caixa);

                Estoque estoque = new Estoque();
                estoque.setId_caixa(idCaixa);
                estoque.setId(cd_estoque);
                daoEstoque.updateCadastroCaixa(estoque);

                request.setAttribute("Mensagem", "Caixa cadastrada com sucesso com sucesso!");
                request.getRequestDispatcher("operaSucesso.jsp").forward(request, response);

            } else {
                if ("Listar Caixas".equals(opc)) {

                    CaixaDAO dao = new CaixaDAO();
                    ArrayList<Caixa> caixas = dao.listarCaixas();

                    request.setAttribute("ListaCaixas", caixas);

                    RequestDispatcher rd = request.getRequestDispatcher("Recepcao/listaCaixas.jsp");
                    rd.forward(request, response);

                } else {
                    if ("Excluir".equals(opc)) {

                        CaixaDAO dao = new CaixaDAO();
                        Caixa caixa = new Caixa();

                        int id = Integer.parseInt(request.getParameter("txtId"));
                        caixa.setId_caixa(id);

                        dao.deletarCaixa(caixa);

                        request.setAttribute("Mensagem", "Caixa deletada com sucesso com sucesso!");
                        request.getRequestDispatcher("operaSucesso.jsp").forward(request, response);

                    } else {
                        if ("Alterar_1".equals(opc)) {

                            CaixaDAO dao = new CaixaDAO();

                            int id = Integer.parseInt(request.getParameter("txtId"));
                            request.setAttribute("id", id);

                            RequestDispatcher rd = request.getRequestDispatcher("Recepcao/AltCaixa.jsp");
                            rd.forward(request, response);

                        } else {
                            if ("Alterar".equals(opc)) {

                                int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
                                int id = Integer.parseInt(request.getParameter("txtId"));

                                CaixaDAO dao = new CaixaDAO();
                                Caixa caixa = new CaixaBuilder().comId_caixa(id)
                                        .comTipo(request.getParameter("txtTipo"))
                                        .comDescricao(request.getParameter("txtDescricao"))
                                        .comQuantidade(quantidade)
                                        .constroi();

                                dao.updateCaixa(caixa);

                                request.setAttribute("Mensagem", "Caixa alterada com sucesso com sucesso!");
                                request.getRequestDispatcher("operaSucesso.jsp").forward(request, response);

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
