package jdev.curso.classes;

import jdev.curso.interfaces.Colaborador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Secretario extends Pessoa implements Colaborador {
    private List<String> atribuicoes;

    public Secretario(String documento, String nome) {
        super(documento, nome);

        atribuicoes = new ArrayList<>();
    }

    public List<String> getAtribuicoes() {
        return atribuicoes;
    }

    public void setAtribuicao(String atribuicao) {
        this.atribuicoes.add(atribuicao);
    }

    @Override
    public String gerarCodigo() {
        String codigo = "ST";
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) {
            int codASCII = rnd.nextInt(65, 90);
            codigo += (char)codASCII;
        }

        return codigo;
    }

    @Override
    public double calcularSalario() {
        return 3226.00;
    }

    @Override
    public boolean baterPonto(String data) {
        return false;
    }
}
