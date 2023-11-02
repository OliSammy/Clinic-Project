package entidades;
public class Medico {
    private String nome;
    private String especialidade;
    private int id;
    public Medico(String nome, String especialidade, int id) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.id = id;
    }
   
    
    @Override
    public String toString() {
        return "Nome: " + this.nome + "\nEspecialidade: " + this.especialidade + "\nID: " + this.id + "\n\n";
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
