package jdev.curso.classes;

public class Aluno {
    String nome;
    String documento;
    String nomeMae;
    String nomePai;
    int codigoTurma;

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

    public String compilarDados() {
        return "Nome: " + (getNome() == null ? "" : getNome()) +
                "\nDocumento: " + (getDocumento() == null ? "" : getDocumento()) +
                "\nNome do pai: " + (getNomePai() == null ? "" : getNomePai()) +
                "\nNome da mãe: " + (getNomeMae() == null ? "" : getNomeMae()) +
                "\nCódigo da Turma: " + getCodigoTurma();
    }
}
