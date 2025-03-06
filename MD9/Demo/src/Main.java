import jdev.curso.classes.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cadastro de Alunos!\n");

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Luiz Filipe Mateus Ferreira");
        aluno1.setDocumento("20507833457");
        aluno1.setNomePai("Manoel Filipe Ferreira");
        aluno1.setNomeMae("Marina Liz Yasmin");
        aluno1.setCodigoTurma(122);

        Disciplina disciplina = new Disciplina(1, "Disciplina 1");
        disciplina.setNota1(10.0);
        disciplina.setNota2(9.0);
        disciplina.setNota3(6.0);
        disciplina.setNota4(10.0);

        aluno1.setDisciplina(disciplina);;

        System.out.println("#1\n" + aluno1 + "\n");

        Aluno aluno2 = new Aluno("Maitê Nina Adriana Farias");
        aluno2.setDocumento("26686625833");
        aluno2.setNomePai("Caleb Henry Bento Farias");
        aluno2.setNomeMae("Nina Luana Bruna");
        aluno2.setCodigoTurma(136);

        disciplina = new Disciplina(1, "Disciplina 1");
        disciplina.setNota1(8.0);
        disciplina.setNota2(4.0);
        disciplina.setNota3(4.0);
        disciplina.setNota2(9.0);

        aluno2.setDisciplina(disciplina);

        System.out.println("#2\n" + aluno2 + "\n");

        Aluno aluno3 = new Aluno("Maria Camila Rezende", "46801815830");
        aluno3.setNomeMae("Vitória Luiza");
        aluno3.setCodigoTurma(116);

        disciplina = new Disciplina(2, "Disciplina 2", 6.0, 4.0, 8.0, 7.0);

        aluno3.setDisciplina(disciplina);

        System.out.println("#3\n" + aluno3 + "\n");

        disciplina = new Disciplina(2, "Disciplina 2", 3.0, 6.0, 5.0, 3.0);

        Aluno aluno4 = new Aluno("Maria Tereza Laura Campos", "44664360029", 103, disciplina);

        System.out.println("#4\n" + aluno4 + "\n");

        testeIgualdade();
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