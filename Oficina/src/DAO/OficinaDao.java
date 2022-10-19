package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import classesPrincipais.Carros;
import classesPrincipais.Clientes;

//DAO aonde fica todos os metados para comandos no banco de dados
public class OficinaDao
 {
    
    private Connection con;

    public OficinaDao( Connection con)
    {
        this.con = con;
    }

    public void salvar(Clientes cliente, Carros carro) throws SQLException
    {
    

        
        String sqlClientes = "insert into cliente (nome, cpf) values (? , ? ) ";
        String sqlClienteCarro = "insert into carros(fabricante, modelo, placa, cor, id_carro_cliente) values (? , ? ,? ,?, ?)";

        try(PreparedStatement preparedStatementClientes = con.prepareStatement(sqlClientes , PreparedStatement.RETURN_GENERATED_KEYS))
        {

            preparedStatementClientes.setString(1, cliente.getNome());
            preparedStatementClientes.setString(2, cliente.getCpf());

            preparedStatementClientes.execute();

                 
              

            try(ResultSet resultSetClientes = preparedStatementClientes.getGeneratedKeys())
            {

               
                while(resultSetClientes.next())
                {
                    cliente.setId(resultSetClientes.getInt(1));
                }

                try(PreparedStatement preparedStatementClienteCarro = con.prepareStatement(sqlClienteCarro, PreparedStatement.RETURN_GENERATED_KEYS))
                {
        
                        preparedStatementClienteCarro.setString(1, carro.getFabricante());
                        preparedStatementClienteCarro.setString(2, carro.getModelo());
                        preparedStatementClienteCarro.setString(3, carro.getPlaca());
                        preparedStatementClienteCarro.setString(4, carro.getCor());
                        preparedStatementClienteCarro.setInt(5, cliente.getId());
                        
                        
                        preparedStatementClienteCarro.execute();
        
                       
        
                        try(ResultSet resultSetClientesCarros = preparedStatementClienteCarro.getGeneratedKeys()){
        
                            while(resultSetClientesCarros.next())
                            {
                                carro.setId(resultSetClientesCarros.getInt(1));
                              
                               
                            }
                        }       
                }
           }     

           System.out.println("Cliente adicionado com sucesso no banco de dados");
        }
    }

    public void listar() throws SQLException
    {

         String sqlListarClientesCarros = "select C.id_cliente, C.nome, C.cpf, A.fabricante, A.modelo, A.placa,A.cor from cliente C  inner join carros A on C.id_cliente = A.id_carro_cliente";

         try(PreparedStatement clientesCarros = con.prepareStatement(sqlListarClientesCarros))
         {
            clientesCarros.execute();

            
            try(ResultSet ResultClientesCarros = clientesCarros.getResultSet())
            {
                while(ResultClientesCarros.next())
                {
                    int id_cliente = ResultClientesCarros.getInt(1);
                    String nomeCliente = ResultClientesCarros.getString(2);
                    String modeloCarro = ResultClientesCarros.getString(3);
                    String placaCarro = ResultClientesCarros.getString(4);
                    String fabricanteCarro = ResultClientesCarros.getString(5);
                    String corCarro = ResultClientesCarros.getString(6);

                  String StringFormatada = String.format("ID do cliente: %d  \n nome: %s \n modelo: %s \n placa: %s \n fabricante: %s \n cor: %s " , id_cliente, nomeCliente, modeloCarro, placaCarro, fabricanteCarro, corCarro);

                  System.out.println("_____________________");

                  System.out.println(StringFormatada);
                }
            }
        }
    }


    //para deletar um cliente, bastar usar o cpf dele listado no banco de dados(use o metado listar)
    public void deletar(String cpf) throws SQLException
    {

        String sqlDeletar = "delete from cliente where cpf = ?";

        try(PreparedStatement deletaClientes = con.prepareStatement(sqlDeletar))
        {
                deletaClientes.setString(1, cpf);

                deletaClientes.execute();

                System.out.println("cliente deletado!!!");
        }

    }


    //para atualizar os dados pessoas do cliente, basta passar o novo nome, cpf e o id do cliente no bancco de dados,(para ver o id, bastar usar o metado listar)
    public void atualizarCliente(String nome , String cpf, int
     id ) throws SQLException
    {

        String sqlAtualizaClientes = "update cliente C set C.nome = ? , C.cpf = ? where id_cliente = ?";

        try(PreparedStatement atualizaClientes = con.prepareStatement(sqlAtualizaClientes))
        {

            atualizaClientes.setString(1, nome);
            atualizaClientes.setString(2, cpf);
            atualizaClientes.setInt(3, id);
            
            atualizaClientes.execute();

            System.out.println("cliente atualizado com sucesso!!");
        }
    }

    //metado para atualizar os dados do carro dos clientes,para saber o id do carro, bastar usar metado listar()
    public void atualizarCarro( String fabricante, String modelo, String placa, String cor, String id) throws SQLException
    {
            String sqlAtualizaCarro = "Update carros A set A.fabricante = ?, A.modelo = ?, A.placa = ? , A.cor = ? where id_carro_cliente = ?";

            try(PreparedStatement atualizaCarros = con.prepareStatement(sqlAtualizaCarro)){
                
                atualizaCarros.setString(1, fabricante);
                atualizaCarros.setString(2, modelo);
                atualizaCarros.setString(3, placa);
                atualizaCarros.setString(4, cor);
                atualizaCarros.setString(5, id);

                atualizaCarros.execute();

                System.out.println("dados do carro atualizado!!");
            }

    }
}
