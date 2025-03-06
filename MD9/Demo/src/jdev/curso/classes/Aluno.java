package jdev.curso.classes;

import java.lang.annotation.Documented;
import java.util.Objects;

public class Aluno {
    private double MINIMO_APROVACAO = 7.0;
    private double MINIMO_RECUPERACAO = 5.0;
    private double VALOR_ARREDONDAMENTO = 0.25;

    String nome;
    String documento;
    String nomeMae;
    String nomePai;
    int codigoTurma;

    double nota1;
    double nota2;
    double nota3;
    double nota4;

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

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public double getNota4() {
        return nota4;
    }

    public Aluno() { }

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

    public double getMedia() {
        return (getNota1() + getNota2() + getNota3() + getNota4()) / 4;
    }

    // Nos métodos booleanos a seguir, o sistema tenta arredondar a nota
    // Isso dá uma chance de livrar o aluno de determinada situação
    public boolean getAprovado() {
        double media = getMedia();
        double mediaAuxiliar = media + VALOR_ARREDONDAMENTO;

        return media >= MINIMO_APROVACAO || mediaAuxiliar >= MINIMO_APROVACAO;
    }

    public boolean getRecuperacao() {
        double media = getMedia();
        double mediaAuxiliar = media + VALOR_ARREDONDAMENTO;

        return !getAprovado() && (media >= MINIMO_RECUPERACAO || mediaAuxiliar >= MINIMO_RECUPERACAO);
    }

    public boolean getReprovado() {
        return !(getAprovado() || getRecuperacao());
    }

    public String getSituacao() {
        if (getAprovado())
            return "Aprovado";

        if (getRecuperacao())
            return "Em Recuperação";

        return "Reprovado";
    }

    public String toString() {
        return "Nome: " + (getNome() == null ? "" : getNome()) +
                "\nDocumento: " + (getDocumento() == null ? "" : getDocumento()) +
                "\nNome do pai: " + (getNomePai() == null ? "" : getNomePai()) +
                "\nNome da mãe: " + (getNomeMae() == null ? "" : getNomeMae()) +
                "\nCódigo da Turma: " + getCodigoTurma() +
                "\nMédia: " + getMedia() +
                "\nSituação: " + getSituacao() +
                (getAprovado() ? "\n\tParabéns pela sua aprovação" : getReprovado() ? "\n\tInfelizmente não foi dessa vez, mas não desista" : "");
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

        result *= prime + (this.documento == null ? 0 : this.documento.hashCode());

        return result;
    }
}
