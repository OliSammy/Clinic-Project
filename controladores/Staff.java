package controladores;
import java.util.ArrayList;
import entidades.Medico;
public class Staff {

   private ArrayList<Medico> staff = new ArrayList<Medico>();
   
   public void adicionarMedico(Medico medico) {
        if(!verificarMedico(medico)){
            this.staff.add(medico);
            return;
        }
        System.out.println("Médico já cadastrado!");    
   }
   public void removerMedico(Medico medico) {
        this.staff.remove(medico);
   }
   public void alterarMedico(Medico medico){
        for (Medico medicoCadastrado : this.staff) {
            if (medicoCadastrado.getId() == medico.getId()) {
                medicoCadastrado.setNome(medico.getNome());
                medicoCadastrado.setEspecialidade(medico.getEspecialidade());
                System.out.println("Médico alterado com sucesso!");
                return;
            }
        System.out.println("Médico não cadastrado no banco de dados");
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
    
    public Medico buscarMedico(int id) {
    for (Medico medico : this.staff) {
        if (verificarMedico(medico)) {
            System.out.println("Médico encontrado!");
            System.out.println(medico);
            return medico;
        }
    }
    System.out.println("\nMédico não cadastrado no banco de dados, voltando ao menu...\n");
    return null;
     
}

public void listarMedicos() {
    for (Medico medico : this.staff) {
        System.out.println(medico);;
    }
}
public void exibirMedico(Medico medico) {
    System.out.println(medico);
}

public boolean verificarMedico(Medico medico) {
    for (Medico medicoCadastrado : this.staff) {
        if (medicoCadastrado.getId() == medico.getId()) {
            return true;
        }
    }
    return false;
}
}
