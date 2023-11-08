package controladores;
import java.util.ArrayList;
import entidades.Medico;
import Sql.SqlMedico;
public class Staff {
   private  SqlMedico sql = new SqlMedico();
   private ArrayList<Medico> staff = new ArrayList<Medico>();
   
   public void adicionarMedico(String nome, String especialidade)throws Exception {
            sql.adicionarMedico(nome, especialidade);
            return;
        }
   public void removerMedico(int id)throws Exception {
        sql.removerMedico(id);
        return;
   }
   public void alterarMedico(Medico medico){
        for (Medico medicoCadastrado : this.staff) {
            if (medicoCadastrado.getId() == medico.getId()) {
                medicoCadastrado.setNome(medico.getNome());
                medicoCadastrado.setEspecialidade(medico.getEspecialidade());
                return;
            }
        }
   }
    public Medico selecionarMedico(int id) {
        for (Medico medico : this.staff) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

public void listarMedicos() {
    for (Medico medico : this.staff) {
        System.out.println(medico);;
    }
}
public void buscarMedico(int id) throws Exception {
    sql.buscarMedico(id);
}

}
