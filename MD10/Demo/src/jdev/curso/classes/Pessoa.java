package jdev.curso.classes;

public abstract class Pessoa {
    protected String nome;
    protected String documento;
    protected String dataNascimento;

    protected Pessoa(String documento, String nome) {
        setDocumento(documento);
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        String documentoAux = documento;

        if (documento.length() < 11) {
            documentoAux = "0".repeat(11 - documento.length()) + documento;
        } else if (documento.length() > 11) {
            documentoAux = documento.substring(0, 11);
        }

        this.documento = documentoAux;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumentoFormatado() {
        // 000.159.368-05 - 00.15.36-05
        String documentoAux = documento.substring(0, 3) + ".";

        documentoAux = documentoAux + documento.substring(3, 6) + ".";
        documentoAux = documentoAux + documento.substring(6, 9) + "-";
        documentoAux = documentoAux + documento.substring(9);

        return documentoAux;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "dataNascimento='" + dataNascimento + '\'' +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
