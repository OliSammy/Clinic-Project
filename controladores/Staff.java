package controladores;
import java.util.ArrayList;
import entidades.Medico;
public class Staff {

   private ArrayList<Medico> staff = new ArrayList<Medico>();
   
   public void adicionarMedico(Medico medico) {
        verificarMedico(medico);
        this.staff.add(medico);
   }
   public void removerMedico(Medico medico) {
        this.staff.remove(medico);
   }
   public Medico buscarMedico(int id) {
        for (Medico medico : this.staff) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null; 
    }

    public void listarMedicos() {
          for (Medico medico : this.staff) {
                medico.exibirMedico();
          }
    }
   public void verificarMedico(Medico medico) {
        for (Medico medicoCadastrado : this.staff) {
            if (medicoCadastrado.getId() == medico.getId()) {
                System.out.println("Médico já cadastrado!");
                return;
            }
        }
   }
}
