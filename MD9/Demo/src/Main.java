import jdev.curso.classes.*;
import jdev.curso.constantes.Situacao;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static List<Aluno> alunos = new ArrayList<Aluno>();
    private static HashMap<String, HashMap<String, List<Aluno>>> relatorioAlunos = new HashMap<String, HashMap<String, List<Aluno>>>();

    public static void main(String[] args) {
        System.out.println("Cadastro de Alunos!\n");

        carregarAlunos();

        for (Aluno aluno : alunos) {
            System.out.println("\n" + aluno);
        }

        carregarRelatorioAlunos();

        System.out.println("\n************ RELATÓRIO DE ALUNOS ************\n");

        System.out.println("Total de aluno: " + alunos.size());
        System.out.println("Situação dos alunos por disciplina: ");

        for (String disciplina : relatorioAlunos.keySet()) {
            System.out.println("\t Disciplina: " + disciplina);

            System.out.println("\t\tAprovados:");

            for (Aluno aluno : relatorioAlunos.get(disciplina).get(Situacao.APROVADO)) {
                System.out.println("\t\t\t- " + aluno.getNome());
            }

            System.out.println("\t\tEm Recuperação:");

            for (Aluno aluno : relatorioAlunos.get(disciplina).get(Situacao.RECUPERACAO)) {
                System.out.println("\t\t\t- " + aluno.getNome());
            }

            System.out.println("\t\tReprovados:");

            for (Aluno aluno : relatorioAlunos.get(disciplina).get(Situacao.REPROVADO)) {
                System.out.println("\t\t\t- " + aluno.getNome());
            }

            System.out.println();
        }

        testeIgualdade();
    }

    public static void carregarAlunos() {
        Aluno aluno = new Aluno();
        aluno.setNome("Luiz Filipe Mateus Ferreira");
        aluno.setDocumento("20507833457");
        aluno.setNomePai("Manoel Filipe Ferreira");
        aluno.setNomeMae("Marina Liz Yasmin");
        aluno.setCodigoTurma(122);

        Disciplina disciplina = new Disciplina(1, "Disciplina 1");
        disciplina.setNota1(10.0);
        disciplina.setNota2(9.0);
        disciplina.setNota3(6.0);
        disciplina.setNota4(10.0);

        aluno.setDisciplina(disciplina);

        disciplina = new Disciplina(2, "Disciplina 2");
        disciplina.setNota1(8.1);
        disciplina.setNota2(6.5);
        disciplina.setNota3(7);
        disciplina.setNota4(7.6);

        aluno.setDisciplina(disciplina);

        alunos.add(aluno);

        aluno = new Aluno("Maitê Nina Adriana Farias");
        aluno.setDocumento("26686625833");
        aluno.setNomePai("Caleb Henry Bento Farias");
        aluno.setNomeMae("Nina Luana Bruna");
        aluno.setCodigoTurma(136);

        disciplina = new Disciplina(1, "Disciplina 1");
        disciplina.setNota1(8.0);
        disciplina.setNota2(4.0);
        disciplina.setNota3(4.0);
        disciplina.setNota2(9.0);

        aluno.setDisciplina(disciplina);

        alunos.add(aluno);

        aluno = new Aluno("Maria Camila Rezende", "46801815830");
        aluno.setNomeMae("Vitória Luiza");
        aluno.setCodigoTurma(116);

        disciplina = new Disciplina(2, "Disciplina 2", 6.0, 4.0, 8.0, 7.0);

        aluno.setDisciplina(disciplina);

        alunos.add(aluno);

        disciplina = new Disciplina(2, "Disciplina 2", 3.0, 6.0, 5.0, 3.0);

        aluno = new Aluno("Maria Tereza Laura Campos", "44664360029", 103, disciplina);

        alunos.add(aluno);
    }

    public static void carregarRelatorioAlunos() {
        for (Aluno aluno : alunos) {
            for (Disciplina disciplina : aluno.getDisciplina()) {

                if (!relatorioAlunos.containsKey(disciplina.getTitulo())) {

                    relatorioAlunos.put(disciplina.getTitulo(), new HashMap<String, List<Aluno>>());

                    relatorioAlunos.get(disciplina.getTitulo()).put(Situacao.APROVADO, new ArrayList<Aluno>());
                    relatorioAlunos.get(disciplina.getTitulo()).put(Situacao.RECUPERACAO, new ArrayList<Aluno>());
                    relatorioAlunos.get(disciplina.getTitulo()).put(Situacao.REPROVADO, new ArrayList<Aluno>());
                }

                if (disciplina.getSituacao().equals(Situacao.APROVADO)) {
                    relatorioAlunos.get(disciplina.getTitulo()).get(Situacao.APROVADO).add(aluno);
                } else if (disciplina.getSituacao().equals(Situacao.RECUPERACAO)) {
                    relatorioAlunos.get(disciplina.getTitulo()).get(Situacao.RECUPERACAO).add(aluno);
                } else {
                    relatorioAlunos.get(disciplina.getTitulo()).get(Situacao.REPROVADO).add(aluno);
                }
            }
        }
    }

    private static void testeIgualdade() {

        System.out.println("================================================================");

        // Classe abaixo não implementa o equals e hashCode
        Aluno2 aluno1 = new Aluno2("Maria Tereza Laura Campos", "44664360029");
        Aluno2 aluno2 = new Aluno2("Maria Tereza Laura Campos" , "44664360029");
        Aluno2 aluno3 = new Aluno2("Brenda Bruna Vera da Luz", "15579998309");
        Aluno2 aluno4 = aluno2;

        System.out.println("\n# Comparação de Igualdade (equals e hashCode não sobrescrito)\n");

        escreverDadosAluno(aluno1.getNome(), aluno1.getDocumento(), aluno1.hashCode(), 1);
        escreverDadosAluno(aluno2.getNome(), aluno2.getDocumento(), aluno2.hashCode(), 2);

        System.out.println("\t> Aluno 1 = Aluno 2 (Referências diferentes): " + aluno1.equals(aluno2) + "\n");

        escreverDadosAluno(aluno3.getNome(), aluno3.getDocumento(), aluno3.hashCode(), 3);

        System.out.println("\t> Aluno 1 = Aluno 3 (Referências diferentes): " + aluno1.equals(aluno3) + "\n");

        escreverDadosAluno(aluno4.getNome(), aluno4.getDocumento(), aluno4.hashCode(), 4);

        System.out.println("\t> Aluno 4 = Aluno 2 (Referências iguais - Copiado do aluno 2): " + aluno4.equals(aluno2));

        // Classe abaixo implementa o equals e hashCode
        Aluno aluno5 = new Aluno("Maria Tereza Laura Campos", "44664360029", 1);
        Aluno aluno6 = new Aluno("Tânia Giovana Santos" , "44664360029", 2);
        Aluno aluno7 = new Aluno("Brenda Bruna Vera da Luz", "15579998309", 1);
        Aluno aluno8 = aluno5;

        System.out.println("\n# Comparação de Igualdade (equals e hashCode sobrescrito - Diferenciado pelo documento)\n");

        escreverDadosAluno(aluno5.getNome(), aluno5.getDocumento(), aluno5.hashCode(), 5);
        escreverDadosAluno(aluno6.getNome(), aluno6.getDocumento(), aluno6.hashCode(), 6);

        System.out.println("\t> Aluno 5 = Aluno 6 (Referências diferentes): " + aluno5.equals(aluno6) + "\n");

        escreverDadosAluno(aluno7.getNome(), aluno7.getDocumento(), aluno7.hashCode(), 7);

        System.out.println("\t> Aluno 5 = Aluno 7 (Referências diferentes): " + aluno5.equals(aluno7) + "\n");

        escreverDadosAluno(aluno8.getNome(), aluno8.getDocumento(), aluno8.hashCode(), 8);

        System.out.println("\t> Teste de igualdade (Referências iguais - Copiado do aluno 5): " + aluno8.equals(aluno5));
    }

    public static void escreverDadosAluno(String nome, String documento, int hashCode, int idAluno) {
        System.out.println("\tAluno " + idAluno +
                "\n\t\tNome: " + nome +
                "\n\t\tDocumento: " + documento +
                "\n\t\tHasCode: " + hashCode + "\n");
    }
}