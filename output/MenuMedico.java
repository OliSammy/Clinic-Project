package output;
import java.util.Scanner;
import controladores.Staff;
import entidades.Medico;
public class MenuMedico {
    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Staff staff = new Staff();
    

    public MenuMedico() {

    }

    public void mostrarMedicos() {
        while (true) {          
        
        System.out.println("\t\t\n*Menu Médicos selecionado*");
        System.out.println("\nSelecione uma opção abaixo:");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar\n\n");
        opcao = inputInt.nextInt();
        if(opcao==6){
            break;
        }
        switch (opcao) {
            //Cadastrar Médico
            case 1:
                System.out.println("\t\t\n*Cadastrar Médico selecionado*");
                System.out.println("\nDigite o nome do médico:");
                String nome = inputString.nextLine();
                System.out.println("\nDigite a especialidade do médico:");
                String especialidade = inputString.nextLine();
                System.out.println("\nDigite o ID do médico:");
                int id = inputInt.nextInt();
                Medico medicoNovo = new Medico(nome, especialidade, id);
                if(staff.verificarMedico(medicoNovo)){
                    System.out.println("\nJá existe um médico com esse ID, voltando ao menu...");
                    break;
                }
                staff.adicionarMedico(medicoNovo);
                System.out.println("\nMédico cadastrado com sucesso!");
                break;
            //Alterar Médico
            case 2:
            System.out.println("\t\t\n*Alterar Médico selecionado*");
            System.out.println("\nDigite o ID do médico que deseja alterar:");
            int idAlterar = inputInt.nextInt();
            Medico medico = staff.selecionarMedico(idAlterar);
            if (medico == null) {
                System.out.println("\nMédico não encontrado, voltando ao menu...");
                return;
            } 
                System.out.println("\nEsse é o médico selecionado:\n"+medico+ "\n Deseja alterar?\n Sim/Nao");
                String Escolha = inputString.nextLine();            
                if (Escolha.equalsIgnoreCase("Nao")){
                    System.out.println("\nVoltando ao menu...");
                    break;     
                   } 
                    System.out.println("\nQual dado você deseja alterar\n1.Nome 2.Especialidade 3.ID");
                    opcao = inputInt.nextInt();
                    //Alterar nome
                while (opcao != 1 && opcao != 2 && opcao != 3) {
                        System.out.println("\nOpção inválida, tente novamente!");
                        opcao = inputInt.nextInt();
                        
                }
                if (opcao == 1) {
                        System.out.println("\nDigite o novo nome do médico:");
                        String nomeAlterar = inputString.nextLine(); 
                        Medico medicoAlterar = new Medico(nomeAlterar, medico.getEspecialidade(), medico.getId());
                        staff.alterarMedico(medicoAlterar);
                        System.out.println( "\nMédico alterado com sucesso!");
                        break;
                }if(opcao==2) {
                    System.out.println("\nDigite a nova especialidade do médico:");
                    String especialidadeAlterar = inputString.nextLine();
                    Medico medicoAlterar = new Medico(medico.getNome(), especialidadeAlterar, medico.getId());
                    staff.alterarMedico(medicoAlterar);
                    System.out.println("\nMédico alterado com sucesso!");
                    break;
                }if(opcao==3) {
                    System.out.println("\nDigite o novo ID do médico:");
                    int idAlterar2 = inputInt.nextInt();
                    Medico medicoAlterar = new Medico(medico.getNome(), medico.getEspecialidade(), idAlterar2);
                    staff.alterarMedico(medicoAlterar);
                    System.out.println("\nMédico alterado com sucesso!");
                    break;
                }
               
            //Remover Médico
            case 3:
                System.out.println("\t\t*Remover Médico selecionado*\n");
                System.out.println("\nDigite o ID do médico que deseja remover:");
                int idRemover = inputInt.nextInt();
                Medico medicoRemover = staff.selecionarMedico(idRemover);
                if (medicoRemover == null) {
                    System.out.println("\nMédico não encontrado, voltando ao menu...");
                    return;
                }
                System.out.println("\nEsse é o médico selecionado:\n"+medicoRemover+ "\n Deseja remover?\n Sim/Nao");
                String Escolha2 = inputString.nextLine();
                if (Escolha2.equalsIgnoreCase("Nao")){
                    System.out.println("\nVoltando ao menu...");
                    return;
                }
                staff.removerMedico(medicoRemover);
                System.out.println("\nMédico removido com sucesso!");
                break;
        
            //Pesquisar Médico
            case 4:
            System.out.println("\t\t*Pesquisar Médico selecionado*\n");
            System.out.println("\nDigite o ID do médico que deseja pesquisar:");
            int idPesquisar = inputInt.nextInt();
            Medico medicoPesquisar = staff.selecionarMedico(idPesquisar);
             if (medicoPesquisar == null) {
                    System.out.println("\nMédico não encontrado, voltando ao menu...");
                    return;
                }
            staff.exibirMedico(medicoPesquisar);    
                break;
            default:
            System.out.println("\nOpção inválida, tente novamente!");
                break;

            //Listar Médicos
            case 5:
                System.out.println("\t\t*Listar Médicos selecionado*\n");
                System.out.println("\nEsses são os médicos cadastrados:");
                staff.listarMedicos();
            }
        }
    }
}