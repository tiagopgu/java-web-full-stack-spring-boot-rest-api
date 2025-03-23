package jdev.curso.classes;

public class Instrutor extends Pessoa {
    private String registroProfissional;

    public Instrutor(String documento, String nome, String registroProfissional) {
        super(documento, nome);

        setRegistroProfissional(registroProfissional);
    }

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    @Override
    public String getDocumentoFormatado() {
        return "#" + super.getDocumentoFormatado() + "#";
    }

    @Override
    public String toString() {
        return "Instrutor{" +
                "nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", documento='" + documento + '\'' +
                ", registroProfissional='" + registroProfissional + '\'' +
                '}';
    }
}
