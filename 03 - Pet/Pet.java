import java.util.Scanner;

public class Pet {
    
   private String nome;
   private int energia;
   private int saciedade;
   private int limpeza;
   private int energiaMax;
   private int saciedadeMax;
   private int limpezaMax;
   private int diamante;
   private int idade;
   private boolean vivo;
   
    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if(this.energia >= this.energiaMax ){
                this.energia = this.energiaMax;
        }
        else if(this.energia <= 0){
            this.energia = 0; 
            this.vivo = false;
        }
        this.energia = energia;
    }

    public boolean Vivo() {
       return vivo;
        
    }

    public int getSaciedade() {
        return saciedade;
    }

    public void setSaciedade(int saciedade) {
        if(this.saciedade >= this.saciedadeMax){
            this.saciedade = this.saciedadeMax;
        }
        else if(this.saciedade <= 0){
            this.saciedade = 0;
            this.vivo = false;
        }
        this.saciedade = saciedade;
    }

    public int getLimpeza() {
        return limpeza;
    }

    public void setLimpeza(int limpeza) {
          if(this.limpeza >= this.limpezaMax){
            this.limpeza = this.limpezaMax;
        }
        else if(this.limpeza <= 0){
            this.limpeza = 0;
            this.vivo = false;
        }
        this.limpeza = limpeza;
    }

    public boolean setVivo(boolean vivo) {
        if(this.vivo){
            return true;
        }
        System.out.println("Seu Pet esta morto!!!!!!!");
        return false;
    }

    public int getEnergiaMax() {
        return energiaMax;
    }

    public void setEnergiaMax(int energiaMax) {
        this.energiaMax = energiaMax;
    }

    public int getSaciedadeMax() {
        return saciedadeMax;
    }

    public void setSaciedadeMax(int saciedadeMax) {
        this.saciedadeMax = saciedadeMax;
    }

    public int getLimpezaMax() {
        return limpezaMax;
    }

    public void setLimpezaMax(int limpezaMax) {
        this.limpezaMax = limpezaMax;
    }

    public int getDiamante() {
        return diamante;
    }

    public void setDiamante(int diamante) {
        this.diamante = diamante;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public Pet(String nome, int energia, int saciedade, int limpeza) {
        this.nome = nome;
        this.energia = energia;
        this.saciedade = saciedade;
        this.limpeza = limpeza;
        this.energiaMax = energia;
        this.saciedadeMax = saciedade;
        this.limpezaMax = limpeza;
        this.diamante = 0;
        this.idade = 0;
        this.vivo = true;
    }
    
    public void Comer(){
        if(setVivo(vivo)){
            setEnergia(getEnergia()-1);
            setSaciedade(getSaciedade()+4);
            setLimpeza(getLimpeza()-2);
            setIdade(getIdade()+1);
        }
    }
    public void brincar(){
    if(setVivo(vivo)){
            setEnergia(getEnergia()-2);
            setSaciedade(getSaciedade()-1);
            setLimpeza(getLimpeza()-3);
            setIdade(getIdade()+1);
            setDiamante(getDiamante()+1);
        }
    }
    
    public void banho(){
         if(setVivo(vivo)){
            setEnergia(getEnergia()-3);
            setSaciedade(getSaciedade()-1);
            setLimpeza(getLimpezaMax());
            setIdade(getIdade()+2);
            
        }
    }
    public void dormir(){
    if(!setVivo(vivo)){
            return;
            }
    if(this.energiaMax - this.energia == 0){
        System.out.println("Seu Pet esta Cheio de Energia");
        return;
    }
    this.idade += this.energiaMax - this.energia;
    this.energia = this.energiaMax;
    }
    
    public String toString() {
        
     return  "Nome: [" + this.nome + "] " +
                "Energia: [" + this.energia + "/" + this.energiaMax + "] " +
                "Saciedade: [" + this.saciedade + "/" + this.saciedadeMax + "] " +
                "Limpeza: [" + this.limpeza + "/" + this.limpezaMax + "] "+
                "Idade: [" + this.idade+"]"+
                "Diamante: [" + this.diamante +"]";
}};

class Controller{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Pet pet = new Pet("", 0, 0, 0);
        System.out.println("mostrar, init _nome _E _S _L, sair");
        while(true){
            String linha = scan.nextLine();
            
            String[] ui = linha.split(" ");
            
            if(ui[0].equals("mostrar")){
                System.out.println(pet);
            }
            else if(ui[0].equals("init")){
                pet = new Pet(ui[1], Integer.parseInt(ui[2]),
                                     Integer.parseInt(ui[3]),
                                     Integer.parseInt(ui[4]));
            }
            else if(ui[0].equals("Brincar")){
            pet.brincar();
            System.out.println(pet);
            }
            else if(ui[0].equals("Comer")){
                pet.Comer();
                System.out.println(pet);
            }
            else if(ui[0].equals("Lavar")){
            pet.banho();
            System.out.println(pet);
            }
            else{
                System.out.println("comando invalido");
            }
        }
    }
}