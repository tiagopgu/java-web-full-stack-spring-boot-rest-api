package domain;

import domain.exceptions.DisciplinaException;
import domain.exceptions.NomeException;
import domain.validations.AlunoValidation;

import java.util.Objects;

public class Aluno {
    private String nome;
    private Disciplina[] disciplinas;

    public Aluno(String nome, Disciplina[] disciplinas) throws NomeException, DisciplinaException {
        setNome(nome);
        setDisciplinas(disciplinas);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws NomeException {
        if (!AlunoValidation.Nome.validar(nome))
            throw new NomeException(AlunoValidation.Nome.getMessageValidation());

        this.nome = nome.trim();
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) throws DisciplinaException {
        if (!AlunoValidation.Disciplina.validarLista(disciplinas))
            throw new DisciplinaException(AlunoValidation.Disciplina.getMessageValidationLista());

        this.disciplinas = disciplinas;
    }

    public Disciplina getDisciplina(int posicao) throws ArrayIndexOutOfBoundsException {
        return disciplinas[posicao];
    }

    public void setDisciplina(int posicao, Disciplina disciplina) throws DisciplinaException, ArrayIndexOutOfBoundsException {
        if (!AlunoValidation.Disciplina.validar(disciplina))
            throw new DisciplinaException(AlunoValidation.Disciplina.getMessageValidation());

        disciplinas[posicao] = disciplina;
    }

    @Override
    public String toString() {
        StringBuilder saida = new StringBuilder();

        saida.append("Aluno{")
                .append("nome='").append(getNome()).append("'")
                .append(", Disciplinas=[");

        String separadoDisciplinas = "";

        for (Disciplina disciplina : disciplinas) {
            if (disciplina == null)
                continue;

            saida.append(separadoDisciplinas).append(disciplina);

            separadoDisciplinas = ", ";
        }
        saida.append(']')
                .append('}');

        return saida.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;

        Aluno other = (Aluno)obj;

        return Objects.equals(nome.toLowerCase(), other.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }
}
