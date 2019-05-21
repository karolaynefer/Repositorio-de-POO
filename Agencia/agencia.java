package agencia;

import java.util.ArrayList;
import java.util.Scanner;
import agencia.Conta;
import agencia.cliente;

class cliente{
    String id;
    
    public cliente(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "cliente{" + "id=" + id + '}';
    }
    
    
}

class Conta{
        int id_conta;
        float saldo;
        
        public Conta(int id_conta,float saldo){
           
            this.id_conta = id_conta;
            this.saldo = saldo;
            
        }

    public String toString() {
        return "conta{" + "id_conta=" + id_conta + ", saldo=" + saldo + '}';
    }
        
        
}


class corrente extends Conta{
  
    public corrente(int id_conta, float saldo) {
        super(id_conta, saldo);
    }

    @Override
   public String toString() {
		return super.toString()+ " CC";
	}
  
}

class poupanca extends Conta{

    public poupanca(int id_conta, float saldo) {
        super(id_conta, saldo);
    }
    
    public String toString() {
		return super.toString()+ " CP";
	}
}

class banco{
        ArrayList<cliente>clientes;
        ArrayList<Conta>contas;
        
        public banco(){
            clientes = new ArrayList<cliente>();
            contas = new ArrayList<Conta>();
        }
       
        public void addcli(cliente cli){
            try {
            this.findCliente(cli.id);
            throw new RuntimeException("Cliente ja exite");
        }catch(RuntimeException re){
           clientes.add(cli);
           
        }
       }
        public void addconta(Conta c){
            contas.add(c);
        }
           
        
        
        cliente findCliente(String id) {
            
            for (cliente cli : clientes) {
                if (cli.id.equals(id))
                    return cli;
            }
            throw new RuntimeException("fail: cliente nao existe");
        }
        
        public String toString() {
		return " "  +clientes+contas;
	}
        
            

}

public class agencia {

    public static void main(String[] args) {
        
        banco b = new banco();
        
        Scanner scan = new Scanner(System.in);
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            try{
                if (ui[0].equals("sair")){
                    break;
                }else if(ui[0].equals("add")){
                    
                }else if(ui[0].equals("show")){
                   
                }else if(ui[0].equals("depo")){
                    
                }else if(ui[0].equals("saq")){
                    
                }else if(ui[0].equals("tran")){
                    
                }
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
    }
}
