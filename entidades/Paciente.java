package entidades;
public class Paciente {
    private String nome;
    private int idade;
    private String genero;
    private int id;
    public Paciente(String nome, int idade, String genero, int id) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.id = id;
    }

    public void exibirPaciente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero);
        System.out.println("ID: " + this.id);
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    public String getGenero() {
        return genero;
    }
    
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

