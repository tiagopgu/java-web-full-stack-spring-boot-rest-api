package jdev.curso.classes;

import java.util.Objects;

public class Aluno {

    String nome;
    String documento;
    String nomeMae;
    String nomePai;
    int codigoTurma;
    Disciplina disciplina;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Aluno() {
    }

    public Aluno(String nome) {
        setNome(nome);
    }

    public Aluno(String nome, String documento) {
        setNome(nome);
        setDocumento(documento);
    }

    public Aluno(String nome, String documento, int codigoTurma) {
        setNome(nome);
        setDocumento(documento);
        setCodigoTurma(codigoTurma);
    }

    public Aluno(String nome, String documento, int codigoTurma, Disciplina disciplina) {
        this.nome = nome;
        this.documento = documento;
        this.codigoTurma = codigoTurma;
        this.disciplina = disciplina;
    }

    public String toString() {
        String result = "Nome: " + (getNome() == null ? "" : getNome()) +
                "\nDocumento: " + (getDocumento() == null ? "" : getDocumento()) +
                "\nNome do pai: " + (getNomePai() == null ? "" : getNomePai()) +
                "\nNome da mãe: " + (getNomeMae() == null ? "" : getNomeMae()) +
                "\nCódigo da Turma: " + getCodigoTurma() +
                "\nDisciplina: " + getDisciplina();

        if (getDisciplina() != null)
            result += (getDisciplina().getAprovado() ?
                    "\n\tParabéns pela sua aprovação" :
                    getDisciplina().getReprovado() ?
                            "\n\tInfelizmente não foi dessa vez, mas não desista" :
                            "");

        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Aluno other = (Aluno) obj;

        return Objects.equals(documento, other.getDocumento());
    }

    public int hashCode() {
        int prime = 17;
        int result = 1;

        result *= prime + Objects.hashCode(getDocumento());

        return result;
    }
}
