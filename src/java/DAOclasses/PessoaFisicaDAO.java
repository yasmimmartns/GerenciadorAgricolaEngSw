package DAOclasses;

import Classes.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author yasmim
 */

public class PessoaFisicaDAO {
    
    private Connection connection;
    
    public PessoaFisicaDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    // Método do DAO para conexão manual com o banco
    public void setaConexaoPessoaFisicaDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }
     
    public boolean adiciona(PessoaFisica pf) throws Exception {
        
        if((pf.getCPF() == null)||(pf.getDataNascimento() == null)||(pf.getNome() == null)||(pf.getRG() == null)||(pf.getSexo() == null))
            throw new Exception("Campo nulo, erro ao enviar a pessoa fisica para o banco");
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.adiciona(pf.getPessoa());
        
        String sql = "insert into PessoaFisica" + 
                "(Pessoa_idPessoa, nome, RG, sexo, dataNascimento, CPF)" + 
                "values(?,?,?,?,?,?)";
      
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setInt(1, pf.getPessoa().getId());
            stmt.setString(2, pf.getNome());
            stmt.setString(3, pf.getRG());
            stmt.setString(4, pf.getSexo());
            stmt.setDate(5, new java.sql.Date(pf.getDataNascimento().getTime()));
            stmt.setString(6, pf.getCPF());
            stmt.execute();
            stmt.close();
            
            return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao enviar a pessoa fisica para o banco");
            
        }
    }
    
    public boolean altera (PessoaFisica pf) throws Exception{
        
        if((pf.getCPF() == null)||(pf.getDataNascimento() == null)||(pf.getNome() == null)||(pf.getRG() == null)||(pf.getSexo() == null))
            throw new Exception("Campo nulo, erro ao enviar a pessoa fisica para o banco");
        
        PessoaDAO pdao = new PessoaDAO();
        pdao.altera(pf.getPessoa());
                
        
        String sql = "update PessoaFisica PF join Pessoa P set CPF=?, nome=?, "
            + "RG=?, sexo=?, dataNascimento=? where P.idpessoa=?";
       
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pf.getCPF());
            stmt.setString(2, pf.getNome());
            stmt.setString(3, pf.getRG());
            stmt.setString(4, pf.getSexo());
            stmt.setDate(5, new java.sql.Date(pf.getDataNascimento().getTime()));
            stmt.setInt(6, pf.getPessoa().getId());

            stmt.execute();
            stmt.close();
            
            return true;
        }   
        catch (Exception e){
            throw new Exception("Erro ao alterar a pessoa fisica");
        }     
    }    
}
