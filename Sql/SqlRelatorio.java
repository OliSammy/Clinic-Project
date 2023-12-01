package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SqlRelatorio {
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
                .prepareStatement("INSERT INTO Relatorio () VALUES (?,?,?,?)");
        // comandossql.setInt(1, consultaRealizada);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

}
