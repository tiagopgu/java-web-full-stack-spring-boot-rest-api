package jdev.curso.classes;

import jdev.curso.interfaces.Colaborador;

import java.util.Random;

public class Instrutor extends Pessoa implements Colaborador {
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
                "Código='" + getCodigo() + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", documento='" + documento + '\'' +
                ", registroProfissional='" + registroProfissional + '\'' +
                '}';
    }

    @Override
    protected String gerarCodigo() {
        String codigo = "IT";
        Random rnd = new Random();

        for (int i = 0; i < 4; i ++) {
            int rndCod = rnd.nextInt(0, 9);

            codigo += rndCod;
        }

        return codigo;
    }

    @Override
    public double calcularSalario() {
        return 3116.16;
    }

    @Override
    public boolean baterPonto(String data) {
        return true;
    }
}
