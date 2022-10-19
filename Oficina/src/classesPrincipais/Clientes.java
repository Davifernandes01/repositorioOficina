package classesPrincipais;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import classesException.ExceptionCpfIgual;

// classe cliente, não pode existir dois cpfs iguais
public class Clientes implements Comparable<Clientes> {

    private Integer id;
    private String nome;
    private String cpf;
    protected Set<Carros> carro = new HashSet<Carros>();
    private Map<String, String> busca = new HashMap();

    //construtor nãompode ser vazio
    public Clientes(String nome, String cpf) {

        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new NullPointerException("construtor NOME vazio!");
        }

        if (!cpf.isEmpty()) {
            this.cpf = cpf;
        } else {
            throw new NullPointerException("construtor CPF vazio!");
        }

        // this.busca.put(cpf, nome);

    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Carros> getCarro() {
        return Collections.unmodifiableSet(carro);
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void adiciona(Carros carros) {

        this.carro.add(carros);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("cliente adicionado no banco de dados! %d %s %s " , this.id, this.nome, this.cpf );
    }

    @Override

    public int compareTo(Clientes outroCliente) {
        // TODO Auto-generated method stub
        return this.getNome().compareTo(outroCliente.getNome());
    }

    //para saber se o cpf é igual ou nao
    @Override
    public boolean equals(Object ref) {

        Clientes outro = (Clientes) ref;
        if (this.cpf == outro.cpf) {

            throw new ExceptionCpfIgual("CPF ja existe no sistema!!!!");
        }

        return this.cpf.equals(outro.cpf);
    }

    @Override
    public int hashCode() {

        return this.cpf.hashCode();
    }


    

 

}
