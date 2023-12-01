package controladores;

import Sql.SqlAgendamento;;

public class Agenda {
    private SqlAgendamento sql = new SqlAgendamento();

    public void adicionarAgendamento(int consultaRealizada, String data, String horario, int idMedico, long cpf)
            throws Exception {
        if (sql.verificarAgendamento(data, horario)) {
            System.out.println("Horario e data indisponíveis");
        } else {
            sql.agendarConsulta(consultaRealizada, data, horario, idMedico, cpf);
            System.out.println("Consulta Marcada!");
        }
    }

    public void removerAgendamento(String data, String horario) throws Exception {
        // if (sql.verificarAgendamento(data, horario)) {
        // sql.cancelarAgendamento(data, horario);
        // System.out.println("\n\nConsulta Cancelada!\n\n");
        // } else {
        // System.out.println("\n\nConsulta Não Encontrada!\n\n");
        // }
        sql.cancelarAgendamento(data, horario);
    }

    public boolean selecionarAgendamento(String data, String horario) throws Exception {
        if (sql.verificarAgendamento(data, horario)) {
            return true;
        } else {
            return false;
        }
    }

    // public void buscarAgendamento() {

    // }

    // public void verificarAgendamento() {

    // }

    // public void alterarAgendamento() {

    // }
}
