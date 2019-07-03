
import java.util.ArrayList;
import java.util.Scanner;

class Funcionario{
    private int id;
    private String nome;
    protected double salario;
    private char titulo;
    
 
    public Funcionario(int id, String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
        this.titulo = 'F';
        this.id = id;
    }

    public void setTitulo(char titulo) {
        this.titulo = titulo; // colocar titulo
    }

    public char getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalario() {
         return salario + getBonificacao(); // salario total
    }
    
   public double getBonificacao() {
        return this.salario*0.10; // soma bonificação
    } 

    @Override
    public String toString() {
        return "Funcionario{" + "Contratou=" + id + ", Nome=" + nome + ", Salario"+ salario+ ", "
                + "salario+Bonificação=" + getSalario() +'}';
    }
}

class Diretor extends Funcionario {
    protected double gratificacao;
    private int id;
    
    public Diretor(int id, String nome, double salario) {
        super(id, nome, salario); // herda o id, nome e salario da class funcionario
        this.gratificacao = gratificacao;
        super.setTitulo('D'); // troca o titulo para D 
        this.id=id;
    } 
     
    public double getGratificacao() {
        return (salario*2); // soma da gratificaçao
    }

    public double getSalario() {
        return salario + getGratificacao(); // soma do salario total
    }    

    public int getIdD() {
        return id;
    }
    
    public char gettitulo(){
        return super.getTitulo(); // herda o titulo 
    }
    
    @Override
    public String toString() {
        return "Diretor{" + "id=" +id + ", nome=" + super.getNome() + ", salario=" + salario + ", Salar+Boni=" + getSalario() +"titulo="+gettitulo()+ '}'; //To change body of generated methods, choose Tools | Templates.
    }
}


class Empresa {
    
    ArrayList<Diretor> diretores; // ArrayList de diretores
    ArrayList<Funcionario> funcionarios;  //ArrayList de funcionarios
    int nextid; // proximo id
    public Empresa(){
        diretores = new ArrayList<Diretor>(); // inicia o ArrayList
        funcionarios = new ArrayList<>(); // inicia o ArrayList
        
    }
    
    public void addDiretor(String nome, double salario){
        this.diretores.add(new Diretor(this.nextid, nome, salario)); // add diretores no arrayList
        nextid +=1; // soma o id
    }
    
    public void addFuncionario(String nomeD, Funcionario funcionario){ 
        int id = findD(nomeD); // procura diretores no arrayList
        funcionarios.add(funcionario); // add funcionario no ArrayList
        
    }
    
    public void demitir(int idD, String nomef){ // demitir funcionario 
        Funcionario f = findF(idD, nomef); //procura func // pelo id do diretor e nome do func
        funcionarios.remove(f); // remove func do arrayList de func
    }
     
    int findD(String nome){ // procurar diretor
             for(Diretor d : diretores){ // percorrer diretores
                 if(d.getNome().equals(nome) ){ // se o nome digitado está no arrayList
                    return d.getIdD();  // retorna id do diretor
                 }
             }
            throw new RuntimeException("Diretor Não Existe"); // erro caso nao exista
        }
    
    Funcionario findF(int idD, String nome){ // procurar func
             for(Funcionario f : funcionarios){ // percorrer func
                 if(f.getNome().equals(nome) && f.getId() == idD){ // se o nome digitado está no arrayList
                    return f; // retorna o func
                 }
             }
            throw new RuntimeException("Diretor Não Existe"); // erro caso nao  exista
        }
    
    public void contratei(int idD){
        for(Funcionario f : funcionarios){ // percorrer func
            if(f.getId() ==  idD){ // se o id do func for igual ao id do dire
                System.out.println(f); // printa func
            }
        
        }
    
    }
    
    public String toString() {
        String saida = ""; 
        
        for(Diretor d : diretores){ //percorre diretores
        saida += d + "\n"; // soma saida mais diretores
        
        }
        
        saida += "\n";
        
        for(Funcionario f : funcionarios){ //percorre func
        saida += f + "\n"; // soma saida mais func
        }
        return saida; // return saida
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
            else if(ui[0].equals("addD")){
                emp.addDiretor(ui[1], Double.parseDouble(ui[2]));
                }
            else if(ui[0].equals("addF")){
                int idD = emp.findD(ui[1]);
                emp.addFuncionario(ui[1], new Funcionario(idD, ui[2],Double.parseDouble(ui[3])));
            }
            else if(ui[0].equals("mostrar")){
                System.out.println(emp);
            }
            else if(ui[0].equals("Dem")){
                int id = emp.findD(ui[1]);
                emp.demitir(id, ui[2]);
            }
            else if(ui[0].equals("Con")){
                int id = emp.findD(ui[1]);
                emp.contratei(id);
            }
        }
    }
    
}
