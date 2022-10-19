package testeDb;

import java.sql.Connection;
import java.sql.SQLException;


import DAO.OficinaDao;
import classesPrincipais.Carros;
import classesPrincipais.Clientes;
import conexaoDB.ConnectionFactory;

public class Teste 
{
    //area para testes!!!!
    public static void main(String[] args) throws SQLException 
    {
        
        // Clientes c1 = new Clientes("davi", "1260978655");
        // Carros c1Carros = new Carros("toyota", "citroen", "MJH-987", "azul");

        // c1.adiciona(c1Carros);

        Clientes c3 = new Clientes("kagaho", "65734839");
        Carros c3Carros = new Carros("fiat", "ranger", "WEU-321", "azul");
        c3.adiciona(c3Carros);

        Clientes c4 = new Clientes("minos", "12345698");
         Carros c4Carros = new Carros("a", "uytuy", "WEU-321", "cinza");
        // c4.adiciona(c4Carros);

        try(Connection con = new ConnectionFactory().connectionFactory())
        {
                OficinaDao conectaBancoOficina = new OficinaDao(con);

            conectaBancoOficina.listar();

            //conectaBancoOficina.salvar(c4, c4Carros);

               // conectaBancoOficina.salvar(c3, c3Carros);

               // conectaBancoOficina.atualizarCliente("rada", "15453434", 1);

            //    Set<Clientes> listaDeClientes =  conectaBancoOficina.listar();

         
        }

        

        
        
    }
}
