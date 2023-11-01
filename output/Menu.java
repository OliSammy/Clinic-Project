package output;
import java.util.Scanner;
import controladores.*;
import entidades.Medico;
public class Menu {
    int opcao;
    Scanner input = new Scanner(System.in);
    Staff staff = new Staff();

    public void Principal() {
        System.out.println("\nBem-Vindo à Clinica dos Viados\n");
        System.out.println("Para prosseguimos com o programa selecione uma opção abaixo:");
        System.out.println("\n1.Médicos 2.Paciente 3.Agendamentos 4.Relatórios 5.sair\n\n");
        opcao = input.nextInt();
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
        
    public void retornaraoMenuMedico() {
        System.out.println("\t\t*Você retornou ao menu dos Médicos*\n");
        System.out.println("Selecione uma opção abaixo:\n");
        System.out.println("1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar");
    
    }
    

    public void mostrarMedicos() {
        System.out.println("\t\t*Menu Médicos selecionado*\n");
        System.out.println("Selecione uma opção abaixo:");
        System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Perquisar 5.Listar 6.voltar\n\n");
        opcao = input.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("\t\t*Cadastrar Médico selecionado*\n");
                System.out.println("\nDigite o nome do médico:");
                String nome = input.next();
                System.out.println("\nDigite a especialidade do médico:");
                String especialidade = input.next();
                System.out.println("\nDigite o ID do médico:");
                int id = input.nextInt();
                Medico medicoNovo = new Medico(nome, especialidade, id);
                staff.adicionarMedico(medicoNovo);
                break;
        
            default:
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

  