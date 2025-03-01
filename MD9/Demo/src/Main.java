import jdev.curso.classes.Aluno;

public class Main {
    public static void main(String[] args) {
        System.out.println("Cadastro de Alunos!\n");

        Aluno aluno1 = new Aluno();
        aluno1.setNome("Luiz Filipe Mateus Ferreira");
        aluno1.setDocumento("20507833457");
        aluno1.setNomePai("Manoel Filipe Ferreira");
        aluno1.setNomeMae("Marina Liz Yasmin");
        aluno1.setCodigoTurma(122);
        aluno1.setNota1(10.0);
        aluno1.setNota2(9.0);
        aluno1.setNota3(6.0);
        aluno1.setNota4(10.0);

        System.out.println("#1\n" + aluno1.compilarDados() + "\n");

        Aluno aluno2 = new Aluno("Maitê Nina Adriana Farias");
        aluno2.setDocumento("26686625833");
        aluno2.setNomePai("Caleb Henry Bento Farias");
        aluno2.setNomeMae("Nina Luana Bruna");
        aluno2.setCodigoTurma(136);
        aluno2.setNota1(8.0);
        aluno2.setNota2(4.0);
        aluno2.setNota3(4.0);
        aluno2.setNota2(9.0);

        System.out.println("#2\n" + aluno2.compilarDados() + "\n");

        Aluno aluno3 = new Aluno("Maria Camila Rezende", "46801815830");
        aluno3.setNomeMae("Vitória Luiza");
        aluno3.setCodigoTurma(116);
        aluno3.setNota1(6.0);
        aluno3.setNota2(4.0);
        aluno3.setNota3(8.0);
        aluno3.setNota4(7.0);

        System.out.println("#3\n" + aluno3.compilarDados() + "\n");

        Aluno aluno4 = new Aluno("Maria Tereza Laura Campos", "44664360029", 103);
        aluno4.setNota1(3.0);
        aluno4.setNota2(9.0);
        aluno4.setNota3(7.0);
        aluno4.setNota4(3.0);

        System.out.println("#4\n" + aluno4.compilarDados());
    }
}