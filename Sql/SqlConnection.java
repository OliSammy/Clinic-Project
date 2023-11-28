package Sql;

import java.sql.*;

public class SqlConnection {

    Connection connection = null;
    String url = "jdbc:sqlite:clinica.db";

    public Connection abrirConexao() throws SQLException {
        connection = DriverManager.getConnection(url);
        return connection;
    }

    public void fecharConexao(Connection conexao) throws SQLException {
        conexao.close();
    }

    public Connection gConnection() {
        return this.connection;
    }

    public String getUrl() {
        return this.url;
    }

}
