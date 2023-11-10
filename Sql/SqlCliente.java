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
            System.out.println("Nenhum resultado encontrado.");
            return false;
        }else{
            while(resultado.next()){
                System.out.println("\nEsse é o paciente buscado:");
                System.out.println("\nCPF: " + resultado.getLong("CPF") + "\nNome: " + resultado.getString("Nome") + "\nGênero: " + resultado.getString("Gênero") + "\nData de Nascimento: " + resultado.getString("Data_de_Nascimento"));
            }
        }
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
        return true;
    }

    public boolean verificarClienteExiste(Long cpf) throws SQLException{
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Paciente where CPF = ?");
        comandossql.setLong(1, cpf);
        ResultSet resultado = comandossql.executeQuery();
        if(!resultado.isBeforeFirst()){
            return false;
        }else{
            while(resultado.next()){
                System.out.println("\nEsse é o paciente buscado:");
                System.out.println("\nCPF: " + resultado.getLong("CPF") + "\nNome: " + resultado.getString("Nome") + "\nGênero: " + resultado.getString("Gênero") + "\nData de Nascimento: " + resultado.getString("Data_de_Nascimento"));
            }
        }
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
        return true;
    }
    public boolean selecionarCliente(long cpf) throws SQLException{
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Paciente WHERE CPF = ?");
        comandossql.setLong(1, cpf);
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Nenhum resultado encontrado.");
            return false;
            } else {
                while (resultado.next()) {
                    System.out.println("\nEsse é o paciente buscado:");
                    System.out.println("\nCPF: " + resultado.getLong("CPF") + "\nNome: " + resultado.getString("Nome") + "\nGênero: " + resultado.getString("Gênero") + "\nData de Nascimento: " + resultado.getString("Data_de_Nascimento"));
                }
                
            }
        resultado.close();
        comandossql.close();
        connection.close();
        return true;
    }
    public void alterarCliente(long cpf, String nome, String genero, String idade) throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("UPDATE Paciente SET Nome = ?, Gênero = ?, Data_de_Nascimento = ? WHERE CPF = ?");
        comandossql.setString(1, nome);
        comandossql.setString(2, genero);
        comandossql.setString(3, idade);
        comandossql.setLong(4, cpf);
        comandossql.executeUpdate();
        comandossql.close();
        connection.close();
    }
    public void listarClientes() throws SQLException {
        connection = DriverManager.getConnection(url);
        PreparedStatement comandossql = connection.prepareStatement("SELECT * FROM Paciente");
        ResultSet resultado = comandossql.executeQuery();
        if (!resultado.isBeforeFirst()) {
            System.out.println("Não existe pacientes cadastrados.");
            } else {
                while (resultado.next()) {
                    System.out.println("\nCPF: " + resultado.getLong("CPF") + "\nNome: " + resultado.getString("Nome") + "\nGênero: " + resultado.getString("Gênero") + "\nData de Nascimento: " + resultado.getString("Data_de_Nascimento"));
                }
        
            }
        resultado.close();
        comandossql.close();
        connection.close();
    }

}