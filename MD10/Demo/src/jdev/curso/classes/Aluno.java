package jdev.curso.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String documento, String nome, String matricula) {
        super(documento, nome);

        setMatricula(matricula);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    protected String gerarCodigo() {
        String codigo = "AL";
        Random rnd = new Random();
        List<Integer> rangeCodASIIInvalids = new ArrayList<>(Arrays.asList(58, 59, 60, 61, 62, 63, 64));

        for (int i = 0; i < 5; i++) {
            int asciiCode;

            do {
                asciiCode = rnd.nextInt(48, 90);
            } while (rangeCodASIIInvalids.contains(asciiCode));

            char caracter = (char) asciiCode;

            codigo += caracter;
        }

       return codigo;
    }
}
