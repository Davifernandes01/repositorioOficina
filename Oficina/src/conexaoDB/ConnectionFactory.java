package conexaoDB;

//Connection factory para a conexao com o banco de dados
import java.sql.Connection;

import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

   public DataSource dataSource;

   public ConnectionFactory()
   {
      ComboPooledDataSource conectaOficina = new ComboPooledDataSource();

      conectaOficina.setJdbcUrl("jdbc:mysql://localhost/oficina?useTimezone=true&serverTimezone=UTC");

      conectaOficina.setUser("root");

      conectaOficina.setPassword("davi2003@");

      //numero maximo de instacias
      conectaOficina.setMaxPoolSize(10);

      this.dataSource = conectaOficina;
   } 
    
    public  Connection connectionFactory() throws SQLException{

      return this.dataSource.getConnection();
    }
}
