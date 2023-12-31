package output;

import java.util.Scanner;

public class MenuPrincipal {
    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    MenuMedico menuMedico = new MenuMedico();
    MenuCliente menuCliente = new MenuCliente();
    MenuAgendamento menuAgendamento = new MenuAgendamento();

    public MenuPrincipal() {
        menuMedico = new MenuMedico();
    }

    public void Inicio() {
            while (true) {
            System.out.println("\nBem-Vindo à Clinica dos Felas!");
            System.out.println("\nPara prosseguimos com o programa selecione uma opção abaixo:");
            System.out.println("\n1.Médicos 2.Paciente 3.Agendamentos 4.sair\n\n");
            try {
                try {
                    opcao = inputInt.nextInt();
                } catch (Exception e) {
                    System.out.println("\nOpção inválida, tente novamente!");
                    inputInt.nextLine(); // Limpa o buffer do scanner
                    continue;
                }
                if (opcao == 4) {
                    System.out.println("\nObrigado por usar o programa!");
                    break;
                }
                switch (opcao) {
                    case 1:
                        menuMedico.mostrarMedicos();
                        break;
                    case 2:
                        menuCliente.mostrarPacientes();
                        break;
                    case 3:
                        menuAgendamento.mostrarAgendamentos();
                        break;
                    default:
                        System.out.println("\nOpção inválida, tente novamente!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("\nOpção inválida, tente novamente!");
                inputInt.nextLine(); // Limpa o buffer do scanner
            }
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
