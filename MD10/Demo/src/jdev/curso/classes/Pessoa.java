package jdev.curso.classes;

public abstract class Pessoa {
    protected String codigo;
    protected String nome;
    protected String documento;
    protected String dataNascimento;

    protected Pessoa(String documento, String nome) {
        setDocumento(documento);
        setNome(nome);
        setCodigo();
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo() {
        this.codigo = gerarCodigo();
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
        String documentoAux = documento.substring(0, 3) + ".";

        documentoAux = documentoAux + documento.substring(3, 6) + ".";
        documentoAux = documentoAux + documento.substring(6, 9) + "-";
        documentoAux = documentoAux + documento.substring(9);

        return documentoAux;
    }

    protected abstract String gerarCodigo();

    @Override
    public String toString() {
        return "Pessoa{" +
                "Código='" + getCodigo() + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", nome='" + nome + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}
