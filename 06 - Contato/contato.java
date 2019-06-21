package contato;

class Fone{
    String label;
    String numero;
    boolean valiData;
    
    public Fone (String label, String numero, boolean valiData){
        this.label = label;
        this.numero = numero;
        this.valiData = valiData;
        
    }

    @Override
    public String toString() {
        return "" + label + ":" + numero + ":" + valiData;
    }
}

class Contato{
    String nome;
    int fones;
    boolean addFone;
    boolean rmFone;
    int ind;
    
    public Contato(String nome, int fones, boolean addFone, boolean rmFone, int ind){
        this.nome = nome;
        this.fones = fones;
        this.addFone = addFone;
        this.rmFone = rmFone;
        this.ind = ind; 
    }

    @Override
    public String toString() {
        return "" + nome + ":" + fones + ":" + addFone + ":" + rmFone + ":" + ind;
    }
}

class Sistema{
    
}


public class controler {

    public static void main(String[] args) {
        
    }
    
}
