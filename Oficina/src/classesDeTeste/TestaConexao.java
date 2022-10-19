package classesDeTeste;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import classesPrincipais.Clientes;
import conexaoDB.ConnectionFactory;



public class TestaConexao {
    
    public static void main(String[] args) throws SQLException{
        
       ConnectionFactory teste = new ConnectionFactory();

       Connection con = teste.connectionFactory();
    
       
      
       System.out.println("FECHOU!!!");
       con.close();
            
    };
}



