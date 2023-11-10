package output;
import java.util.Scanner;
import controladores.Staff;
public class MenuMedico {
    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Staff staff = new Staff();
    

    public MenuMedico() {

    }

    public void mostrarMedicos() throws Exception{
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
                staff.adicionarMedico(nome,especialidade);
                System.out.println("\nMédico cadastrado com sucesso!");
                break;
            //Alterar Médico
            case 2:
            System.out.println("\t\t\n*Alterar Médico selecionado*");
            System.out.println("\nDigite o ID do médico que deseja alterar:");
            int idAlterar = inputInt.nextInt();
            if(staff.selecionarMedico(idAlterar)){
            System.out.println("\nDeseja altera-lo? 1.Sim 2.Não");
            int opcaoAlterar = inputInt.nextInt();
            if(opcaoAlterar==1){
                System.out.println("\nDigite o novo nome do médico:");
                String nomeAlterar = inputString.nextLine();
                System.out.println("\nDigite a nova especialidade do médico:");
                String especialidadeAlterar = inputString.nextLine();
                staff.alterarMedico(nomeAlterar,especialidadeAlterar,idAlterar);
                System.out.println("\nMédico alterado com sucesso!");
                break;
            }
        }
            //Remover Médico
            case 3:
                System.out.println("\t\t*Remover Médico selecionado*\n");
                System.out.println("\nDigite o ID do médico que deseja remover:");
                int idRemover = inputInt.nextInt();
                if(staff.selecionarMedico(idRemover)){
                System.out.println("\nDeseja remove-lo? 1.Sim 2.Não");  
                int opcaoRemover = inputInt.nextInt(); 
                if(opcaoRemover==1){
                staff.removerMedico(idRemover);
                System.out.println("\nMédico removido com sucesso com sucesso!");
                break;
            }
            else{
                System.out.println("\nNenhum dado alterado, voltando ao menu...");
                break;
            }
        }

            //Pesquisar Médico
            case 4:
            System.out.println("\t\t*Pesquisar Médico selecionado*\n");
            System.out.println("\nDigite o ID do médico que deseja pesquisar:");
            int idPesquisar = inputInt.nextInt();
            if(staff.selecionarMedico(idPesquisar)){
                break;
            }
            else{
                System.out.println("\nMédico não encontrado!");
            }
                break;

            //Listar Médicos
            case 5:
                System.out.println("\t\t*Listar Médicos selecionado*\n");
                staff.listarMedicos();
                break;

                 default:
            System.out.println("\nOpção inválida, tente novamente!");
                break;

            }
        }
    }
}