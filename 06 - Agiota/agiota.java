package agiota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


class Transacao{
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
    boolean vivo;
    
    public Cliente (String id, String nome){
        this.id = id;
        this.nome = nome;
        this.saldo = 0;               
        this.vivo = true;
    }

    @Override
    public String toString() {
        return this.id + ":" + this.nome + ":" + this.saldo;
    }
}

class Sistema{
    float saldo;
    int nextTrId;
    ArrayList <Cliente> cliente;
    ArrayList <Transacao> transacoes;
    
    public Sistema(float saldo){
        this.saldo = saldo;
        this.cliente = new ArrayList <Cliente>();
        this.transacoes = new ArrayList <Transacao>();
        this.nextTrId = 0;
    }     
      Cliente procurarcliente(String id){
        for (Cliente cli : cliente) {
            if (cli.id.equals(id))
                return cli;
        }
          throw new RuntimeException("Cliente Não Existe");
          }
      
      void cadastrarcliente(Cliente cli){
           try {
           this.procurarcliente(cli.id);
           throw new RuntimeException("Cleinte Já Existe");
           }
           catch(RuntimeException re){
                cliente.add(cli);
           }
      
      }
      
      void addTransacao(float valor , String id){
          this.transacoes.add(new Transacao(nextTrId, valor, id));
          nextTrId +=1;
      }

      void empresta(String id,float valor){
          Cliente cli = procurarcliente(id);   
          addTransacao(valor, id);
          this.saldo -= valor;
          cli.saldo += valor;
      }
      
      void receber(String id,Float valor){
         Cliente cli = procurarcliente(id);
         if(cli.saldo < valor){
             System.out.println("Pagamento Irregular");
             return;
         }else{
             addTransacao(valor, id);
             cli.saldo -= valor;
             this.saldo += valor;
         }         
      }
      
      ArrayList<Transacao> gethistory(){
             return transacoes;
      }
      
      public String toString() {
        String saida = "";
        for(Cliente cliente : cliente)
            saida += cliente + "\n";
        saida += "saldo:" + this.saldo;
        return saida;
    }
      
}



public class Agiota {
    
    public static void main(String[] args) {
        Sistema sistema = new Sistema(0);
        Scanner scan = new Scanner(System.in);
      
        while(true){
            String line = scan.nextLine();
            String[] ui = line.split(" ");
            try{
                if (ui[0].equals("sair")){
                    break;
                }else if (ui[0].equals("init")){
                    sistema = new Sistema(Float.parseFloat(ui[1]));
                }else if (ui[0].equals("cadastrar")){
                    String id = ui[1];
                    String[] subarray = Arrays.copyOfRange (ui, 2, ui.length);
                    String fullname = String.join(" ", subarray);
                    sistema.cadastrarcliente(new Cliente(id, fullname));
                }else if (ui[0].equals("show")){
                        System.out.println(sistema);
                }else if (ui[0].equals("emprestar")) {
                    sistema.empresta(ui[1], Float.parseFloat(ui[2]));
                }else if (ui[0].equals("historico")) {
                    for (Transacao tr : sistema.gethistory())
                        System.out.println(tr);
                }else{
                    System.out.println("Erro: Comando Invalido");
                }
            }catch(RuntimeException re){
                System.out.println(re.getMessage());
            }
        }
        
    }
    
}
