package DAOclasses;

import Classes.Agricultor;
import Classes.Pessoa;
import Classes.PessoaFisica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yasmim
 */

public class AgricultorDAO {
    private Connection connection;
    
    public AgricultorDAO() throws Exception {
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    // Método do DAO para conexão manual com o banco
    public void setaConexaoAgricultorDAO(String user, String password) throws Exception {
        try {
            this.connection = new ConnectionFactory().getConnection(user, password);
        } catch(Exception e) {
            throw new Exception("Erro ao conectar com o banco");
        }
    }
        
    public boolean adiciona(Agricultor agricultor) throws Exception {  
        
        if((agricultor.getCadPro() == null)||(agricultor.getPf().getCPF() == null))
            throw new Exception("Campo nulo, erro ao enviar o agricultor para o banco");
       
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        pfdao.adiciona(agricultor.getPf());
        
        String sql = "insert into Agricultor" + 
                "(idAgricultor, cadPro, PessoaFisica_CPF)" + 
                "values(?,?,?)";
        
        
        try{
           PreparedStatement stmt = connection.prepareStatement(sql);

           stmt.setInt(1, agricultor.getIdAgricultor());
           stmt.setString(2, agricultor.getCadPro());
           stmt.setString(3, agricultor.getPf().getCPF());
           
           stmt.execute();
           stmt.close();
           
           return true;
        }
        catch (Exception e){
            throw new Exception("Erro ao enviar o agricultor para o banco");
        }
    }
    
    public List <Agricultor> getLista() throws Exception{

        List <Agricultor> agricultores = new ArrayList<Agricultor>();
        PreparedStatement stmt = this.connection.
        prepareStatement("select * from Pessoa P join PessoaFisica PF on P.idPessoa = PF.Pessoa_IdPessoa join Agricultor A on PF.CPF = A.PessoaFisica_CPF;");
        ResultSet rs = stmt.executeQuery();
 
        while (rs.next()){
            // criando o objeto agricultor
            Agricultor agricultor = new Agricultor();
            PessoaFisica pf = new PessoaFisica();
            agricultor.setPf(pf);
            Pessoa pessoa = new Pessoa();
            agricultor.getPf().setPessoa(pessoa);

            agricultor.setIdAgricultor(rs.getInt("idAgricultor"));
            agricultor.setCadPro(rs.getString("cadPro"));
            agricultor.getPf().setCPF(rs.getString("CPF"));
            agricultor.getPf().setNome(rs.getString("nome"));
            agricultor.getPf().setRG(rs.getString("RG"));
            agricultor.getPf().setSexo(rs.getString("sexo"));
            agricultor.getPf().setDataNascimento(rs.getDate("dataNascimento"));
            agricultor.getPf().getPessoa().setTelefone(rs.getString("telefone"));
            agricultor.getPf().getPessoa().setEmail(rs.getString("email"));
            agricultor.getPf().getPessoa().setLogradouro(rs.getString("logradouro"));
            agricultor.getPf().getPessoa().setNumero(rs.getInt("numero"));
            agricultor.getPf().getPessoa().setComplemento(rs.getString("complemento"));
            agricultor.getPf().getPessoa().setBairro(rs.getString("bairro"));
            agricultor.getPf().getPessoa().setCEP(rs.getString("CEP"));
            agricultor.getPf().getPessoa().setCidade(rs.getString("cidade"));
            agricultor.getPf().getPessoa().setEstado(rs.getString("estado"));
            agricultor.getPf().getPessoa().setId(rs.getInt("idPessoa"));

            // adicionando o objeto à lista
            agricultores.add(agricultor);
        }
        rs.close();
        stmt.close();
        return agricultores;
    }
    
    public Agricultor getAgricultor(String id) throws Exception{
        Agricultor agricultor = new Agricultor();
        String sql = "select * from Pessoa P join PessoaFisica PF on P.idPessoa = PF.Pessoa_IdPessoa join Agricultor A on PF.CPF = A.PessoaFisica_CPF WHERE A.idAgricultor = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        try {
           while (rs.next()) {
                PessoaFisica pf = new PessoaFisica();
                agricultor.setPf(pf);
                Pessoa pessoa = new Pessoa();
                agricultor.setIdAgricultor(Integer.parseInt(id));
                agricultor.setCadPro(rs.getString("cadPro"));
                agricultor.getPf().setPessoa(pessoa);
                agricultor.getPf().setNome(rs.getString("nome"));
                agricultor.getPf().setCPF(rs.getString("CPF"));
                agricultor.getPf().setRG(rs.getString("RG"));
                agricultor.getPf().setDataNascimento(rs.getDate("dataNascimento"));
                agricultor.getPf().setSexo(rs.getString("sexo"));
                agricultor.getPf().getPessoa().setTelefone(rs.getString("telefone"));
                agricultor.getPf().getPessoa().setEmail(rs.getString("email"));
                agricultor.getPf().getPessoa().setLogradouro(rs.getString("logradouro"));
                agricultor.getPf().getPessoa().setNumero(rs.getInt("numero"));
                agricultor.getPf().getPessoa().setComplemento(rs.getString("complemento"));
                agricultor.getPf().getPessoa().setBairro(rs.getString("bairro"));
                agricultor.getPf().getPessoa().setCEP(rs.getString("CEP"));
                agricultor.getPf().getPessoa().setCidade(rs.getString("cidade"));
                agricultor.getPf().getPessoa().setEstado(rs.getString("estado"));
                agricultor.getPf().getPessoa().setId(rs.getInt("idPessoa"));
           }
           stmt.execute();
           stmt.close();
           return agricultor;
        }
        catch (Exception e){
            throw new Exception("Erro ao requisitar o agricultor do banco");
        }
    }
    
    public boolean altera(Agricultor agricultor) throws Exception{ 
        if(agricultor.getPf().getCPF() == null)
            throw new Exception("Campo nulo, erro ao enviar o agricultor para o banco");
        
        PessoaFisicaDAO pfdao = new PessoaFisicaDAO();
        
        pfdao.altera(agricultor.getPf());
        String sql = "update Agricultor A inner join PessoaFisica PF on A.PessoaFisica_CPF = PF.CPF inner join Pessoa P on PF.Pessoa_idPessoa = P.idPessoa set idAgricultor=?, cadPro=?, nome=?, CPF=?, RG=?, dataNascimento=?, sexo=?, telefone=?, email=?, logradouro=?, numero=?, complemento=?, bairro=?, CEP=?, cidade=?, estado=? where PF.CPF=?";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setInt(1, agricultor.getIdAgricultor());
            stmt.setString(2, agricultor.getCadPro());
            stmt.setString(4, agricultor.getPf().getNome());
            stmt.setString(6, agricultor.getPf().getCPF());
            stmt.setString(7, agricultor.getPf().getRG());
            stmt.setDate(8, new java.sql.Date(agricultor.getPf().getDataNascimento().getTime()));
            stmt.setString(9, agricultor.getPf().getSexo());
            stmt.setString(10, agricultor.getPf().getPessoa().getTelefone());
            stmt.setString(11, agricultor.getPf().getPessoa().getEmail());
            stmt.setString(12, agricultor.getPf().getPessoa().getLogradouro());
            stmt.setInt(13, agricultor.getPf().getPessoa().getNumero());
            stmt.setString(14, agricultor.getPf().getPessoa().getComplemento());
            stmt.setString(15, agricultor.getPf().getPessoa().getBairro());
            stmt.setString(16, agricultor.getPf().getPessoa().getCEP());
            stmt.setString(17, agricultor.getPf().getPessoa().getCidade());
            stmt.setString(18, agricultor.getPf().getPessoa().getEstado());
            stmt.setString(20, agricultor.getPf().getCPF());
            stmt.execute();
            stmt.close();
            return true;
            
        } catch (Exception e){
            throw new Exception("Erro ao alterar o agricultor");
        }
    }
    
    public Agricultor getAgricultorCPF(String CPF) throws Exception{
        Agricultor agricultor = null;
        PreparedStatement stmt = this.connection.
        prepareStatement("select * from Pessoa P join PessoaFisica PF on P.idPessoa = PF.Pessoa_IdPessoa join Agricultor A on PF.CPF = A.PessoaFisica_CPF where CPF=?;");
        stmt.setString(1, CPF);
        ResultSet rs = stmt.executeQuery();
 
        while (rs.next()){
            // criando o objeto Agricultor
            agricultor = new Agricultor();
            PessoaFisica pf = new PessoaFisica();
            agricultor.setPf(pf);
            Pessoa pessoa = new Pessoa();
            agricultor.getPf().setPessoa(pessoa);

            agricultor.setIdAgricultor(rs.getInt("idAgricultor"));
            agricultor.setCadPro(rs.getString("cadPro"));
            agricultor.getPf().setCPF(rs.getString("CPF"));
            agricultor.getPf().setNome(rs.getString("nome"));
            agricultor.getPf().setRG(rs.getString("RG"));
            agricultor.getPf().setSexo(rs.getString("sexo"));
            agricultor.getPf().setDataNascimento(rs.getDate("dataNascimento"));
            agricultor.getPf().getPessoa().setTelefone(rs.getString("telefone"));
            agricultor.getPf().getPessoa().setEmail(rs.getString("email"));
            agricultor.getPf().getPessoa().setLogradouro(rs.getString("logradouro"));
            agricultor.getPf().getPessoa().setNumero(rs.getInt("numero"));
            agricultor.getPf().getPessoa().setComplemento(rs.getString("complemento"));
            agricultor.getPf().getPessoa().setBairro(rs.getString("bairro"));
            agricultor.getPf().getPessoa().setCEP(rs.getString("CEP"));
            agricultor.getPf().getPessoa().setCidade(rs.getString("cidade"));
            agricultor.getPf().getPessoa().setEstado(rs.getString("estado"));
            agricultor.getPf().getPessoa().setId(rs.getInt("idPessoa"));
        }
        rs.close();
        stmt.close();
        return agricultor;
    }    
}




