package Servlet;

import DAOclasses.InsumoDAO;
import Classes.Insumo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yasmim
 */

public class EditaInsumo extends HttpServlet {

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
    throws ServletException, IOException, Exception {
      try {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        int idInsumo = Integer.parseInt(request.getParameter("idInsumo"));
        String tipo = request.getParameter("tipo");
        String categoria = request.getParameter("categoria");
        String especificacoes = request.getParameter("especificacoes");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));  
        String marca = request.getParameter("marca");
        String dataValidade = request.getParameter("dataValidade");
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        Insumo insumo = new Insumo();      
       
        insumo.setIdInsumo(idInsumo);
        insumo.setTipo(tipo);
        insumo.setCategoria(categoria);
        insumo.setEspecificacoes(especificacoes);
        insumo.setQuantidade(quantidade);
        insumo.setMarca(marca);
        insumo.setDataValidade(dataValidade);
        insumo.setPreco(preco);
        
        System.out.println("Tipo " + insumo.getIdInsumo());

        InsumoDAO idao = new InsumoDAO();
        idao.altera(insumo);

        String contextPath= "http://localhost:8084/GerenciadorAgricola";
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/dashboard.html"));
      } catch (Exception ex) {
        Logger.getLogger(EditaInsumo.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(EditaInsumo.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(EditaInsumo.class.getName()).log(Level.SEVERE, null, ex);
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
