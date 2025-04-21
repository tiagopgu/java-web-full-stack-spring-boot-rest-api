package domain;

import domain.exceptions.NomeException;
import domain.exceptions.NotaException;
import domain.validations.DisciplinaValidation;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {
    private String nome;
    private double[][] semestresNotas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeException {
        if (!DisciplinaValidation.Nome.validar(nome))
            throw new NomeException(DisciplinaValidation.Nome.getMessageValidaton());

        this.nome = nome.trim();
    }

    public double[][] getSemestresNotas() {
        return semestresNotas;
    }

    public void setSemestresNotas(double[][] semestresNotas) throws NotaException {
        if (!DisciplinaValidation.Nota.validarNotas(semestresNotas))
            throw new NotaException(DisciplinaValidation.Nota.getMessageValidationNotas());

        this.semestresNotas = semestresNotas;
    }

    public Disciplina(String nome) throws NomeException, NotaException {
        this(nome, new double[1][3]);
    }

    public Disciplina(String nome, double[][] semestresNotas) throws NomeException, NotaException {
        setNome(nome);
        setSemestresNotas(semestresNotas);
    }

    public void setNota(int semestre, int ordem, double nota) throws NotaException, ArrayIndexOutOfBoundsException {
        if (!DisciplinaValidation.Nota.validarNota(nota))
            throw new NotaException(DisciplinaValidation.Nota.getMessageValidation());

        semestresNotas[--semestre][--ordem] = nota;
    }

    public void setNota(int semestre, double[] notas) throws NotaException, ArrayIndexOutOfBoundsException {
        if (!DisciplinaValidation.Nota.validarNotas(notas))
            throw new NotaException(DisciplinaValidation.Nota.getMessageValidationNotas());

        for (int ordem = 0; ordem < notas.length; ordem++)
            setNota(semestre, ordem + 1, notas[ordem]);
    }

    public double getNota(int semestre, int ordem) throws ArrayIndexOutOfBoundsException {
        return semestresNotas[--semestre][--ordem];
    }

    public double[] getNotas(int semestre) throws ArrayIndexOutOfBoundsException {
        return semestresNotas[--semestre];
    }

    public double getMedia() {
        double mediaTotalSemestre = 0;

        for (int semestre = 1; semestre <= semestresNotas.length; semestre++)
            mediaTotalSemestre += getMedia(semestre);

        return mediaTotalSemestre / semestresNotas.length;
    }

    public double getMedia(int semestre) {
        double notaTotal = 0;

        for (double nota : semestresNotas[semestre - 1])
            notaTotal += nota;

        return notaTotal / semestresNotas[semestre - 1].length;
    }

    public double getMenorNota() {
        double menorNota = DisciplinaValidation.Nota.MAX_NOTA + 1;

        for (int semestre = 1; semestre <= semestresNotas.length; semestre++)
            menorNota = getMenorNota(semestre) < menorNota ? getMenorNota(semestre) : menorNota;

        return menorNota;
    }

    public double getMenorNota(int semestre) {
        double menorNota = DisciplinaValidation.Nota.MAX_NOTA + 1;

        for (double nota : semestresNotas[--semestre])
            menorNota = nota < menorNota ? nota : menorNota;

        return menorNota;
    }

    public double getMaiorNota() {
        double maiorNota = DisciplinaValidation.Nota.MIN_NOTA - 1;

        for (int semestre = 1; semestre <= semestresNotas.length; semestre++)
            maiorNota = getMaiorNota(semestre) > maiorNota ? getMaiorNota(semestre) : maiorNota;

        return maiorNota;
    }

    public double getMaiorNota(int semestre) {
        double maiorNota = DisciplinaValidation.Nota.MIN_NOTA - 1;

        for (double nota : semestresNotas[--semestre])
            maiorNota = nota > maiorNota ? nota : maiorNota;

        return maiorNota;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();

        saida.append("Disciplina{")
                .append("nome='").append(nome).append("'")
                .append(", semestresNotas=[");

        String separadorArray = "";
        for (double[] notas : semestresNotas) {
            saida.append(separadorArray).append(Arrays.toString(notas));

            separadorArray = ", ";
        }

        saida.append("]}");

        return saida.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(nome.toLowerCase(), that.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
