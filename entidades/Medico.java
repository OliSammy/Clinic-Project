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
    public void exibirMedico() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Especialidade: " + this.especialidade);
        System.out.println("ID: " + this.id);
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
