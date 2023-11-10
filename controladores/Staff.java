package controladores;
import Sql.SqlMedico;
public class Staff {
   private  SqlMedico sql = new SqlMedico();

   
   public void adicionarMedico(String nome, String especialidade)throws Exception {
            sql.adicionarMedico(nome, especialidade);
            return;
        }
   public void removerMedico(int id)throws Exception {
        sql.removerMedico(id);
        return;
   }
   public void alterarMedico(String nome, String especialidade, int id)throws Exception {
        sql.alterarMedico(id, nome, especialidade);
   }
public void listarMedicos()throws Exception {
   sql.listarMedicos();
}
public boolean selecionarMedico(int id) throws Exception {
    if (sql.selecionarMedico(id)) {
        return true;
    }
    return false;
}


}
