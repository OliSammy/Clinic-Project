package output;
import java.util.Scanner;
import controladores.Clientes;
import entidades.Paciente;
public class MenuCliente {
    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Clientes cliente = new Clientes();

    public MenuCliente() {

    }
    public void mostrarPacientes() {
        while (true) {
        System.out.println("\t\t*Menu Pacientes selecionado*");
        System.out.println("\nSelecione uma opção abaixo:");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
        opcao = inputInt.nextInt();
        if(opcao==6){
            break;
        }
        switch (opcao) {
            //Cadastrar Paciente
            case 1  :
                System.out.println("\t\t\n*Cadastrar Paciente selecionado*");
                System.out.println("\nDigite o nome do paciente:");
                String nome = inputString.nextLine();
                System.out.println("\nDigite a idade do paciente:");
                int idade = inputInt.nextInt();
                System.out.println("\nDigite o gênero do paciente:");
                String genero = inputString.nextLine();
                System.out.println("\nDigite o CPF do paciente:");
                long cpf = inputInt.nextLong();
                Paciente pacienteNovo = new Paciente(nome, idade, genero, cpf);
                if(cliente.verificarCliente(pacienteNovo)){
                    System.out.println("\nJá existe um paciente com esse CPF, voltando ao menu...");
                    break;
                }
                cliente.adicionarCliente(pacienteNovo);
                System.out.println("\nPaciente cadastrado com sucesso!");
                break;

            //Alterar Paciente
            case 2:
            System.out.println("\t\t\n*Alterar Paciente selecionado*");
            System.out.println("\nDigite o CPF do paciente que deseja alterar:");
            int cpfAlterar = inputInt.nextInt();
            Paciente paciente = cliente.selecionarCliente(cpfAlterar);
            if (paciente == null) {
                System.out.println("\nPaciente não encontrado, voltando ao menu...");
                return;
            }
                System.out.println("\nEsse é o paciente selecionado:\n"+paciente+ "\n Deseja alterar?\n Sim/Nao");
                String Escolha = inputString.nextLine();
                if (Escolha.equalsIgnoreCase("Nao")){
                    System.out.println("\nVoltando ao menu...");
                    break;
                }
                System.out.println("\nQual dado você deseja alterar\n1.Nome 2.Idade 3.Gênero 4.CPF");
                int opcaoAlterar = inputInt.nextInt();
                while (opcao != 1 && opcao != 2 && opcao != 3 && opcao != 4) {
                    System.out.println("\nOpção inválida, tente novamente!");
                    opcaoAlterar = inputInt.nextInt();                    
                }
                if (opcaoAlterar ==1 ) {
                    System.out.println("\nDigite o novo nome do paciente:");
                    String nomeAlterar = inputString.nextLine();
                    Paciente pacienteAlterado = new Paciente(nomeAlterar, paciente.getIdade(), paciente.getGenero(), paciente.getCpf());
                    cliente.alterarCliente(pacienteAlterado);
                    System.out.println("\nNome alterado com sucesso!");
                    break;
                }
                if (opcaoAlterar ==2 ) {
                    System.out.println("\nDigite a nova idade do paciente:");
                    int idadeAlterar = inputInt.nextInt();
                    Paciente pacienteAlterado = new Paciente(paciente.getNome(), idadeAlterar, paciente.getGenero(), paciente.getCpf());
                    cliente.alterarCliente(pacienteAlterado);
                    System.out.println("\nIdade alterada com sucesso!");
                    break;
                }
                if (opcaoAlterar ==3 ) {
                    System.out.println("\nDigite o novo gênero do paciente:");
                    String generoAlterar = inputString.nextLine();
                    Paciente pacienteAlterado = new Paciente(paciente.getNome(), paciente.getIdade(), generoAlterar, paciente.getCpf());
                    cliente.alterarCliente(pacienteAlterado);
                    System.out.println("\nGênero alterado com sucesso!");
                    break;
                }
                if (opcaoAlterar ==4 ) {
                    System.out.println("\nDigite o novo CPF do paciente:");
                    int cpfAlterado = inputInt.nextInt();
                    Paciente pacienteAlterado = new Paciente(paciente.getNome(), paciente.getIdade(), paciente.getGenero(), cpfAlterado);
                    cliente.alterarCliente(pacienteAlterado);
                    System.out.println("\nCPF alterado com sucesso!");
                    break;
                }
            //Remover Paciente
            case 3:
                System.out.println("\t\t*Remover Paciente selecionado*\n");
                System.out.println("\nDigite o CPF do paciente que deseja remover:");
                int cpfRemover = inputInt.nextInt();
                Paciente pacienteRemover = cliente.selecionarCliente(cpfRemover);
                if (pacienteRemover == null) {
                    System.out.println("\nPaciente não encontrado, voltando ao menu...");
                    return;
                }
                System.out.println("\nEsse é o paciente selecionado:\n"+pacienteRemover+ "\n Deseja remover?\n Sim/Nao");
                String Escolha2 = inputString.nextLine();
                if (Escolha2.equalsIgnoreCase("Nao")){
                    System.out.println("\nVoltando ao menu...");
                    break;
                }
                cliente.removerCliente(pacienteRemover);
                System.out.println("\nPaciente removido com sucesso!");
                break;
                //Pesquisar Paciente
            case 4:
            System.out.println("\t\t*Pesquisar Paciente selecionado*\n");
            System.out.println("\nDigite o CPF do paciente que deseja pesquisar:");
            int cpfPesquisar = inputInt.nextInt();
            Paciente pacientePesquisar = cliente.selecionarCliente(cpfPesquisar);
             if (pacientePesquisar == null) {
                    System.out.println("\nPaciente não encontrado, voltando ao menu...");
                    return;
                }
                System.out.println("\nEsse é o paciente selecionado:\n"+pacientePesquisar);
                break;
            case 5:
                System.out.println("\t\t*Listar Pacientes selecionado*\n");
                cliente.listarCliente();
                break;


            default:
                break;
        }

     }
    }
}
