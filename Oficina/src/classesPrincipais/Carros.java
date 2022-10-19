package classesPrincipais;
import classesException.ExceptionPlacaIgual;


// classe Carros, não pode ter o construtor vazio ou nulo.
public class Carros {

    
    private Integer id;
    private String fabricante;
    private String modelo;
    private String placa;
    private String cor;

    public Carros (String fabricante, String modelo, String placa, String cor){

        if(!fabricante.isEmpty()){
            this.fabricante = fabricante;
        }else throw new NullPointerException("Adicione um fabricante!!!");
        
        if(!modelo.isEmpty()){
            this.modelo = modelo;
        } else throw new NullPointerException("adicione um modelo!!!");

        if(!placa.isEmpty()){
            this.placa = placa;
        } else throw new NullPointerException("adicione uma placa!!");

            
        if(!cor.isEmpty()){
            this.cor = cor;
        }else throw new NullPointerException("adicione uma cor!!!!");
 

    }

    
    
public void setId(int  id){
    this.id = id;
}

    public String getModelo() {
        return modelo;
    }

                public String getPlaca() {
                    return placa;
                }

         public String getCor() {
             return cor;
         }

    public String getFabricante() {
        return fabricante;
    }

  

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format("Carro adicionado no banco de dados!! %d %s %s %s %s ", this.id, this.fabricante, this.modelo, this.placa, this.cor);


    }

    //para diferenciar quando um carro é diferente do outro
    @Override
    public boolean equals(Object ref) {
        
        Carros outra = (Carros) ref;
      
        if(this.placa.equals(outra.placa)){
            throw new ExceptionPlacaIgual("Placa ja existente no sistema");
        }
        else


        return this.placa.equals(outra.placa);
    }

    @Override
    public int hashCode() {
        
        return this.placa.hashCode();
    }
    
}
