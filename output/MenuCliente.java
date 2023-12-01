package output;

import java.util.Scanner;
import controladores.Clientes;

public class MenuCliente {
    int opcao;
    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);
    Scanner inputLong = new Scanner(System.in);
    Clientes cliente = new Clientes();

    public MenuCliente() {

    }

    public void mostrarPacientes() {
        while (true) {
            System.out.println("\t\t*Menu Pacientes selecionado*");
            System.out.println("\nSelecione uma opção abaixo:");
            System.out.println("\n1.Cadastrar 2.Alterar 3.Remover 4.Pesquisar 5.Listar 6.voltar");
            opcao = inputInt.nextInt();
            if (opcao == 6) {
                break;
            }
            switch (opcao) {
                // Cadastrar Paciente
                case 1:
                    System.out.println("\t\t\n*Cadastrar Paciente selecionado*");
                    System.out.println("\nDigite o nome do paciente:");
                    String nome = inputString.nextLine();
                    System.out.println("\nDigite a idade do paciente:");
                    String idade = inputString.nextLine();
                    System.out.println("\nDigite o gênero do paciente:");
                    String genero = inputString.nextLine();
                    System.out.println("\nDigite o CPF do paciente:");
                    long cpf = inputLong.nextLong();
                    try {
                        cliente.adicionarCliente(nome, idade, genero, cpf);
                        System.out.println("\nPaciente cadastrado com sucesso!");
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar paciente: " + e.getMessage());
                    }
                    break;
                // Alterar Paciente
                case 2:
                    System.out.println("\t\t*Alterar Paciente selecionado*\n");
                    System.out.println("\nDigite o CPF do paciente que deseja alterar:");
                    long cpfAlterar = inputInt.nextLong();
                    try {
                        if (cliente.selecionarCliente(cpfAlterar)) {
                            System.out.println("\nDeseja altera-lo? 1.Sim 2.Não");
                            int opcaoAlterar = inputInt.nextInt();
                            if (opcaoAlterar == 1) {
                                System.out.println("\nDigite o novo nome do paciente:");
                                String nomeAlterar = inputString.nextLine();
                                System.out.println("\nDigite a nova idade do paciente:");
                                String idadeAlterar = inputString.nextLine();
                                System.out.println("\nDigite o novo gênero do paciente:");
                                String generoAlterar = inputString.nextLine();
                                try {
                                    cliente.alterarCliente(cpfAlterar, nomeAlterar, generoAlterar, idadeAlterar);
                                } catch (Exception e) {
                                    System.out.println("Erro ao alterar paciente: " + e.getMessage());
                                }
                            } else {
                                System.out.println("\nVoltando ao menu...");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao selecionar cliente: " + e.getMessage());
                    }
                    break;

                // Remover Paciente
                case 3:
                    System.out.println("\t\t*Remover Paciente selecionado*\n");
                    System.out.println("\nDigite o CPF do paciente que deseja remover:");
                    long cpfRemover = inputInt.nextLong();
                    try {
                        if (cliente.selecionarCliente(cpfRemover)) {
                            System.out.println("\nDeseja remover? 1.Sim 2.Não");
                            int opcaoRemover = inputInt.nextInt();
                            if (opcaoRemover == 1) {
                                try {
                                    cliente.removerCliente(cpfRemover);
                                    System.out.println("\nPaciente removido com sucesso com sucesso!");
                                } catch (Exception e) {
                                    System.out.println("Erro ao remover paciente: " + e.getMessage());
                                }
                            } else {
                                System.out.println("\nNenhum dado removido, voltando ao menu...");
                                break;
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao selecionar paciente: " + e.getMessage());
                    }
                    break;
                // Pesquisar Paciente
                case 4:
                    System.out.println("\t\t*Pesquisar Paciente selecionado*\n");
                    System.out.println("\nDigite o CPF do paciente que deseja pesquisar:");
                    long cpfPesquisar = inputInt.nextLong();
                    try {
                        if (cliente.selecionarCliente(cpfPesquisar)) {
                            break;
                        } else {
                            System.out.println("\nNenhum dado encontrado, voltando ao menu...");
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao pesquisar paciente: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("\t\t*Listar Pacientes selecionado*\n");
                    try {
                        cliente.listarClientes();
                    } catch (Exception e) {
                        System.out.println("Erro ao listar pacientes: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("\nOpção inválida, voltando ao menu...");
                    break;
            }

        }
    }
}