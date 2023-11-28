package entidades;

public class Paciente {
    private String nome;
    private int idade;
    private String genero;
    private long cpf;

    public Paciente(String nome, int idade, String genero, long cpf) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "\nNome: " + this.nome + "\nIdade: " + this.idade + "\nGênero: " + this.genero + "\nID: " + this.cpf
                + "\n\n";
    }

    public void exibirPaciente() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero);
        System.out.println("ID: " + this.cpf);
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

    public long getCpf() {
        return cpf;
    }

    public void setId(long cpf) {
        this.cpf = cpf;
    }
}
