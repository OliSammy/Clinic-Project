package controladores;
import Sql.SqlCliente;

public class Clientes {
    private SqlCliente sql= new SqlCliente();

    public void adicionarCliente(String nome, String idade, String genero, long cpf) throws Exception {
        if (sql.verificarClienteExiste(cpf)){
            System.out.println("Paciente já existe");
        }
        else{
            sql.adicionarCliente(cpf, nome, genero, idade);
            System.out.println("Cliente adicionado com sucesso");
        }
    }

    public void removerCliente(long cpf)throws Exception {
        sql.removerCliente(cpf);
        return;
    }
 
    public void alterarCliente(long cpf, String nome, String genero, String idade)throws Exception{
        sql.alterarCliente(cpf, nome, genero, idade);
    }

    public boolean selecionarCliente(long cpf) throws Exception{
        if (sql.selecionarCliente(cpf)){
            return true;
        }
        return false;
      
    }
    public void listarClientes()throws Exception{
        sql.listarClientes();
    }
}