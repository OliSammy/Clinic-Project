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
    public void buscarCliente(int id) {
        for (Paciente cliente : this.clientes) {
            if (cliente.getId() == id) {
                cliente.exibirPaciente();
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
    public void verificarCliente(Paciente cliente) {
        for (Paciente clienteCadastrado : this.clientes) {
            if (clienteCadastrado.getId()== cliente.getId()) {
                System.out.println("Cliente já cadastrado!");
                return;
            }
        }
    }
    public void listarCliente(Paciente cliente){
        for (Paciente clienteCadastrado : this.clientes) {
            clienteCadastrado.exibirPaciente();
        }
    }
}
