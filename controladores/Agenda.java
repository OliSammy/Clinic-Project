package controladores;
import java.util.ArrayList;
import entidades.Agendamento;
public class Agenda {
    public ArrayList<Agendamento> agenda = new ArrayList<Agendamento>();
    public void adicionarAgendamento(Agendamento agendamento) {
        verificarAgendamento(agendamento);
        this.agenda.add(agendamento);
    }
    public void removerAgendamento(Agendamento agendamento) {
        this.agenda.remove(agendamento);
    }
    public void buscarAgendamento(int id) {
        for (Agendamento agendamento : this.agenda) {
            if (agendamento.getId() == id) {
                agendamento.exibirAgenda();
                return;
            }
        }
        System.out.println("Agendamento não encontrado!");
    }
    public void verificarAgendamento(Agendamento agendamento) {
        for (Agendamento agendamentoCadastrado : this.agenda) {
            if (agendamentoCadastrado.getId() == agendamento.getId()) {
                System.out.println("Agendamento já cadastrado!");
                return;
            }
        }
        System.out.println("Agendamento não cadastrado!");
    }   
    public void alterarAgendamento(Agendamento agendamento){
        for (Agendamento agendamentoCadastrado : this.agenda) {
            if (agendamentoCadastrado.getId() == agendamento.getId()) {
                agendamentoCadastrado.setPaciente(agendamento.getPaciente());
                agendamentoCadastrado.setMedico(agendamento.getMedico());
                agendamentoCadastrado.setData(agendamento.getData());
                agendamentoCadastrado.setHora(agendamento.getHora());
                agendamentoCadastrado.setEspecialidade(agendamento.getEspecialidade());
                System.out.println("Agendamento alterado com sucesso!");
                return;
            }
        }
        System.out.println("Agendamento não encontrado!");
    }
}
