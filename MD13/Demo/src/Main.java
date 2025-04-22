import domain.Aluno;
import domain.Disciplina;
import domain.exceptions.DisciplinaException;
import domain.exceptions.DomainException;
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
        int optConfirm = JOptionPane.showConfirmDialog(null, "Deseja mostrar registros de teste?");

        if (optConfirm == JOptionPane.CLOSED_OPTION || optConfirm == JOptionPane.CANCEL_OPTION)
            System.exit(0);

        if (optConfirm == JOptionPane.YES_OPTION) {
            Aluno[] alunos = carregarAlunosTeste();
            mostrarAlunos(alunos);
        } else {
            BaseService.setTituloPrograma(tituloPrograma);
            Aluno[] alunos = new Aluno[BaseService.getQtdInsercao("Quantidade de alunos")];
            carregarAlunos(alunos);
            mostrarAlunos(alunos);
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

    private static void mostrarAlunos(Aluno[] alunos) {
        StringBuilder saida = new StringBuilder();

        for (Aluno aluno : alunos) {
            System.out.println(aluno);

            saida.append("Aluno(a) ").append(aluno.getNome()).append("\n");

            for (Disciplina disciplina : aluno.getDisciplinas()) {
                saida.append("\nDisciplina ").append(disciplina.getNome());

                for (int semestre = 1; semestre <= disciplina.getSemestresNotas().length; semestre++) {
                    saida.append("\n    Notas ").append(semestre).append("º semestre: ");

                    String separadorNotas = "";

                    for (double nota : disciplina.getNotas(semestre)) {
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

    private static Aluno[] carregarAlunosTeste() {
        String[] registros = getRegistrosTeste();
        StringBuilder registroErro = new StringBuilder();
        Aluno[] alunos = new Aluno[registros.length];
        int qtdAlunosLidos = 0;

        for (String registro : registros) {
            try {
                String[] dados = registro.split(";");
                String nomeAluno = dados[0];
                Disciplina[] disciplinas = getDisciplinasTeste(registro);
                Aluno aluno = new Aluno(nomeAluno, disciplinas);

                alunos[qtdAlunosLidos++] = aluno;
            } catch (Exception ex) {
                registroErro.append(registro)
                        .append(";").append(ex.getMessage()).append("\n");
            }
        }

        System.out.println(registroErro);

        return alunos;
    }

    private static String[] getRegistrosTeste() {
        String input = "Carolina Maitê Sebastiana Silva;Lógica de Programação;8.1;9.2;7.3;Programação Orientada a Objeto com Java;6.8;6.6;9.1;Desenvolvimento Web com Spring;8.6;7.6;8.0,"
                + "Filipe Benedito Anthony Nunes;HTML - CSS - Javascript;6.8;8.1;8.0;Typescript;7.6;8.1;9.2;Desenvolvimento SPA com Angular;8.1;9.5;8.0," +
                "Laura Alícia da Mota;UML;7.6;6.3;8.1;Arquitetura de Sistemas;9.3;6.5;8.1;Microserviços;8.9;8.1;9.1," +
                "J;UML;3.5;9.5;6.5;.NET;8.5;6.5;7.1," +
                "Maria Nunes Medeiros;;7.5;3.6;7.5," +
                "Júlia Alves;Web Design;5.3;7.1;-9.0";

        return input.split(",");
    }

    private static Disciplina[] getDisciplinasTeste(String registro) throws DomainException {
        String[] dados = registro.split(";");
        int qtdDadosDisciplina = dados.length - 1;
        int qtdDisciplinas = qtdDadosDisciplina / 4;
        Disciplina[] disciplinas = new Disciplina[qtdDisciplinas];
        int qtdDisciplinasLidas = 0;

        for (int i = 1; i < dados.length; i++) {
            String nome = dados[i];
            double nota1 = Double.parseDouble(dados[++i]);
            double nota2 = Double.parseDouble(dados[++i]);
            double nota3 = Double.parseDouble(dados[++i]);
            double[] notas = {nota1, nota2, nota3};

            Disciplina disciplina = new Disciplina(nome);
            disciplina.setNota(1, notas);

            disciplinas[qtdDisciplinasLidas++] = disciplina;
        }

        return disciplinas;
    }
}