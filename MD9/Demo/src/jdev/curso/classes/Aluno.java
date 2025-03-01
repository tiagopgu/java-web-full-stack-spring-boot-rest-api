package jdev.curso.classes;

public class Aluno {
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

    public String compilarDados() {
        return "Nome: " + (getNome() == null ? "" : getNome()) +
                "\nDocumento: " + (getDocumento() == null ? "" : getDocumento()) +
                "\nNome do pai: " + (getNomePai() == null ? "" : getNomePai()) +
                "\nNome da mãe: " + (getNomeMae() == null ? "" : getNomeMae()) +
                "\nCódigo da Turma: " + getCodigoTurma() +
                "\nMédia: " + getMedia();
    }
}
