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

        System.out.println("#1\n" + aluno1.compilarDados() + "\n");

        Aluno aluno2 = new Aluno("Maitê Nina Adriana Farias");
        aluno2.setDocumento("26686625833");
        aluno2.setNomePai("Caleb Henry Bento Farias");
        aluno2.setNomeMae("Nina Luana Bruna");
        aluno2.setCodigoTurma(136);

        System.out.println("#2\n" + aluno2.compilarDados() + "\n");

        Aluno aluno3 = new Aluno("Maria Camila Rezende", "46801815830");
        aluno3.setNomeMae("Vitória Luiza");
        aluno3.setCodigoTurma(116);

        System.out.println("#3\n" + aluno3.compilarDados() + "\n");

        Aluno aluno4 = new Aluno("Maria Tereza Laura Campos", "44664360029", 103);

        System.out.println("#4\n" + aluno4.compilarDados());
    }
}