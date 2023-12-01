package output;

import java.util.Scanner;

import controladores.Agenda;

public class MenuAgendamento {

    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Scanner inputLong = new Scanner(System.in);
    Agenda agenda = new Agenda();

    public void mostrarAgendamentos() {
        while (true) {
            System.out.println("\t\t\n*Menu de Agendamentos selecionado*");
            System.out.println("\nSelecione uma opção abaixo:");
            System.out.println("\n1.Agendar 2.Realizar 3.Cancelar 4.Perquisar 5.Exibir 6.voltar\n\n");
            opcao = inputInt.nextInt();
            if (opcao == 6) {
                break;
            }
            switch (opcao) {
                case 1:
                    System.out.println("\t\t\n*Agendar Consulta*");
                    System.out.println("\nDigite o ID do Medico com quem você quer se consultar:");
                    int idMed = inputInt.nextInt();
                    System.out.println("\nDigite seu CPF:");
                    long cpf = inputLong.nextLong();
                    System.out.println("\nIndique o mes da sua consulta:");
                    int mes = inputInt.nextInt();
                    System.out.println("\nIndique o dia da sua consulta:");
                    int dia = inputInt.nextInt();
                    System.out.println("\nEscolha um horario disponível:");
                    System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                    int opcaoHorario = inputInt.nextInt();
                    String horario = new String();
                    switch (opcaoHorario) {
                        case 1:
                            horario = "14h";
                            break;

                        case 2:
                            horario = "15h";
                            break;

                        case 3:
                            horario = "16h";
                            break;

                        case 4:
                            horario = "17h";
                            break;

                        default:
                            System.out.println("\nOpção inválida...");
                            break;
                    }
                    try {
                        String data = dia + "/" + mes;
                        agenda.adicionarAgendamento(0, data, horario, idMed, cpf);
                        System.out.println("\nConsulta marcada!");
                    } catch (Exception e) {
                        System.out.println("Erro ao agendar Consulta: " + e.getMessage());
                    }
                    break;

                case 2:

                    break;

                case 3:
                    System.out.println("\t\t*Cancelar Consulta*\n");
                    System.out.println("\nDiga o mês da consulta que deseja cancelar:");
                    int mesCancelamento = inputInt.nextInt();
                    System.out.println("\nDiga o dia da consulta que deseja cancelar:");
                    int diaCancelamento = inputInt.nextInt();
                    String dataCancelamento = mesCancelamento + "/" + diaCancelamento;
                    System.out.println("\nDiga o horario da consulta que deseja cancelar:");
                    System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                    int opcaoHorarioCancelamento = inputInt.nextInt();
                    String horarioCancelamento = new String();
                    switch (opcaoHorarioCancelamento) {
                        case 1:
                            horarioCancelamento = "14h";
                            break;

                        case 2:
                            horarioCancelamento = "15h";
                            break;

                        case 3:
                            horarioCancelamento = "16h";
                            break;

                        case 4:
                            horarioCancelamento = "17h";
                            break;

                        default:
                            System.out.println("\nOpção inválida...");
                            break;
                    }
                    try {
                        if (agenda.selecionarAgendamento(dataCancelamento, horarioCancelamento)) {
                            System.out.println("\nDeseja cancelar? 1.Sim 2.Não");
                            int opcaoCancelar = inputInt.nextInt();
                            if (opcaoCancelar == 1) {
                                try {
                                    agenda.removerAgendamento(dataCancelamento, horarioCancelamento);
                                    System.out.println("\nConsulta Cancelado!");
                                } catch (Exception e) {
                                    System.out.println("Erro ao cancelar consulta: " + e.getMessage());
                                }
                            } else {
                                System.out.println("\nNenhuma Consulta foi cancelada");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao selecionar paciente: " + e.getMessage());
                    }
                    break;

                case 4:

                    break;

                case 5:

                    break;

                default:
                    System.out.println("\nOpção inválida, voltando ao menu...");
                    break;
            }
        }
    }
}
