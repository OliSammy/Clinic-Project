package entidades;

public class Agendamento {
    private Paciente paciente;
    private Medico medico;
    private String data;
    private String hora;
    private String especialidade;
    private int id;
    
    public Agendamento(Paciente paciente, Medico medico, String data, String hora, String especialidade, int id) {
        this.paciente = paciente;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
        this.especialidade = especialidade;
        this.id = id;
    }
    
    public void exibirAgenda() {
        System.out.println("Paciente: " + this.paciente.getNome());
        System.out.println("Médico: " + this.medico.getNome());
        System.out.println("Data: " + this.data);
        System.out.println("Hora: " + this.hora);
        System.out.println("Especialidade: " + this.especialidade);
        System.out.println("ID: " + this.id);
        
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Medico getMedico() {
        return medico;
    }
    
    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getHora() {
        return hora;
    }
    public int getId() {
        return id;
    }
    public int setId() {
        return id;
    }
}
