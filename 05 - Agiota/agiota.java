
package agiota;

class Transação{
    int id;
    float valor;
    String cliente;
    
    public Transacao(int id, float valor, String cliente){
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
     }

    @Override
    public String toString() {
       return "" + id + ":" + valor + ":" + cliente;
    }
}

class Cliente{
    String id;
    String nome;
    float saldo;
    
    public Cliente (String id, String nome){
        this.id = id;
        this.nome = nome;
        this.saldo = 0;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.nome + ":" + this.saldo;
    }
}

class Sistema{
    float saldo;
    int nextTrId;
    ArrayList <clinte> cliente;
    ArrayList <transacao> transacoes;
    
    public Sistema(float saldo){
        this.saldo = saldo;
        this.cliente = new ArrayList <cliente>();
        this.transacoes = new ArrayList <transacao>() 
        this.nextTrId = 0;
}
    
    void cadastrar (Cliente cliente){
        try{
            this.findCliente(cliente.id);
            throw new RuntimeException ("Cliente já existe");
        }catch (RuntimeExeption re){
            cliente.add(cliente);
        }
    }
}


public class Controller {

    public static void main(String[] args) {
       
    }
    
}
