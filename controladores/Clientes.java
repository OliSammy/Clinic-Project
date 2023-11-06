package controladores;
import java.util.ArrayList;
import entidades.Paciente;
public class Clientes {
    private ArrayList<Paciente> clientes = new ArrayList<Paciente>();

    public void adicionarCliente(Paciente cliente) {
        verificarCliente(cliente);
        this.clientes.add(cliente);
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
    public boolean verificarCliente(Paciente cliente) {
        for (Paciente clienteCadastrado : this.clientes) {
            if (clienteCadastrado.getCpf()== cliente.getCpf()) {
                System.out.println("Cliente já cadastrado!");
                return true;
            }
        }
        return false;
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
