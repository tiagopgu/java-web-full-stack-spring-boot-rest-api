import javax.swing.*;

public class Main {
    private static float VALOR_ARRENDAMENTO = 0.25F;

    public static void main(String[] args) {
        String nome, situacao;
        float nota1, nota2, nota3, nota4, media;
        boolean continuarCalculos = false;

        do {
            nome = obterNomeAluno();

            nota1 = obterNota(1);
            nota2 = obterNota(2);
            nota3 = obterNota(3);
            nota4 = obterNota(4);

            media = (nota1 + nota2 + nota3 + nota4) / 4;
            situacao = retornarSituacaoAluno(media);

            JOptionPane.showMessageDialog(null, "Aluno: " + nome +
                    "\nMédia: " + media +
                    "\nSituação: " + situacao);

            continuarCalculos = JOptionPane.showConfirmDialog(null, "Deseja realizar um novo cálculo?") == JOptionPane.YES_OPTION;

        } while (continuarCalculos);
    }

    private static String obterNomeAluno() {
        String nome = null;

        while (nome == null || nome.isBlank()) {
            nome = JOptionPane.showInputDialog(null, "Informe o nome do aluno");

            if (nome == null || nome.isBlank()) {
                JOptionPane.showMessageDialog(null, "Nome deve ser informado");
                continue;
            }

            if (nome.length() < 2) {
                JOptionPane.showMessageDialog(null, "Nome precisa ter no mínimo 2 caracteres");
                nome = "";
            }
        }

        return nome;
    }

    private static float obterNota(int bimestre) {
        float nota = -1F;

        while (nota < 0 || nota > 10) {
            nota = Float.parseFloat(JOptionPane.showInputDialog(null, "Informe a nota do " + bimestre + "º bimestre"));

            if (nota < 0 || nota > 10) {
                JOptionPane.showMessageDialog(null, "A nota deve estar entre 0 e 10");
            }
        }

        return nota;
    }

    private static String retornarSituacaoAluno(float media) {
        float mediaArredondada = media + VALOR_ARRENDAMENTO;

        if (media >= 7 || mediaArredondada >= 7)
            return "Aprovado";

        if (media >= 5 || mediaArredondada >= 5)
            return "Em Recuperação";

        return "Reprovado";
    }
}