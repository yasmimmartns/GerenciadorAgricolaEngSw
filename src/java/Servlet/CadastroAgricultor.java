/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Agricultor;
import Classes.Pessoa;
import Classes.PessoaFisica;
import DAOclasses.AgricultorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eryc
 */
public class CadastroAgricultor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Agricultor agricultor = new Agricultor();
        
        PessoaFisica pf = new PessoaFisica();
        agricultor.setPf(pf);
        
        Pessoa pessoa = new Pessoa();
        agricultor.getPf().setPessoa(pessoa);
        
        agricultor.getPf().getPessoa().setTelefone(request.getParameter("telefone"));
        agricultor.getPf().getPessoa().setEmail(request.getParameter("email"));
        agricultor.getPf().getPessoa().setCEP(request.getParameter("cep"));
        agricultor.getPf().getPessoa().setLogradouro(request.getParameter("logradouro"));
        agricultor.getPf().getPessoa().setComplemento(request.getParameter("complemento"));
        agricultor.getPf().getPessoa().setNumero(Integer.parseInt(request.getParameter("numero")));
        agricultor.getPf().getPessoa().setBairro(request.getParameter("bairro"));
        agricultor.getPf().getPessoa().setCidade(request.getParameter("cidade"));
        agricultor.getPf().getPessoa().setEstado(request.getParameter("estado"));
        agricultor.getPf().setCPF(request.getParameter("CPF"));
        agricultor.getPf().setNome(request.getParameter("nome"));

        agricultor.getPf().setRG(request.getParameter("RG"));
        agricultor.getPf().setSexo(request.getParameter("sexo"));  
        
        String dataNasc = request.getParameter("dataNascimento");
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

        Date date = new java.sql.Date(formatoData.parse(dataNasc).getTime());
       
        agricultor.getPf().setDataNascimento(date);
                
        String cadPro = request.getParameter("cadPro");
        agricultor.setCadPro("");
        if(cadPro != null)
            agricultor.setCadPro(cadPro);
        
        AgricultorDAO dao = new AgricultorDAO();
        if(dao.getAgricultorCPF(agricultor.getPf().getCPF()) == null){
            dao.adiciona(agricultor);
        }
        
        String contextPath= "http://localhost:8084/GerenciadorAgricola/dashboard.html";
        response.sendRedirect(response.encodeRedirectURL(contextPath));
        
        
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
            Logger.getLogger(CadastroAgricultor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroAgricultor.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastroAgricultor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroAgricultor.class.getName()).log(Level.SEVERE, null, ex);
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
