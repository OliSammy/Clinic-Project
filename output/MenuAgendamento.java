package output;

import java.util.Scanner;

import controladores.Agenda;


public class MenuAgendamento {

    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Scanner inputLong = new Scanner(System.in);
    Agenda agenda = new Agenda();

    public void mostrarAgendamentos() throws Exception {
        while (true) {
            System.out.println("\t\t\n*Menu de Agendamentos selecionado*");
            System.out.println("\nSelecione uma opção abaixo:");
            System.out.println(
                    "\n1.Agendar 2.Realizar Consulta 3.Cancelar 4.Buscar Consulta(Medico) 5.Buscar Consulta(Paciente) 6.voltar\n\n");
            opcao = inputInt.nextInt();
            if (opcao == 6) {
                break;
            }
            switch (opcao) {
                case 1:
                    System.out.println("\t\t\n*Agendar Consulta*");
                    System.out.println("\nDigite o ID do Medico com quem você quer se consultar:");
                    int idMed;
                    try {
                        idMed = inputInt.nextInt();
                        if (!agenda.verificaridMedico(idMed)) {
                            System.out.println("\nErro: Médico não encontrado");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;

                    }
                    System.out.println("\nDigite seu CPF:(somente números)");
                    long cpf;
                    try {
                        cpf = inputLong.nextLong();
                        if (!agenda.verificarCpfCliente(cpf)) {
                            System.out.println("\nErro: CPF não encontrado");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;
                    }
                    System.out.println("\nDiga a data da consulta que deseja marcar: (no formato dd/mm//yyyy)");
                    String dataString = inputString.nextLine();
                    System.out.println("\nDiga o horario da consulta que deseja marcar:");
                    System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                    int opcaoHorario = inputInt.nextInt();
                    String horario = (String) agenda.obterHorario(opcaoHorario);
                    try {
                        agenda.adicionarAgendamento(0, dataString, horario, idMed, cpf);
                    } catch (Exception e) {
                        System.out.println("Erro ao marcar consulta: " + e.getMessage());
                    }
                    break;

                case 2:
                    break;
                case 3:
                    System.out.println("\t\t\n*Cancelar Consulta*");
                    System.out.println("\nDigite o ID do Medico com quem você quer se cancelar:");
                    int idMedCancel;
                    try {
                        idMedCancel = inputInt.nextInt();
                        if (!agenda.verificaridMedico(idMedCancel)) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;
                    }

                    System.out.println("\nDiga a data da consulta que deseja cancelar: (no formato dd/mm//yyyy)");
                    String dataStringCancel = inputString.nextLine();
                    System.out.println("\nDiga o horario da consulta que deseja cancelar:");
                    System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                    int opcaoHorarioCancel = inputInt.nextInt();
                    String horarioCancel = (String) agenda.obterHorario(opcaoHorarioCancel);
                    try {
                        if (agenda.selecionarAgendamento(idMedCancel, dataStringCancel, horarioCancel)) {
                            System.out.println("\nDeseja remover? 1.Sim 2.Não");
                            int opcaoRemover = inputInt.nextInt();
                            if (opcaoRemover == 1) {
                                try {
                                    agenda.removerAgendamento(idMedCancel, dataStringCancel, horarioCancel);
                                } catch (Exception e) {
                                    System.out.println("Erro ao remover agendamento: " + e.getMessage());
                                }
                            } else {
                                System.out.println("\nNenhum dado removido, voltando ao menu...");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao selecionar agendamento: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("\t\t\n*Buscar Consulta(Medico)*");
                    System.out.println("\nDigite o ID do Medico com quem você quer buscar:");
                    int idMedBusca;
                    try {
                        idMedBusca = inputInt.nextInt();
                        if (agenda.verificaridMedico(idMedBusca)) {
                            System.out.println("\nEsse é o medico que você procura:");
                            System.out.println("\n1.sim 2.não\n");
                            int opcaoMedico = inputInt.nextInt();
                            if (opcaoMedico == 1) {
                                System.out.println(
                                        "\nDeseja ver os agendamentos ou consultas realizadas? 1.Agendamentos 2.Consultas realizadas\n");
                                int opcaoAgendamento = inputInt.nextInt();
                                if (opcaoAgendamento == 1) {
                                    agenda.buscarAgendamentoMedico(idMedBusca);
                                    break;
                                } else if (opcaoAgendamento == 2) {
                                    agenda.buscarConsultasRealizadasMedico(idMedBusca);
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;

                    }
                    break;
                    case 5:
                    System.out.println("\t\t\n*buscar Consulta(Paciente)*");
                    System.out.println("\nDigite o CPF de quem você quer buscar:");
                    long cpfBuscar;
                    try {
                        cpfBuscar = inputLong.nextLong();
                        if (agenda.verificarCpfCliente(cpfBuscar)) {
                            System.out.println("\nEsse é o paciente que você procura:");
                            System.out.println("\n1.sim 2.não\n");
                            int opcaoPaciente = inputInt.nextInt();
                            if (opcaoPaciente == 1) {
                                System.out.println(
                                        "\nDeseja ver os agendamentos ou consultas realizadas? 1.Agendamentos 2.Consultas realizadas\n");
                                int opcaoAgendamento = inputInt.nextInt();
                                if (opcaoAgendamento == 1) {
                                    agenda.buscarAgendamentoCpf(cpfBuscar);
                                    break;
                                } else if (opcaoAgendamento == 2) {
                                    agenda.buscarConsultasRealizadasPaciente(cpfBuscar);
                                    break;
                                }
                            }                        
                        } else {
                             System.out.println("\nErro: CPF não encontrado");
                             break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;
                    }

                default:
                    System.out.println("\nOpção inválida, voltando ao menu...");
                    break;
            }
        }
    }
}
