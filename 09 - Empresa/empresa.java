package empresa;
import java.util.Scanner;


class Funcionario {
    private String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double getBonificacao() {
        return this.salario*0.10;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", salario=" + salario + '}';
    }
}

class Gerente extends Funcionario {
    private String senha;

    public Gerente(String nome, double salario, String senha) {
        super(nome, salario);
        this.senha = senha;
    }
    String contratar() {
        return "Contratei um funcionaria"; 
}
    String Demitir () {
        return "Demiti um funcionario";
    }
    public double getbonificacao() {
        return this.salario * 0.15;
}
    @Override
    public String toString() {
        return "Gerente:" + super.toString();
}

    double getSalario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   }

class Diretor extends Gerente {
    double gratificacao;
    
    public Diretor (String nome, double salario,String senha, double gratificacao) {
        super(nome, salario, senha);
        this.gratificacao = gratificacao;   
    
    } 
    
    public double getBonificacao (){
    return super.getBonificacao() * 0.15;  
        
}
	public double getSalario(){
    	return super.getSalario() + gratificacao;

}
        @Override
	public String toString() {
		return super.toString() + ":" + gratificacao;

        }
}
    

public class empresa {
   public static void main(String[] args) {
      
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		String line = scan.nextLine();
		String  ui[] = line.split(" ");
		if(ui[0].equals("end")) {
			break;
                }
                
               }
   }
}

