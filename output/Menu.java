package output;
import java.util.Scanner;
import controladores.*;
import entidades.Medico;
public class Menu {
    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Staff staff = new Staff();

    public void Principal() {
        System.out.println("\nBem-Vindo à Clinica dos Viados\n");
        System.out.println("Para prosseguimos com o programa selecione uma opção abaixo:");
        System.out.println("\n1.Médicos 2.Paciente 3.Agendamentos 4.Relatórios 5.sair\n\n");
        opcao = inputInt.nextInt();
        switch (opcao) {
            case 1:
                mostrarMedicos();
                break;
            case 2:
                mostrarPacientes();
                break;
            case 3: 
               mostrarConsultas();
            case 4: 
               mostrarRelatorio();
                break;
            case 5: 
                System.out.println("\nObrigado por usar o programa!");
                break;
            default:
            System.out.println("\nOpção inválida, tente novamente!");
                Principal();
                break;
        }
    }   
        
    public void mostrarMedicos() {
        System.out.println("\t\t*Menu Médicos selecionado*\n");
        System.out.println("Selecione uma opção abaixo:");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar\n\n");
        opcao = inputInt.nextInt();
        switch (opcao) {
            //Cadastrar Médico
            case 1:
                System.out.println("\t\t*Cadastrar Médico selecionado*\n");
                System.out.println("\nDigite o nome do médico:");
                String nome = inputString.nextLine();
                System.out.println("\nDigite a especialidade do médico:");
                String especialidade = inputString.nextLine();
                System.out.println("\nDigite o ID do médico:");
                int id = inputInt.nextInt();
                Medico medicoNovo = new Medico(nome, especialidade, id);
                staff.adicionarMedico(medicoNovo);
                mostrarMedicos();
                break;
            //Alterar Médico
            case 2:
                System.out.println("\t\t*Alterar Médico selecionado*\n");
                System.out.println("\nDigite o ID do médico que deseja alterar:");
                int idAlterar = inputInt.nextInt();
                staff.buscarMedico(idAlterar);
                System.out.println("Esse é o médico buscado? 1.Sim 2.Não");
                int opcao = inputInt.nextInt();
                //Verificar se o médico existe
                if (opcao == 1) {
                    System.out.println("Qual dado você deseja alterar\n1.Nome 2.Especialidade 3.ID");
                    opcao = inputInt.nextInt();
                    //Alterar nome
                    if (opcao == 1) {
                        System.out.println("Digite o novo nome do médico:");
                        String nomeAlterar = inputString.nextLine();//Divida técnica(Aparecendo mensagem desnecessárias)
                        Medico medicoAlterar = new Medico(nomeAlterar, staff.buscarMedico(idAlterar).getEspecialidade(), staff.buscarMedico(idAlterar).getId());
                        staff.alterarMedico(medicoAlterar);
                        
                    }
                } else if (opcao == 2) {
                    
                } else {
                    System.out.println("Opção inválida, tente novamente!\n\n");
                    mostrarMedicos();
                    
                }


                mostrarMedicos();
                break;
            //Remover Médico
            case 3:
                System.out.println("\t\t*Remover Médico selecionado*\n");
                System.out.println("\nDigite o ID do médico que deseja remover:");
                int idRemover = inputInt.nextInt();
                Medico medicoRemover = staff.buscarMedico(idRemover);
                staff.removerMedico(medicoRemover);
                break;
            //Pesquisar Médico
            case 4:
            System.out.println("\t\t*Pesquisar Médico selecionado*\n");
            System.out.println("\nDigite o ID do médico que deseja pesquisar:");
            int idPesquisar = inputInt.nextInt();
            Medico medicoPesquisar = staff.buscarMedico(idPesquisar);
            staff.exibirMedico(medicoPesquisar);    
            default:
            System.out.println("\nOpção inválida, tente novamente!");
                break;
        }
    }



    public void mostrarPacientes() {
        System.out.println("\t\t*Menu Pacientes selecionado*");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    }

    public void mostrarConsultas() {
        System.out.println("\t\t*Menu Agendamentos selecionado*\n");
        System.out.println("\n1.Agendar 2.Cancelar 3.Realizar consulta 4.Listar agendamentos 5.voltar");
    }

    public void mostrarRelatorio() {
        System.out.println("\t\t*Menu Relatórios selecionado*\n");
        System.err.println("1.Consultas de um médico 2.Consultas de um paciente 3.voltar");
    }
}

  