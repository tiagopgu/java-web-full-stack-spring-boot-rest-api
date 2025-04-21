package services;

import domain.Aluno;
import domain.Disciplina;
import domain.exceptions.DisciplinaException;
import domain.exceptions.DomainException;
import domain.exceptions.NotaException;
import domain.validations.AlunoValidation;

import javax.swing.*;

public class AlunoService extends BaseService {
    private final String MODULO = "Aluno";
    private final DisciplinaService disciplinaService;

    public AlunoService(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    public Aluno getAluno(int ordem) {
        Aluno aluno = null;

        do {
            try {
                aluno = new Aluno(getNome(ordem), disciplinaService.criarListaDisciplinas());
            } catch (DomainException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Um erro inesperado ocorreu: " + ex.getMessage(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            }
        } while (aluno == null);

        return aluno;
    }

    public void setDisciplina(Aluno aluno, int posicao) throws DisciplinaException {
        Disciplina disciplina = disciplinaService.getDisciplina(posicao + 1);

        aluno.setDisciplina(posicao, disciplina);
    }

    public void setNota(Disciplina disciplina, int posicao) throws NotaException {
        double nota = disciplinaService.getNota(posicao + 1);

        disciplina.setNota(posicao, nota);
    }

    private String getNome(int ordem) {
        String nome;

        do {
            nome = JOptionPane.showInputDialog(null, "Nome do aluno " + ordem, getTituloPrograma(MODULO), JOptionPane.QUESTION_MESSAGE);

            if (nome == null)
                System.exit(0);

            if (!AlunoValidation.Nome.validar(nome)) {
                JOptionPane.showMessageDialog(null, AlunoValidation.Nome.getMessageValidation(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            }
        } while (!AlunoValidation.Nome.validar(nome));

        return nome;
    }
}
