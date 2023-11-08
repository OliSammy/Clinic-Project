package Sql;
import java.sql.*;
public class SqlMedico {
     Connection connection = null;
     String url = "jdbc:sqlite:TP-4.db";

     public void adicionarMedico(String Nome, String Especialidade) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("INSERT INTO Medico (nome, especialidade) VALUES (?,?)");
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
    public void buscarMedico(int id) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Medico WHERE Id_med = ?");
        comandossql.setInt(1, id);
        ResultSet resultado = comandossql.executeQuery();
        while (resultado.next()) {
            System.out.println("ID: " + resultado.getInt("id") + "\nNome: " + resultado.getString("nome") + "\nEspecialidade: " + resultado.getString("especialidade"));
        }
        resultado.close();
        comandossql.close();
        connection.close();
    }
}
