package Sql;

import java.sql.*;

public class SqlMedico {
    Connection connection = null;
    String url = "jdbc:sqlite:clinica.db";

    public void adicionarMedico(String Nome, String Especialidade) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("INSERT INTO Medico (nome, especialidade) VALUES (?,?)");
        comandossql.setString(1, Nome);
        comandossql.setString(2, Especialidade);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public void removerMedico(int id) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("DELETE FROM Medico WHERE Id_med = ?");
        comandossql.setInt(1, id);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public boolean selecionarMedico(int id) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Medico WHERE Id_med = ?");
        comandossql.setInt(1, id);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhum resultado encontrado.");
            comandossql.close();
            connection.close();
            return false;
        } else {
            while (resultado.next()) {
                System.out.println("\nEsse é o médico buscado:");
                System.out.println("\nID: " + resultado.getInt("Id_med") + "\nNome: " + resultado.getString("Nome")
                        + "\nEspecialidade: " + resultado.getString("especialidade"));
            }

        }
        resultado.close();
        comandossql.close();
        connection.close();
        return true;
    }

    public void alterarMedico(int id, String nome, String especialidade) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection
                .prepareStatement("UPDATE Medico SET Nome = ?, especialidade = ? WHERE Id_med = ?");
        comandossql.setString(1, nome);
        comandossql.setString(2, especialidade);
        comandossql.setInt(3, id);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public void listarMedicos() throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Medico");
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Não existe médicos cadastrados.");
            comandossql.close();
            connection.close();
        } else {
            while (resultado.next()) {
                System.out.println("\nID: " + resultado.getInt("Id_med") + "\nNome: " + resultado.getString("Nome")
                        + "\nEspecialidade: " + resultado.getString("especialidade"));
            }

        }
        resultado.close();
        comandossql.close();
        connection.close();
    }
}
