package jdev.curso.classes;

import jdev.curso.constantes.Situacao;

import java.util.Objects;

public class Disciplina {
    private double MINIMO_APROVACAO = 7.0;
    private double MINIMO_RECUPERACAO = 5.0;
    private double VALOR_ARREDONDAMENTO = 0.25;

    int codigo;
    String titulo;

    double nota1;
    double nota2;
    double nota3;
    double nota4;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }

    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public Disciplina(int codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
    }

    public Disciplina(int codigo, String titulo, double nota1, double nota2, double nota3, double nota4) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
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
            return Situacao.APROVADO;

        if (getRecuperacao())
            return Situacao.RECUPERACAO;

        return Situacao.REPROVADO;
    }

    public String toString() {
        return "[" + getCodigo() + "] " + getTitulo() + " - Média: " + getMedia() + " - Situação: " + getSituacao() + " (" + Situacao.getDescricao(getSituacao()) + ")";
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Disciplina other = (Disciplina) obj;

        return Objects.equals(getCodigo(), other.getCodigo());
    }

    public int hashCode() {
        int prime = 7;
        int result = 1;

        result *= prime + Objects.hashCode(getCodigo());

        return result;
    }
}
