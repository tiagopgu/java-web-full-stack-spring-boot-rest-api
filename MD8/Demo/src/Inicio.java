public class Inicio {
    private static float valorArrendamento = .25F;

    public static void main(String[] args) {
        testeEstruturaDecisao();

        testeOperadorTernario();

        System.out.println();

        testeEstruturaSelecao();

        System.out.println();

        testeOperadoresRelacionais();

        System.out.println();

        testeEstruturaRepeticao();

        System.out.println();
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

    public static void testeOperadorTernario() {
        boolean ativo = true;

        System.out.println("Teste Operador Ternário\n");

        System.out.println("Seu acesso está " + (ativo ? "liberado" : "bloqueado"));

        int mes = 5;

        System.out.println("Você está no " + (mes <= 6 ? "1º" : "2º") + " semestre do ano.");

        String situacao = ativo && mes >= 6 ? "Cadastro liberado" : "Ainda não completou o prazo para cadastro";

        System.out.println(situacao);
    }

    public static void testeEstruturaSelecao() {
        System.out.println("Teste Estrutura Seleção\n");

        executarOperacaoSintetizador(1);
        executarOperacaoSintetizador(2);
        executarOperacaoSintetizador(3);
        executarOperacaoSintetizador(4);
        executarOperacaoSintetizador(5);
        executarOperacaoSintetizador(6);
        executarOperacaoSintetizador(7);
    }

    public static void executarOperacaoSintetizador(int diaSemana) {
        System.out.print("Iniciando operação do dia\n");
        System.out.println(retornarDescricaoDiaSemana(diaSemana) + "\n");

        switch (diaSemana) {
            case 1:
                System.out.println("\tIniciando sistema de abastecimento...");
                System.out.println("\tAbastecimento em 50%...");
                System.out.println("\tAbastecimento em 90%...");
                System.out.println("\tAbastecimento finalizado.\n");
                break;
            case 2:
                System.out.println("\tIniciando coleta de insumos...");
                System.out.println("\tColeta em 30%...");
                System.out.println("\tColeta em 50%...");
                System.out.println("\tColeta em 80%...");
                System.out.println("\tColeta finalizada.\n");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("\tIniciando Sintetização...");
                System.out.println("\t10 materiais sintetizados...");
                System.out.println("\t15 materiais sintetizados...");
                System.out.println("\t150 materiais sintetizados...");
                System.out.println("\tSíntese finalizada. Entrando em modo de resfriamento.\n");
                break;
            case 6:
                System.out.println("\tIniciando despacho de itens...");
                System.out.println("\t10 itens despachados...");
                System.out.println("\t30 itens despachados...");
                System.out.println("\t60 itens despachados...");
                System.out.println("\tDespacho de itens finalizados.\n");
                break;
            case 7:
                System.out.println("\tIniciando sistema de limpeza...");
                System.out.println("\tLimpeza em 10%...");
                System.out.println("\tLimpeza em 30%...");
                System.out.println("\tLimpeza em 70%...");
                System.out.println("\tLimpeza finalizada.\n");
                break;
            default:
                System.out.println("Erro de sistema: dia inválido");
                break;
        }
    }

    public static String retornarDescricaoDiaSemana(int diaSemana) {
        return switch(diaSemana) {
            case 1 -> "Domingo";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            case 7 -> "Sábado";
            default -> "Dia Inválido";
        };
    }

    public static void testeOperadoresRelacionais() {
        int valor1 = 50;
        int valor2 = 35;

        System.out.println("Teste de Operadores Relacionais\n");

        System.out.println("Valores de teste:");
        System.out.println("\tValor 1 = " + valor1);
        System.out.println("\tValor 2 = " + valor2 + "\n");

        System.out.println("\t" + (valor1 == valor2 ? "Valor 1 é igual ao valor 2" : "Valor 1 é diferente do valor 2"));
        System.out.println("\t" + (valor1 != valor2 ? "Valor 1 é diferente do valor 2" : "Valor 1 é igual ao valor 2") + "\n");

        System.out.println("\t" + (valor1 > valor2 ? "Valor 1 é maior que o valor 2" : "Valor 1 não é maior que o valor 2"));
        System.out.println("\t" + (valor1 >= valor2 ? "Valor 1 é maior ou igual ao valor 2" : "Valor 1 é menor que o valor 2") + "\n");

        System.out.println("\t" + (valor1 < valor2 ? "Valor 1 é menor que o valor 2" : "Valor 1 não é menor que o valor 2"));
        System.out.println("\t" + (valor1 <= valor2 ? "Valor 1 é menor ou igual ao valor 2" : "Valor 1 é maior que o valor 2"));
    }

    public static void testeEstruturaRepeticao() {

        System.out.println("Teste de Estruturas de Repetição\n");

        System.out.print("\tTeste While: ");

        int contador = 0;
        int limite = 50;
        String separador = "";

        while (contador <= limite) {
            System.out.print(separador + contador);

            contador++;
            separador = ", ";
        }

        System.out.print("\n\tTeste do..while: ");

        contador = 0;
        separador = "";

        do {
            System.out.print(separador + contador);
            contador++;
            separador = ", ";
        } while (contador <= limite);

        System.out.print("\n\tTeste for: ");

        separador = "";

        for(contador = 0; contador <= limite; contador++) {
            System.out.print(separador + contador);
            separador = ", ";
        }

        System.out.print("\n\tTeste break: ");

        separador = "";

        for(contador = 0; contador <= limite; contador++) {
            System.out.print(separador + contador);

            if (contador >= 30 && contador % 7 == 0) {
                System.out.print("... encontrei um número maior que 30 e divisível por 7 ...");
                break;
            }

            separador = ", ";
        }
    }
}
