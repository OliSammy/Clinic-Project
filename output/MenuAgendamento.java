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
                    "\n1.Agendar 2.Alterar Agendamento 3.Realizar Consulta 4.Cancelar 5.Buscar Consulta(Medico) 6.Buscar Consulta(Paciente) 7.voltar\n\n");
            opcao = inputInt.nextInt();
            if (opcao == 7) {
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
                    System.out.println("\t\t\n*Alterar Agendamento*");
                    System.out.println("\nDigite o seu CPF:(somente números)");
                    long cpfAlterar;
                    try {
                        cpfAlterar = inputLong.nextLong();
                        if (!agenda.verificarCpfCliente(cpfAlterar)) {
                            System.out.println("\nErro: CPF não encontrado");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;
                    }
                    System.out.println("\nDigite o ID do Medico com quem você quer se alterar:");
                    int idMedAlterar;
                    try {
                        idMedAlterar = inputInt.nextInt();
                        if (!agenda.verificaridMedico(idMedAlterar)) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;
                    }
                    System.out.println("\nDiga a data da consulta que deseja alterar: (no formato dd/mm//yyyy)");
                    String dataStringAlterar = inputString.nextLine();
                    System.out.println("\nDiga o horario da consulta que deseja alterar:");
                    System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                    int opcaoHorarioAlterar = inputInt.nextInt();
                    String horarioAlterar = (String) agenda.obterHorario(opcaoHorarioAlterar);
                    try {
                        if (agenda.selecionarAgendamento(idMedAlterar, dataStringAlterar, horarioAlterar)) {
                            System.out.println("\nDeseja alterar? 1.Sim 2.Não");
                            int opcaoAlterar = inputInt.nextInt();
                            if (opcaoAlterar == 1) {
                                System.out.println("\nDigite a nova data da consulta que deseja alterar: (no formato dd/mm//yyyy)");
                                String dataStringAlterar2 = inputString.nextLine();
                                System.out.println("\nDigite o novo horario da consulta que deseja alterar:");
                                System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                                int opcaoHorarioNovo = inputInt.nextInt();
                                String horarioNovo = (String) agenda.obterHorario(opcaoHorarioNovo);
                                try {
                                    if(agenda.verificarAgendamento(idMedAlterar, dataStringAlterar2, horarioNovo)){
                                        System.out.println("\nErro: Agendamento já existente");
                                        break;
                                    }
                                    agenda.alterarAgendamento(idMedAlterar, dataStringAlterar, horarioAlterar,
                                            dataStringAlterar2, horarioNovo);
                                } catch (Exception e) {
                                    System.out.println("Erro ao alterar agendamento: " + e.getMessage());
                                }
                            } else {
                                System.out.println("\nNenhum dado alterado, voltando ao menu...");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao selecionar agendamento: " + e.getMessage());
                    }
                   
                break;
                case 3:
                    System.out.println("\t\t\n*Realizar Consulta*");
                    System.out.println("\nDigite o ID do Medico com quem você vai realizar a consulta:");
                    int idMedRealizar;
                    try {
                        idMedRealizar = inputInt.nextInt();
                        if (!agenda.verificaridMedico(idMedRealizar)) {
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("\nErro você deve digitar um número inteiro: ");
                        inputInt.nextLine(); // Limpa o buffer do scanner
                        break;
                    }
                    System.out.println("\nDiga a data da consulta que deseja realizar: (no formato dd/mm//yyyy)");
                    String dataStringRealizar = inputString.nextLine();
                    System.out.println("\nDiga o horario da consulta que deseja realizar:");
                    System.out.println("\n1.14h 2.15h 3.16h 4.17h\n\n");
                    int opcaoHorarioRealizar = inputInt.nextInt();
                    String horarioRealizar = (String) agenda.obterHorario(opcaoHorarioRealizar);
                    if (!agenda.verificarAgendamento(idMedRealizar, dataStringRealizar, horarioRealizar)) {
                        System.out.println("\nErro: Agendamento não encontrado");
                        break;
                    }
                    try {
                        if (agenda.selecionarAgendamento(idMedRealizar, dataStringRealizar, horarioRealizar)) {
                            System.out.println("\nDeseja realizar? 1.Sim 2.Não");
                            int opcaoRealizar = inputInt.nextInt();
                            if (opcaoRealizar == 1) {
                                int Id_consulta=  (agenda.obterIdConsulta(idMedRealizar, dataStringRealizar, horarioRealizar));
                                System.out.println("\nDigite o remédio(Se houver):");
                                String tratamento = inputString.nextLine();
                                System.out.println("\nDigite a descrição da consulta que deseja realizar:");
                                String descricao = inputString.nextLine();
                                try {
                                    agenda.realizarConsulta(Id_consulta, tratamento, descricao);
                                } catch (Exception e) {
                                    System.out.println("Erro ao realizar consulta: " + e.getMessage());
                                }
                            } else {
                                System.out.println("\nNenhum dado alterado, voltando ao menu...");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao selecionar agendamento: " + e.getMessage());
                    }
                    break;           
                case 4:
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

                case 5:
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
                    case 6:
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
