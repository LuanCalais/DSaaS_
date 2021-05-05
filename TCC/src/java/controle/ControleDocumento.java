/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import modelo.Documentos;

/**
 *
 * @author luanc
 */
@WebServlet(name = "ControleDocumento", urlPatterns = {"/ControleDocumento"})
public class ControleDocumento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String opc = request.getParameter("Confirma");
            
            if("Cadastrar".equals(opc)){
                
               // Date datas = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("btnData"));
                
                modelo.Documentos doc = new modelo.Documentos();
                int Id = Integer.parseInt(request.getParameter("txtId"));
                doc.setId(Id);
                doc.setDescricao(request.getParameter("txtDescricao"));
                //doc.setData(data);
                doc.setData(request.getParameter("btnData"));
                doc.setTipo(request.getParameter("rdTipo"));
                
                dao.DocumentosDAO dao = new dao.DocumentosDAO();
                dao.cadastrar(doc);
                
                request.setAttribute("Mensagem", "Cadastrado com sucesso!");
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                
            }else if("Listar".equals(opc)){
                
                dao.DocumentosDAO dao = new dao.DocumentosDAO();
        
                ArrayList<Documentos> documentos = dao.listar();
                request.setAttribute("listaDocumentos", documentos);
                
                RequestDispatcher rd = request.getRequestDispatcher("listaestoque.jsp");
                rd.forward(request, response);
                
            }   else if("Listar ID".equals(opc)){
                int Id = Integer.parseInt(request.getParameter("txtId"));
                dao.DocumentosDAO dao = new dao.DocumentosDAO();
                
                ArrayList<Documentos> documentos = dao.listarId(Id);
                request.setAttribute("listaDocumentos", documentos);
                
                RequestDispatcher rd = request.getRequestDispatcher("listaestoque.jsp");
                rd.forward(request, response);
                
                
            }else if("Deletar".equals(opc)){
                modelo.Documentos doc = new modelo.Documentos();
                int Id = Integer.parseInt(request.getParameter("txtId"));
                doc.setId(Id);
                doc.setDescricao(request.getParameter("txtDescricao"));
                //doc.setData(data);
                doc.setData(request.getParameter("btnData"));
                doc.setTipo(request.getParameter("rdTipo"));
                
                dao.DocumentosDAO dao = new dao.DocumentosDAO();
                dao.delete(doc);
                
                request.setAttribute("Mensagem", "Deletado com sucesso com sucesso!");
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
                
            }else if("Alterar".equals(opc)){
                modelo.Documentos doc = new modelo.Documentos();
                int Id = Integer.parseInt(request.getParameter("txtId"));
                doc.setId(Id);
                doc.setDescricao(request.getParameter("txtDescricao"));
                doc.setData(request.getParameter("btnData"));
                doc.setTipo(request.getParameter("rdTipo"));
                
                dao.DocumentosDAO dao = new dao.DocumentosDAO();
                dao.atualizar(doc);
                
                request.setAttribute("Mensagem", "Atualizado com sucesso!");
                request.getRequestDispatcher("sucesso.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControleDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ControleDocumento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
