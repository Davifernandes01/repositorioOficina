package classesDeTeste;

import java.util.ArrayList;
import java.util.List;

import classesPrincipais.Carros;

public class TesteCarros {
    
    public static void main(String[] args) {
        
        Carros unoCarros = new Carros("fiat", "uno", "ABS-089", "branca");

        Carros unoCarro = new Carros("fiat", "uno", "ABS-089", "branca");

        Carros unoCarross = new Carros("fiat", "uno", "ABS-088", "verde");

        List<Carros> carro = new ArrayList<>();

        carro.add(unoCarros);
        carro.add(unoCarro);
        carro.add(unoCarross);

        carro.stream().forEach(System.out::println);

        

    }
}
