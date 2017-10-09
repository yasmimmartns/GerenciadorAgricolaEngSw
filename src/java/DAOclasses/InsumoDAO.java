package DAOclasses;

import Classes.Insumo;
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

public class InsumoDAO {
    private Connection connection;
    
    public InsumoDAO() throws Exception{
        this.connection = new ConnectionFactory().getConnection("root","root");
    }
    
    public void adiciona(Insumo insumo) throws Exception{
        String sql = "insert into Insumo"
                + "(titulo, tipo, preco, idioma, anoLancamento, quantidade)"
                + "values(?,?,?,?,?,?)";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, insumo.getTipo());
            stmt.setString(2, insumo.getCategoria());
            stmt.setString(3,insumo.getEspecificacoes());
            stmt.setInt(4, insumo.getQuantidade());
            stmt.setString(5, insumo.getMarca());
            stmt.setString(6, insumo.getDataValidade());
            stmt.setFloat(7, insumo.getPreco());
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            insumo.setIdInsumo(rs.getInt(1));
            
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public List<Insumo> getLista() throws Exception{
        try{
            List<Insumo> insumos = new ArrayList<Insumo>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from Insumo");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Insumo insumo = new Insumo();
                
                insumo.setIdInsumo(rs.getInt("idInsumo"));
                insumo.setTipo(rs.getString("tipo"));
                insumo.setCategoria(rs.getString("categoria"));
                insumo.setEspecificacoes(rs.getString("especificacoes"));
                insumo.setQuantidade(rs.getInt("quantidade"));
                insumo.setMarca(rs.getString("marca"));
                insumo.setDataValidade(rs.getString("dataValidade"));
                insumo.setPreco(rs.getFloat("preco"));
                
                insumos.add(insumo);
            }
            rs.close();
            stmt.close();
            return insumos;
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void remove(Insumo insumo){
        String sql = "delete from Produto where Produto.idProduto = ?";
        
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setInt(1, insumo.getIdInsumo());
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void altera(Insumo insumo){
        String sql = "update Insumo set tipo=?, categoria=?, especificacoes=?,"
                + "quantidade=?, marca=?, dataValidade=?, preco=? where idInsumo =?";
            
        try{
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            
            stmt.setString(1, insumo.getTipo());
            stmt.setString(2, insumo.getCategoria());
            stmt.setString(3, insumo.getEspecificacoes());
            stmt.setInt(4, insumo.getQuantidade());
            stmt.setString(5, insumo.getMarca());
            stmt.setString(6, insumo.getDataValidade());
            stmt.setFloat(7, insumo.getPreco());
            stmt.setInt(8, insumo.getIdInsumo());
            
            stmt.execute();
            stmt.close();
            
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
