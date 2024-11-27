import java.util.ArrayList;
import java.util.Scanner;

class Pessoa{

    private String nomePessoa;
    private int idade;

    public Pessoa(String nomePessoa, int idade) {
        this.nomePessoa = nomePessoa;
        this.idade = idade;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString(){
        return "Pessoa [nome = " + nomePessoa + ", idade = " + idade + "]";
    }

    public static void cadastrarPessoa(ArrayList<Pessoa> lista, ArrayList<Apartamento> apartamentos, Scanner scanner){
        System.out.println("Digite o seu nome: ");
        String nomePessoa = scanner.nextLine();

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Escolha o número do apartamento: ");
        int numeroAp = scanner.nextInt();
        if (numeroAp > 20){
            System.out.println("Apartamento inválido, tente novamente");
        } else {
            Apartamento apartamento = new Apartamento(nomePessoa, idade, numeroAp);
            apartamentos.add(apartamento);
            lista.add(apartamento);
            System.out.println("Cadastro realizado com sucesso! Pessoa e apartamento registrados.");
        }
    }

    public static void listarHospedes(ArrayList<Apartamento> apartamentos) {
        if (apartamentos.isEmpty()) {
            System.out.println("Nenhum apartamento registrado.");
        } else {
            System.out.println("Lista de Hóspedes Cadastrados:");
            for (int i = 0; i < apartamentos.size(); i++) {
                Apartamento ap = apartamentos.get(i);
                System.out.println((i + 1) + ". " + "Hóspede: " + ap.getNomePessoa() + ", Idade: " + ap.getIdade() + ", Apartamento nº " + ap.getNumeroAp());
            }
        }
    }
}

class Apartamento extends Pessoa{
    private int numeroAp;

    public Apartamento(String nomePessoa, int idade, int numeroAp) {
        super(nomePessoa, idade);
        this.numeroAp = numeroAp;
    }

    public int getNumeroAp() {
        return numeroAp;
    }

    public void setNumeroAp(int numeroAp) {
        this.numeroAp = numeroAp;

    }

    @Override
    public String toString() {
        return super.toString() + "Apartamento numero: " + numeroAp;
    }
}

public class Hotel {
    public static void main(String[] args) {

        ArrayList<Pessoa> lista = new ArrayList<>();
        ArrayList<Apartamento> apartamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("\n------- SISTEMA HOTEL -------");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Listar Apartamento");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    Pessoa.cadastrarPessoa(lista, apartamentos , scanner);
                    break;
                case 2:
                    Pessoa.listarHospedes(apartamentos);
                    break;
                case 3:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente\n");
                    break;
            }

        }while(opcao != 3);
        scanner.close();
    }
}
