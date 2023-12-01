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

    public void gerarRelatorio(String descricao, String tratamento) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("to be defined");
        // comandossql.setInt(1, consultaRealizada);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public void realizarConsulta(int consultaRealizada, String descricao, String tratamento) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("UPDATE Consulta SET Consulta.Realizada = 1 WHERE Consulta.Id_consulta = ?");
        comandossql.setInt(1, consultaRealizada);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();

        gerarRelatorio(descricao, tratamento);
    }

    public void cancelarAgendamento(String data, String horario) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("DELETE FROM Consulta WHERE Data = ? AND Horario = ?");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public boolean verificarAgendamento(String data, String horario) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("SELECT * FROM Consulta WHERE Data = ? AND Horario = ?");
        comandossql.setString(1, data);
        comandossql.setString(2, horario);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhum resultado encontrado.");
            return false;
        } else {
            while (resultado.next()) {
                System.out.println("\nConsulta Encontrada:");
                System.out.println("\nConsulta Numero: " + resultado.getInt("Id_consulta") + "\nRealizada? "
                        + (resultado.getInt("Realizada") == 0 ? "Não" : "Sim")
                        + "\nData: " + resultado.getString("Data") + "\nHorario: "
                        + resultado.getString("Horario") + "\nMedico: " + resultado.getInt("Id_med")
                        + "\nPaciente: " + resultado.getString("CPF"));
            }
        }

        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
        return true;
    }
}
