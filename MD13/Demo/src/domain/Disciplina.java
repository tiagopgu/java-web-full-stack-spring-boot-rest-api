package domain;

import domain.exceptions.NomeException;
import domain.exceptions.NotaException;
import domain.validations.DisciplinaValidation;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {
    private String nome;
    private double[] notas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeException {
        if (!DisciplinaValidation.Nome.validar(nome))
            throw new NomeException(DisciplinaValidation.Nome.getMessageValidaton());

        this.nome = nome.trim();
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) throws NotaException {
        if (!DisciplinaValidation.Nota.validarNotas(notas))
            throw new NotaException(DisciplinaValidation.Nota.getMessageValidationNotas());

        this.notas = notas;
    }

    public Disciplina(String nome) throws NomeException, NotaException {
        this(nome, new double[4]);
    }

    public Disciplina(String nome, double[] notas) throws NomeException, NotaException {
        setNome(nome);
        setNotas(notas);
    }

    public void setNota(int posicao, double nota) throws NotaException, ArrayIndexOutOfBoundsException {
        if (!DisciplinaValidation.Nota.validarNota(nota))
            throw new NotaException(DisciplinaValidation.Nota.getMessageValidation());

        notas[posicao] = nota;
    }

    public double getNota(int posicao) throws ArrayIndexOutOfBoundsException {
        return notas[posicao];
    }

    public double getMedia() {
        double notaTotal = 0;

        for (double nota : notas)
            notaTotal += nota;

        return notaTotal / notas.length;
    }

    public double getMenorNota() {
        double menorNota = DisciplinaValidation.Nota.MAX_NOTA + 1;

        for (double nota : notas)
            menorNota = nota < menorNota ? nota : menorNota;

        return menorNota;
    }

    public double getMaiorNota() {
        double maiorNota = DisciplinaValidation.Nota.MIN_NOTA - 1;

        for (double nota : notas)
            maiorNota = nota > maiorNota ? nota : maiorNota;

        return maiorNota;
    }



    @Override
    public String toString() {
        return "Disciplina{" +
                "notas=" + Arrays.toString(notas) +
                ", nome='" + nome + '\'' +
                '}';
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
