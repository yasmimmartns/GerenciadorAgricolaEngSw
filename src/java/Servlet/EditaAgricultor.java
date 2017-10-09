package Servlet;

import DAOclasses.AgricultorDAO;
import Classes.Pessoa;
import Classes.PessoaFisica;
import Classes.Agricultor;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class EditaAgricultor extends HttpServlet {

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

        int idAgricultor = Integer.parseInt(request.getParameter("idCliente"));
        String cadPro = request.getParameter("codFidelidade");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("CPF");
        String rg = request.getParameter("RG");
        String dataNasc = request.getParameter("dataNascimento");
        String sexo = request.getParameter("sexo");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        int numero = Integer.parseInt(request.getParameter("numero"));
        String logradouro = request.getParameter("logradouro");
        String complemento = request.getParameter("complemento");
        String bairro = request.getParameter("bairro");
        String cep = request.getParameter("cep");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");

        Agricultor agricultor = new Agricultor();

        PessoaFisica pf = new PessoaFisica();
        agricultor.setPf(pf);

        Pessoa pessoa = new Pessoa();
        agricultor.getPf().setPessoa(pessoa);
        agricultor.setIdAgricultor(idAgricultor);
        System.out.println(agricultor.getIdAgricultor());
        agricultor.setCadPro(cadPro);
        agricultor.getPf().setNome(nome);
        agricultor.getPf().setCPF(cpf);
        agricultor.getPf().setRG(rg);
        agricultor.getPf().setSexo(sexo);
        
        DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date = new java.sql.Date(formatoData.parse(dataNasc).getTime());
        agricultor.getPf().setDataNascimento(date);
        
        agricultor.getPf().getPessoa().setTelefone(telefone);
        agricultor.getPf().getPessoa().setEmail(email);
        agricultor.getPf().getPessoa().setNumero(numero);
        agricultor.getPf().getPessoa().setLogradouro(logradouro);
        agricultor.getPf().getPessoa().setComplemento(complemento);
        agricultor.getPf().getPessoa().setBairro(bairro);
        agricultor.getPf().getPessoa().setCEP(cep);
        agricultor.getPf().getPessoa().setCidade(cidade);
        agricultor.getPf().getPessoa().setEstado(estado);

        AgricultorDAO adao = new AgricultorDAO();
        adao.altera(agricultor);

        String contextPath= "http://localhost:8084/GerenciadorAgricola";
        response.sendRedirect(response.encodeRedirectURL(contextPath + "/dashboard.html"));
      } catch (Exception ex) {
        Logger.getLogger(EditaAgricultor.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditaAgricultor.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditaAgricultor.class.getName()).log(Level.SEVERE, null, ex);
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
