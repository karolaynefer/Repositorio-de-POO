package empresa;
import java.util.ArrayList;
import java.util.Scanner;


class Funcionario {
    private String nome;
    protected double salario;
    protected char titulo;
    
    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.titulo = 'F';
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario + getBonificacao();
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
        this.titulo = 'G';
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
 }

class Diretor extends Gerente {
    double gratificacao;
    
    public Diretor (String nome, double salario, double gratificacao) {
        super(nome, salario, nome);
        this.gratificacao = gratificacao;   
        this.titulo = 'D';
    } 
    
    public double getBonificacao (){
    return super.getBonificacao() * 2;  
        
}
	public double getSalario(){
    	return super.getSalario() + gratificacao;

}
        @Override
	public String toString() {
		return super.toString() + ":" + gratificacao;

        }
}

class Empresa {
    ArrayList<Funcionario> funcionarios;
    public Empresa(){
        funcionarios = new ArrayList<Funcionario>();
    }
    public void addFuncionario(Funcionario func){
        funcionarios.add(func);
    }

    public double calcularFolha(){
        double folha = 0.0;
        for(Funcionario func : funcionarios)
            folha += func.getSalario();
        return folha;
    }

    @Override
    public String toString() {
        String saida = "";
        for(Funcionario func : funcionarios)
            saida += func + "\n";
        return saida;

    }
}
    

public class Controller {
   public static void main(String[] args) {
       Empresa emp = new Empresa();
       Scanner scanner = new Scanner(System.in);
       
       while(true) {
		String line = scanner.nextLine();
		String  ui[] = line.split(" ");
		if(ui[0].equals("sair")) {
			break;
                }
                else if(ui[0].equals("addF")){
                emp.addFuncionario(new Funcionario(ui[1], Double.parseDouble(ui[2])));
            }
                else if(ui[0].equals("addG")){
                emp.addFuncionario(new Gerente(ui[1], Double.parseDouble(ui[2]), ui[3]));
            }
                else if(ui[0].equals("addD")){
                emp.addFuncionario(new Diretor(ui[1], Double.parseDouble(ui[2]), Double.parseDouble(ui[3])));
            }
                else if(ui[0].equals("mostrar")){
                System.out.println(emp);
            }
                else if(ui[0].equals("folha")){
                System.out.println(emp.calcularFolha());
            }
        }
                
           }
     }



