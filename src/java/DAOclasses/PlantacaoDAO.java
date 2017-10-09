package DAOclasses;

import Classes.Plantacao;
import Classes.Regiao;
import DAOclasses.RegiaoDAO;
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

public class PlantacaoDAO {
    private Connection connection;
    
    public PlantacaoDAO() throws Exception{
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    public void adiciona(Plantacao plantacao) throws Exception{
        
        RegiaoDAO rdao = new RegiaoDAO();
        rdao.adiciona(plantacao.getRegiao());
        
        String sql = "insert into Plantacao"
                + "(tipo, quantidade, regiao)"
                + "values(?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, plantacao.getTipo());
            stmt.setInt(2, plantacao.getQuantidade());
            stmt.setInt(3, plantacao.getRegiao().getIdRegiao());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            plantacao.setIdPlantacao(rs.getInt(1));
            
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Plantacao> getLista() throws Exception{
        try{
            List<Plantacao> plantacoes = new ArrayList<Plantacao>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Plantacao");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Plantacao plantacao = new Plantacao();
                Regiao r = new Regiao();
                plantacao.setRegiao(r);
                
                plantacao.setIdPlantacao(rs.getInt("idPlantacao"));
                plantacao.setTipo(rs.getString("tipo"));
                plantacao.setQuantidade(rs.getInt("quantidade"));
                plantacao.getRegiao().setIdRegiao(rs.getInt("idRegiao"));
                plantacao.getRegiao().setEndereco(rs.getInt("endereco"));
                plantacao.getRegiao().setArea(rs.getInt("area"));
                
                plantacoes.add(plantacao);
            }
            rs.close();
            stmt.close();
            return plantacoes;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void remove(Plantacao plantacao){
        String sql = "delete from Plantacao where Plantacao.idPlantacao = ?";
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setInt(1, plantacao.getIdPlantacao());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void altera(Plantacao plantacao){
        String sql = "update Plantacao P inner join Regiao R on P.regiao = R.idRegiao "
                + "set idPlantacao=?, tipo=?, quantidade=?, endereco=?, area=? where R.idRegiao=?";
            
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, plantacao.getTipo());
            stmt.setInt(2, plantacao.getQuantidade());
            stmt.setString(3, plantacao.getRegiao().getEndereco);
            stmt.setInt(8, plantacao.getIdPlantacao());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
