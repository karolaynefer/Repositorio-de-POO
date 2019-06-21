
package empresa;

import java.util.Scanner;

class Funcionario {
    protected String nome;
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
    protected String senha;

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

    @Override
    public String toString() {
        return "Gerente:" + super.toString();
    }
}

public class Empresa {
   
    public static void main(String[] args) {
        Empresa emp = new Empresa();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		String line = scan.nextLine();
		String  ui[] = line.split(" ");
		if(ui[0].equals("end")) {
			break;
                }

