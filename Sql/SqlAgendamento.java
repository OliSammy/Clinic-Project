package Sql;

import java.sql.*;

public class SqlAgendamento {
    Connection connection = null;
    String url = "jdbc:sqlite:clinica.db";

    public void agendarConsulta(int consultaRealizada, String data, String horario, int idMedico, long cpf)
            throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("INSERT INTO Consulta (Realizada, Data, Horario, Id_med, CPF) VALUES (?,?,?,?,?)");
        comandossql.setInt(1, consultaRealizada);
        comandossql.setString(2, data);
        comandossql.setString(3, horario);
        comandossql.setInt(4, idMedico);
        comandossql.setLong(5, cpf);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public void cancelarAgendamento(int idMed, String data, String horario) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("DELETE FROM Consulta WHERE Data = ? AND Horario = ? AND Id_med = ?");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        comandossql.setInt(3, idMed);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }
    public void alterarAgendamento(int idMed, String data, String horario, String dataNova, String horarioNovo) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("UPDATE Consulta SET Data = ?, Horario = ? WHERE Data = ? AND Horario = ? AND Id_med = ?");
        comandossql.setString(1, dataNova);
        comandossql.setString(2, horarioNovo);
        comandossql.setString(3, data);
        comandossql.setString(4, horario);
        comandossql.setInt(5, idMed);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }   

    public String verificarAgendamentoadd(int idMed, long CPF, String data, String horario) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement(
                "SELECT * FROM Consulta WHERE Data = ? AND Horario = ? AND Realizada = 0 AND CPF = ? OR Id_med = ?");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        comandossql.setLong(3, CPF);
        comandossql.setInt(4, idMed);

        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            connection.close();
            comandossql.close();
            return null; // Nenhuma consulta encontrada para esse horário
        } else {
            // Consulta encontrada, verificar se é do médico ou do paciente
            resultado.next(); // Move para a primeira linha do resultado

            boolean consultaDoMedico = resultado.getInt("Id_med") == idMed;
            connection.close();
            comandossql.close();

            if (consultaDoMedico) {
                return "medico";
            } else {
                return "paciente";
            }
        }
    }

    public boolean verificarAgendamento(int idMed, String data, String horario) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement(
                "SELECT * FROM Consulta WHERE Data = ? AND Horario = ? AND Realizada = 0 AND Id_med = ?");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        comandossql.setInt(3, idMed);

        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            connection.close();
            comandossql.close();
            return false; // Nenhuma consulta encontrada para esse horário
        } else {
            return true;
        }

    }

    public boolean selecionarAgendamento(int idMed, String data, String horario) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Consulta WHERE Data = ? AND Horario = ? AND Id_med = ? ");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        comandossql.setInt(3, idMed);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhuma consulta encontrada.");
            comandossql.close();
            connection.close();
            return false;
        } else {
            while (resultado.next()) {
                System.out.println("\nEsse é o agendamento buscado:");
                System.out.println(
                        "\nData: " + resultado.getString("Data") + "\nHorario: " + resultado.getString("Horario")
                                + "\nId_med: " + resultado.getInt("Id_med") + "\nCPF: " + resultado.getLong("CPF"));
            }

            comandossql.close();
            connection.close();
            return true;
        }
    }

    public void realizarConsulta(int consultaId, String descricao, String tratamento) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("UPDATE Consulta SET Realizada = 1 WHERE Id_consulta = ? AND Realizada = 0");
        comandossql.setInt(1, consultaId);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
        gerarRelatorio(consultaId, descricao, tratamento);
    }

    public int obterIdConsulta(int idMed, String data, String horario) throws SQLException {
        int consultaId = -1;
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Consulta WHERE Data = ? AND Horario = ? AND Id_med = ? ");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        comandossql.setInt(3, idMed);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            return consultaId;
        } else {
            consultaId = resultado.getInt("Id_consulta");
            comandossql.close();
            connection.close();
            return consultaId;

        }

    }

    public void gerarRelatorio(int consultaId, String descricao, String tratamento) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("INSERT INTO Relatorio (Id_consulta,Descricao, Tratamento) VALUES (?,?,?)");
        comandossql.setInt(1, consultaId);
        comandossql.setString(2, descricao);
        comandossql.setString(3, tratamento);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public void exibirRelatorio(int consultaId) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Relatorio WHERE Id_consulta = ?");
        comandossql.setInt(1, consultaId);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhum relatório encontrado.");
        } else {
            while (resultado.next()) {
                System.out.println("\nEsse é o relatório da consulta:");
                System.out.println(
                        "\nId_consulta: " + resultado.getInt("Id_consulta") + "\nDescrição: "
                                + resultado.getString("Descricao")
                                + "\nTratamento: " + resultado.getString("Tratamento"));
            }
        }
        comandossql.close();
        connection.close();
    }

    public void buscarAgendamentoCpf(long cpf) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Consulta WHERE CPF = ?");
        comandossql.setLong(1, cpf);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            while (resultado.next()) {
                System.out.println("\nEsse é o agendamento buscado:");
                System.out.println(
                        "\nData: " + resultado.getString("Data") + "\nHorario: " + resultado.getString("Horario")
                                + "\nId_med: " + resultado.getInt("Id_med") + "\nCPF: " + resultado.getLong("CPF"));
                exibirRelatorio(resultado.getInt("Id_consulta"));
            }
        }
        comandossql.close();
        connection.close();
    }

    public void buscarAgendamentoIdmed(int idMed) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Consulta WHERE Id_med = ? AND Realizada = 0");
        comandossql.setInt(1, idMed);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            while (resultado.next()) {
                System.out.println("\nEssas são as consultas não realizadas do médico buscado:");
                System.out.println(
                        " Data: " + resultado.getString("Data") + "\nHorario: " + resultado.getString("Horario")
                                + "\nId_med: " + resultado.getInt("Id_med") + "\nCPF: " + resultado.getLong("CPF"));
            }
        }
        comandossql.close();
        connection.close();
    }

    public void buscarConsultasRealizadasPaciente(long cpf) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Consulta WHERE CPF = ? AND Realizada = 1");
        comandossql.setLong(1, cpf);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            while (resultado.next()) {
                System.out.println("\nEssas são as consultas realizadas do paciente buscado:");
                System.out.println(
                        " Data: " + resultado.getString("Data") + "\nHorario: " + resultado.getString("Horario")
                                + "\nId_med: " + resultado.getInt("Id_med") + "\nCPF: " + resultado.getLong("CPF"));
                exibirRelatorio(resultado.getInt("Id_consulta"));
            }
        }
        comandossql.close();
        connection.close();
    }

    public void buscarConsultasRealizadasMedico(int idMed) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Consulta WHERE Id_med = ? AND Realizada = 1");
        comandossql.setInt(1, idMed);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            while (resultado.next()) {
                System.out.println("\nEssas são as consultas realizadas do médico buscado:");
                System.out.println(
                        " Data: " + resultado.getString("Data") + "\nHorario: " + resultado.getString("Horario")
                                + "\nId_med: " + resultado.getInt("Id_med") + "\nCPF: " + resultado.getLong("CPF"));
                exibirRelatorio(resultado.getInt("Id_consulta"));
            }
        }
        comandossql.close();
        connection.close();
    }

}