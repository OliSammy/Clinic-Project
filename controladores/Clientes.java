package controladores;
import java.util.ArrayList;
import entidades.Paciente;
import Sql.SqlCliente;

public class Clientes {
    private ArrayList<Paciente> clientes = new ArrayList<Paciente>();
    private SqlCliente sql= new SqlCliente();

    public void adicionarCliente(String nome, String idade, String genero, long cpf) throws Exception {
        if (sql.verificarCliente(cpf)){
            System.out.println("Paciente já adicionado");
        }
        else{
            sql.adicionarCliente(cpf, nome, genero, idade);
            System.out.println("Cliente adicionado com sucesso");
        }
    }

    public void removerCliente(Paciente cliente) {
        this.clientes.remove(cliente);
    }
    public void buscarCliente(long cpf) {
        for (Paciente cliente : this.clientes) {
            if (cliente.getCpf() == cpf) {
                cliente.exibirPaciente();
                return;
            }
        }
    }
    public void alterarCliente(Paciente cliente) {
        for (Paciente clienteCadastrado : this.clientes) {
            if (clienteCadastrado.getCpf() == cliente.getCpf()) {
                clienteCadastrado.setNome(cliente.getNome());
                clienteCadastrado.setIdade(cliente.getIdade());
                clienteCadastrado.setGenero(cliente.getGenero());
                return;
            }
        }
    }

    public Paciente selecionarCliente(long cpf) {
        for (Paciente cliente : this.clientes) {
            if (cliente.getCpf() == cpf) {
                return cliente;
            }
        }
        return null;
    }
    public void listarCliente(){
        for (Paciente clienteCadastrado : this.clientes) {
            System.out.println(clienteCadastrado);
        }
    }
}