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
                "(CPF, Pessoa_idPessoa, nome, sobrenome, RG, sexo, dataNascimento)" + 
                "values(?,?,?,?,?,?,?)";
      
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pf.getCPF());
            stmt.setInt(2, pf.getPessoa().getId());
            stmt.setString(3, pf.getNome());
            stmt.setString(5, pf.getRG());
            stmt.setString(6, pf.getSexo());
            stmt.setDate(7, new java.sql.Date(pf.getDataNascimento().getTime()));
            stmt.execute();
            System.out.println("AAAAA");
            stmt.close();
            System.out.println("BBBB");
            
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
            + "sobrenome=?, RG=?, sexo=?, dataNascimento=? where P.idpessoa=?";
       
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, pf.getCPF());
            stmt.setString(2, pf.getNome());
            stmt.setString(4, pf.getRG());
            stmt.setString(5, pf.getSexo());
            stmt.setDate(6, new java.sql.Date(pf.getDataNascimento().getTime()));
            stmt.setInt(7, pf.getPessoa().getId());


            stmt.execute();
            stmt.close();
            
            return true;
        }   
        catch (Exception e){
            throw new Exception("Erro ao alterar a pessoa fisica");
        }     
    }    
}
