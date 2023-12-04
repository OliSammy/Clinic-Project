package controladores;

import Sql.SqlAgendamento;
import Sql.SqlMedico;
import Sql.SqlCliente;
public class Agenda {
    private SqlAgendamento sql = new SqlAgendamento();
    private SqlMedico sqlMedico = new SqlMedico();
    private SqlCliente sqlCliente = new SqlCliente();

    public void adicionarAgendamento(int consultaRealizada, String data, String horario, int idMedico, long cpf) throws Exception {
        String tipoConsulta = sql.verificarAgendamentoadd(idMedico, cpf, data, horario);
        
        if (tipoConsulta != null) {
            if (tipoConsulta.equals("medico")) {
                System.out.println("ERRO:Consulta existente para o médico nesse horário.");
            } else if (tipoConsulta.equals("paciente")) {
                System.out.println("ERRO:Consulta existente para o paciente nesse horário.");
            }
        } else {
            sql.agendarConsulta(consultaRealizada, data, horario, idMedico, cpf);
            System.out.println("Consulta agendada com sucesso");
        }
    }
    public void realizarConsulta(int Id_consulta,  String tratamento,String descricao) throws Exception {
        if (Id_consulta == -1) {
            System.out.println("ERRO:Consulta não realizada.");
            return;
        }else{         
        
        sql.realizarConsulta(Id_consulta, tratamento, descricao);
        System.out.println("Consulta realizada com sucesso");
        return;
    }
}
    public void alterarAgendamento(int idMedAlterar, String dataAlterae, String horarioAlterar,String datanova,String horarionovo) throws Exception {
     
            sql.alterarAgendamento(idMedAlterar, dataAlterae, horarioAlterar,datanova,horarionovo);
            System.out.println("Consulta alterada com sucesso");
        
    } 
    public void removerAgendamento(int idMed, String data, String horario) throws Exception {

        sql.cancelarAgendamento(idMed, data, horario);
        System.out.println("Consulta cancelada com sucesso");
    }

    public boolean selecionarAgendamento(int idMed, String data, String horario) throws Exception {
        if (sql.selecionarAgendamento(idMed, data, horario)) {
            return true;
        } else {
            return false;
        }
    }

    public String obterHorario(int horario) {
        switch (horario) {
            case 1:
                return "14h";
            case 2:
                return "15h";
            case 3:
                return "16h";
            case 4:
                return "17h";
            default:
                throw new IllegalArgumentException("Opção inválida");
        }
    }
    public void buscarAgendamentoMedico(int idMed) throws Exception {
        sql.buscarAgendamentoIdmed(idMed);
    }
    public void buscarConsultasRealizadasPaciente(long cpf) throws Exception {
        sql.buscarConsultasRealizadasPaciente(cpf);
    }
    public void buscarConsultasRealizadasMedico(int Idmed) throws Exception {
        sql.buscarConsultasRealizadasMedico(Idmed);
    }
    public boolean verificaridMedico(int idMed) throws Exception {
        if (sqlMedico.verificaridMedico(idMed)) { 
            return true;
        } else
            return false;
        }
    public boolean verificarAgendamento(int idMed, String data, String horario) throws Exception {
        if (sql.verificarAgendamento(idMed, data, horario)) {
            return true;
        } else
            return false;
    }
    public void buscarAgendamentoCpf(long cpf) throws Exception {
        sql.buscarAgendamentoCpf(cpf);
    }

    public boolean  verificarCpfCliente(long cpf) throws Exception {
        if (sqlCliente.verificarClienteExiste(cpf)) {
            return true;
        } else
            return false;
    }
    public int obterIdConsulta(int idMed, String data, String horario) throws Exception {
        return sql.obterIdConsulta(idMed, data, horario);
    }
}



