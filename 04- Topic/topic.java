
package topic;

import java.util.ArrayList;
import java.util.Scanner;

class Passageiro{
    String id;
    int idade;
    
    public Passageiro(String id, int idade){
    this.id = id;
    this.idade = idade;
    }
    
    public String toString(){
    return this.id + ":" + this.idade;
        }
    public boolean preferencial(){
        return (idade >= 60);
    }
}

class topic{
    ArrayList <Passageiro> poltronas;
    int qtdPreferenciais;
    public topic(int capacidade, int qtdPreferenciais){
        poltronas = new ArrayList<Passageiro>();
        for(int i = 0; i < capacidade; i++){
            poltronas.add(null);
        }
        this.qtdPreferenciais = qtdPreferenciais;
    }
    @Override
    public String toString(){
        String saida = "[";
        for(int i = 0; i < poltronas.size(); i++){
             
            if (i < qtdPreferenciais)
                saida += " @";
            else
                saida += " =";
           if(poltronas.get(i) != null)
               saida += poltronas.get(i);
            
        }
        return saida + " ]";
    }
    
public void inserir(Passageiro pass){
        if (pass.preferencial()){
            for(int i = 0 ; i < qtdPreferenciais;i++){
                if(poltronas.get(i) == null){
                    poltronas.set(i, pass);
                    return;
                }
            }
            for(int i = qtdPreferenciais ; i < poltronas.size();i++){
                if(poltronas.get(i) == null){
                    poltronas.set(i, pass);
                    return;
                }
            }
       }else{
                for(int i = qtdPreferenciais ; i < poltronas.size();i++){
                if(poltronas.get(i) == null){
                    poltronas.set(i, pass);
                    return;
                }
            }
        }
    }
 public void remover(String id){
      
        for (int i = 0;i<poltronas.size();i++){
            if(poltronas.get(i) != null){
                 if(poltronas.get(i).id.equals(id)){
                    poltronas.set(i,null);
            }
           }
        }
 }
}
class controller {
    public static void main(String[] args) {
        topic topique = new topic(0,0);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if (ui[0].equals("sair")){
                break;
            }else if (ui[0].equals("init")){
                topique = new topic(Integer.parseInt(ui[1]),Integer.parseInt(ui[2]));
            }else if(ui[0].equals("show")){
                System.out.println(topique);
            }else if(ui[0].equals("in")){
                topique.inserir(new Passageiro(ui[1],Integer.parseInt(ui[2])));
            }else if(ui[0].equals("remov")){
               topique.remover(ui[1]);
            }else{
                System.out.println("ERRO:Comando Invalido\n");
            }
        }
    
    }
}
