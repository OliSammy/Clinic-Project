package Sql;
import java.sql.*;



public class SqlCliente {

    Connection connection = null;
     String url = "jdbc:sqlite:TP-4.db";

     public void adicionarCliente(long cpf, String nome, String genero, String idade  ) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("INSERT INTO Paciente (CPF, Nome, Gênero,Data_de_Nascimento) VALUES (?,?,?,?)");
        comandossql.setLong(1, cpf);
        comandossql.setString(2, nome);
        comandossql.setString(3, genero);
        comandossql.setString(4, idade);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
        }
        //comando ok
    public void removerCliente(Long cpf) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("DELETE FROM Paciente WHERE CPF = ?");
        comandossql.setLong(1, cpf);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }

    public boolean verificarCliente(Long cpf) throws SQLException{
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Paciente where CPF = ?");
        comandossql.setLong(1, cpf);
        ResultSet resultado = comandossql.executeQuery();
        if(!resultado.isBeforeFirst()){
            return false;
        }
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
        return true;
    }

    public void buscarCliente(long cpf) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Paciente WHERE CPF = ?");
        comandossql.setLong(1, cpf);
        ResultSet resultado = comandossql.executeQuery();
        while (resultado.next()) {
            //nao entendi
            System.out.println("ID: " + resultado.getInt("id") + "\nNome: " + resultado.getString("nome") + "\nEspecialidade: " + resultado.getString("especialidade"));
        }
        resultado.close();
        comandossql.close();
        connection.close();
    }

}