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

      conectaOficina.setJdbcUrl("jdbc:mysql://localhost/oficina?useTimezone=true&serverTimezone=UTC"); // provavelmente isso aqui vai funcionar

      conectaOficina.setUser(""); //coloque o usuario do mysql

      conectaOficina.setPassword(""); // senha do mysql

      //numero maximo de instacias
      conectaOficina.setMaxPoolSize(10);

      this.dataSource = conectaOficina;
   } 
    
    public  Connection connectionFactory() throws SQLException{

      return this.dataSource.getConnection();
    }
}
