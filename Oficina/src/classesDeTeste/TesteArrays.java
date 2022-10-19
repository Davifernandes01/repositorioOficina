package classesDeTeste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthToolTipUI;

import classesPrincipais.Carros;
import classesPrincipais.Clientes;

public class TesteArrays {
    
    /**
     * @param args
     */
    public static void main(String[] args)  {
        
        long inicio = System.currentTimeMillis();
        Clientes c1 = new Clientes("davi", "2344-9867");
        c1.adiciona(new Carros("fiat", "Uno", "EWR-978", "azul"));
        Clientes c2 = new Clientes("rada", "1345-8667");
        c2.adiciona(new Carros("ford", "ford ka", "DRR-548", "azul"));
        Clientes c3 = new Clientes("minos", "7564-7685");
        c3.adiciona(new Carros("audi", "audi-5000", "mng-932", "azul"));

        Clientes c5 = new Clientes("minos", "7164-7685");
        c5.adiciona(new Carros("audi", "audi-5000", "mng-932", "azul"));


        List<Clientes> cliente = new ArrayList();

        cliente.add(c2);
        cliente.add(c3);
        cliente.add(c1);
        cliente.add(c5);
        
       cliente.stream()
            .filter(c -> c.getNome() == "minos")
            .forEach(c -> System.out.println(c));
     
        cliente.stream().sorted()
        .forEach(System.out::println);

        cliente.stream().map(c -> c.getNome() == "minos")
        .forEach(c -> System.out.println(c));

            System.out.println(cliente.stream()
            .count());
        
            cliente.forEach(System.out::println);

        
       

    }
}
