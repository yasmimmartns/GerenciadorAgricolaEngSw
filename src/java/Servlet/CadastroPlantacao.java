/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Plantacao;
import Classes.Regiao;
import DAOclasses.PlantacaoDAO;
import DAOclasses.RegiaoDAO;
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

public class CadastroPlantacao extends HttpServlet {

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
            throws ServletException, IOException {
        try {        
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");

                PrintWriter out = response.getWriter();

                Plantacao plantacao = new Plantacao();
                Regiao regiao = new Regiao();

                //Captura os dados de regiao do form
                regiao.setEndereco(request.getParameter("endereco"));
                regiao.setArea(Float.parseFloat(request.getParameter("area")));
                
                plantacao.setRegiao(regiao);

                //Captura os dados de plantacao do form
                plantacao.setTipo(request.getParameter("tipo"));
                plantacao.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));

                //Instancia as classes de DAO para plantacao e região 
                //e chama o método para inserí-los no BD
                RegiaoDAO regiaoDao = new RegiaoDAO();
                regiaoDao.adiciona(regiao);
                
                PlantacaoDAO plantDao = new PlantacaoDAO();
                plantDao.adiciona(plantacao);
                
                String contextPath= "http://localhost:8084/GerenciadorAgricola/dashboard.html";
                response.sendRedirect(response.encodeRedirectURL(contextPath));
        } 
        catch (Exception ex) {
            Logger.getLogger(CadastroInsumo.class.getName()).log(Level.SEVERE, null, ex);
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