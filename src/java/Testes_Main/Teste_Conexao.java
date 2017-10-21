package Testes_Main;

import DAOclasses.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author yasmim
 */
public class Teste_Conexao {
    
    public static void main(String[] args) throws SQLException, Exception {
        Connection connection = new ConnectionFactory().getConnection("root","root");
        System.out.println("Conexão Aberta!!!");
        connection.close();
    }
}
