public class Inicio {
    private static float valorArrendamento = .25F;

    public static void main(String[] args) {
        testeEstruturaDecisao();
    }

    public static void testeEstruturaDecisao() {
        System.out.println("Teste de Estrutura de Decisão\n");

        escreverDadosAluno("Fulano de Tal", calcularMediaAluno(9.5F, 6.9F, 5.1F, 7.3F));

        escreverDadosAluno("Ciclana Alves", calcularMediaAluno(8.0F, 6.9F, 5.1F, 7.3F));

        escreverDadosAluno("Raul Grapher", calcularMediaAluno(8.0F, 6.9F, 5.1F, 4.6F));

        escreverDadosAluno("Juliana Mendes", calcularMediaAluno(5.0F, 5.0F, 5.1F, 4.1F));

        escreverDadosAluno("Monique Silva", calcularMediaAluno(5.0F, 3.8F, 5.1F, 4.1F));
    }

    public static float calcularMediaAluno(float nota1, float nota2, float nota3, float nota4) {
        return (nota1 + nota2 + nota3 + nota4) / 4;
    }

    public static void escreverDadosAluno(String nomeAluno, float media) {
        System.out.println("Aluno: " + nomeAluno);
        System.out.println("Média: " + media);
        System.out.println("Situação: " + retornaSituacaoAluno(media));
        System.out.println();
    }

    public static String retornaSituacaoAluno(float media) {
        String situacao = "";

        if (media >= 7.0F) {
            situacao = "Aprovado";
        } else if (media >= 5.0F) {
            media = media + valorArrendamento;

            if (media >= 7.0F) {
                situacao = "Aprovado (Arredondamento)";
            } else {
                situacao = "Em Recuperação";
            }
        } else {
            media = media + valorArrendamento;

            if (media >= 5.0F) {
                situacao = "Em Recuperação (Arredondamento)";
            } else {
                situacao = "Reprovado";
            }
        }

        return situacao;
    }
}
