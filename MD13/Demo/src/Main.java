import domain.Aluno;
import domain.Disciplina;
import domain.exceptions.DisciplinaException;
import domain.exceptions.NotaException;
import services.AlunoService;
import services.BaseService;
import services.DisciplinaService;

import javax.swing.*;

public class Main {
    private final static DisciplinaService disciplinaService = new DisciplinaService();
    private final static AlunoService alunoService = new AlunoService(disciplinaService);

    private final static String tituloPrograma = "Registro Escolar";

    public static void main(String[] args) {
        BaseService.setTituloPrograma(tituloPrograma);
        Aluno[] alunos = new Aluno[BaseService.getQtdInsercao("Quantidade de alunos")];
        carregarAlunos(alunos);

        StringBuilder saida = new StringBuilder();

        for (Aluno aluno : alunos) {
            System.out.println(aluno);

            saida.append("Aluno(a) ").append(aluno.getNome()).append("\n");

            for (Disciplina disciplina : aluno.getDisciplinas()) {
                saida.append("\nDisciplina ").append(disciplina.getNome());

                for (int semestre = 1; semestre <= disciplina.getSemestresNotas().length; semestre++) {
                    saida.append("\n    Notas ").append(semestre).append("º semestre: ");

                    String separadorNotas = "";

                    for (double nota: disciplina.getNotas(semestre)) {
                        saida.append(separadorNotas).append(nota);
                        separadorNotas = ", ";
                    }

                    saida.append("\n    Média ").append(semestre).append("º semestre: ").append(disciplina.getMedia(semestre));
                }

                saida.append("\n    Média Final: ").append(disciplina.getMedia()).append("\n");
            }

            JOptionPane.showMessageDialog(null, saida, tituloPrograma, JOptionPane.INFORMATION_MESSAGE);
            saida.setLength(0);
        }


    }

    private static void carregarAlunos(Aluno[] alunos) {
        for (int i = 0; i < alunos.length; i++) {
            Aluno aluno = alunoService.getAluno(i + 1);
            carregarDisciplinas(aluno);
            alunos[i] = aluno;
        }
    }

    private static void carregarDisciplinas(Aluno aluno) {
        for (int i = 1; i <= aluno.getDisciplinas().length; i++) {
            boolean sucesso = false;

            do {
                try {
                    alunoService.setDisciplina(aluno, i);
                    sucesso = true;
                } catch (DisciplinaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Disciplina Inválida", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Disciplina Inválida", JOptionPane.ERROR_MESSAGE);
                }
            } while (!sucesso);

            carregarNotas(aluno.getDisciplina(i));
        }
    }

    private static void carregarNotas(Disciplina disciplina) {
        boolean sucesso = false;

        for (int semestre = 1; semestre <= disciplina.getSemestresNotas().length; semestre++) {
            do {
                try {
                    alunoService.setNota(disciplina, semestre);
                    sucesso = true;
                } catch (NotaException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Nota Inválida", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro inesperado: " + ex.getMessage(), "Nota Inválida", JOptionPane.ERROR_MESSAGE);
                }
            } while (!sucesso);
        }
    }
}