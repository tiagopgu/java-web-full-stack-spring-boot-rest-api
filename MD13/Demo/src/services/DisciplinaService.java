package services;

import domain.Disciplina;
import domain.exceptions.DomainException;
import domain.validations.DisciplinaValidation;

import javax.swing.*;

public class DisciplinaService extends BaseService {
    private final String MODULO = "Disciplina";

    public Disciplina[] criarListaDisciplinas() {
        return new Disciplina[getQtdInsercao("Quantidade de disciplinas", MODULO)];
    }

    public Disciplina getDisciplina(int ordem) {
        Disciplina disciplina = null;

        do {
            try {
                disciplina = new Disciplina(getNome(ordem), new double[4]);
            } catch (DomainException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            }
        } while (disciplina == null);

        return disciplina;
    }

    public double getNota(int pos) {
        double nota = -1;

        do {
            try {
                String input = JOptionPane.showInputDialog(null, "Nota " + pos + ": ", getTituloPrograma(MODULO), JOptionPane.QUESTION_MESSAGE);

                if (input == null)
                    System.exit(0);

                nota = Double.parseDouble(input);

                if (!DisciplinaValidation.Nota.validarNota(nota))
                    JOptionPane.showMessageDialog(null, DisciplinaValidation.Nota.getMessageValidation(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida: deve ser informado um número", getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            }
            catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);
            }
        } while (!DisciplinaValidation.Nota.validarNota(nota));

        return nota;
    }

    private String getNome(int ordem) {
        String nome;

        do {
            nome = JOptionPane.showInputDialog(null, "Nome da disciplina " + ordem, getTituloPrograma(MODULO), JOptionPane.QUESTION_MESSAGE);

            if (nome == null)
                System.exit(0);

            if (!DisciplinaValidation.Nome.validar(nome))
                JOptionPane.showMessageDialog(null, DisciplinaValidation.Nome.getMessageValidaton(), getTituloPrograma(MODULO), JOptionPane.ERROR_MESSAGE);

        } while (!DisciplinaValidation.Nome.validar(nome));

        return nome;
    }
}
