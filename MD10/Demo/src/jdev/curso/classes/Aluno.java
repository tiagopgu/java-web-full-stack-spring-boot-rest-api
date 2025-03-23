package jdev.curso.classes;

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String documento, String nome, String matricula) {
        super(documento, nome);

        setMatricula(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
