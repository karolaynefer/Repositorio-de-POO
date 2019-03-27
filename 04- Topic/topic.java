
package topic;

import java.util.ArrayList;

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
    return idade <= 60;
}
}

class Topic{
    ArrayList <Passageiro> poltronas;
    int qtdPreferenciais;
    public Topic(int capacidade, int qtdPreferenciais){
        poltronas = new ArrayList<Passageiros>();
        for(int i = 0; i < capacidade; i++){
            poltronas.add(null);
        }
        this.qtdPreferenciais = qtdPreferenciais
    }
    @Override
    public String toString(){
        String saida = "[";
        for(int i = 0; i < poltronas.size(); i++){
            if (i < qtdPreferenciais)
                saida += " @";
            else
                saida += " =";        
        }
        return saida + " ]";
    }
}
        
public class Topic {
    
    public static void main(String[] args) {
        Topic topic = new topic(0, 0);
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
        }
    
    }
}
    
}
