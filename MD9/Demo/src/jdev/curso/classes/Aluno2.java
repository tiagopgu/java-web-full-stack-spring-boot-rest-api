package jdev.curso.classes;

public class Aluno2 {
    String nome;
    String documento;

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

    public Aluno2(String nome, String documento)
    {
        setNome(nome);
        setDocumento(documento);
    }
}
