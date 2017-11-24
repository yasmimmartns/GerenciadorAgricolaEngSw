package DAOclasses;

import Classes.Regiao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yasmim
 */

public class RegiaoDAO {
    private Connection connection;
    
    public RegiaoDAO() throws Exception{
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    public void adiciona(Regiao regiao) throws Exception{
        String sql = "insert into Regiao"
                + "(endereco, area)"
                + "values(?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, regiao.getEndereco());
            stmt.setFloat(2, regiao.getArea());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            regiao.setIdRegiao(rs.getInt(1));
            
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Regiao> getLista() throws Exception{
        try{
            List<Regiao> regioes = new ArrayList<Regiao>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Regiao");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Regiao regiao = new Regiao();
                
                regiao.setIdRegiao(rs.getInt("idRegiao"));
                regiao.setEndereco(rs.getString("endereco"));
                regiao.setArea(rs.getFloat("area"));
                
                regioes.add(regiao);
            }
            rs.close();
            stmt.close();
            return regioes;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void remove(int regiao){
        String sql = "delete from Regiao where Regiao.idRegiao = ?";
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setInt(1, regiao);
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public Regiao getRegiao(String id) throws Exception{
        Regiao regiao = new Regiao();
        String sql = "select * from Regiao WHERE idRegiao = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        try {
           while (rs.next()) {
                regiao.setIdRegiao(Integer.parseInt(id));
                regiao.setArea(rs.getFloat("area"));
                regiao.setEndereco(rs.getString("endereco"));
           }
           stmt.execute();
           stmt.close();
           return regiao;
        }
        catch (Exception e){
            throw new Exception("Erro ao requisitar o cliente do banco");
        }
    }
    
    public void altera(Regiao regiao){
        String sql = "update Regiao set endereco=?, area=? where idRegiao =?";
            
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, regiao.getEndereco());
            stmt.setFloat(2, regiao.getArea());
            stmt.setInt(3, regiao.getIdRegiao());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
