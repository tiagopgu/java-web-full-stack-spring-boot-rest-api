import java.security.cert.Extension;

public class Main {
    public static void main(String[] args) {
        testeSemExcessao();
        System.out.println();

        testeExcecaoTratada();
        System.out.println();

        testeExcecaoTratada2();
        System.out.println();

        testeMultiplaExcecaoTratada();
        System.out.println();

        testeExcecaoPersonalizada();
        System.out.println();

        testeExcecaoNaoTratada();

        System.out.println("Testes de exceção finalizados");
    }

    private static void testeSemExcessao() {
        System.out.println("> Iniciando teste sem exceção...\n");

        try {
            int resultado = realizarDivisao(9, 3);

            System.out.println("Resultado: " + resultado);
        } catch (Exception ex) {
            escreverStackTracer(ex);
        } finally {
            System.out.println("\nBloco finally executado...");
        }
    }

    private static void testeExcecaoTratada() {
        try {
            System.out.println("> Iniciando teste de exceção tratada...\n");

            int resultado = realizarDivisao(9, 0);

            System.out.println("Resultado tratado: " + resultado);
        } catch (Exception ex) {
            System.out.println("Erro ao realizar operação:");

            // Visualização do stack trace pode ser personalizada
            escreverStackTracer(ex);
        }
        finally {
            System.out.println("\nBloco finally executado...");
        }
    }

    private static void testeExcecaoTratada2() {
        try {
            System.out.println("> Iniciando segundo teste de exceção tratada...\n");

            int resultado = realizarDivisao(9, 0);

            System.out.println("Resultado tratado: " + resultado);
        } catch (Exception ex) {
            System.out.println("Erro ao realizar operação");
            ex.printStackTrace();
        }
    }

    private static void testeMultiplaExcecaoTratada() {
        try {
            System.out.println("> Iniciando teste de múltipla exceção tratada...\n");

            String valorEntrada = "123O";
            int numero = Integer.parseInt(valorEntrada);
            int resultado = realizarDivisao(9, 0) + numero;

            System.out.println("Resultado tratado: " + resultado);
        } catch (NumberFormatException ex) {
            // Tratando exceção específica de formato inválido
            System.out.println("Erro de formato: ");

            escreverStackTracer(ex);
        }
        catch(Exception ex) {
            // Tratando qualquer exceção não tratada anteriormente
            System.out.println("Erro inesperado: ");

            escreverStackTracer(ex);
        }
    }

    private static void testeExcecaoPersonalizada() {
        System.out.println("> Iniciando teste de lançamento de exceção personalizada...\n");

        try {
            int resultado = realizarDivisao2(9, 0);

            System.out.println("Resultado personalizado: " + resultado);
        } catch (CursoException ex) {
            System.out.println("Erro na operação: ");

            escreverStackTracer(ex);
        }
        catch(Exception ex) {
            System.out.println("Erro inesperado: ");

            escreverStackTracer(ex);
        }
    }

    private static void testeExcecaoNaoTratada() {
        System.out.println("> Iniciando teste de exceção não tratada...\n");

        int resultado = realizarDivisao(9, 0);

        System.out.println("Resultado não tratado: " + resultado);
    }

    private static int realizarDivisao(int dividendo, int divisor) {
        return dividendo / divisor;
    }

    private static int realizarDivisao2(int dividendo, int divisor) throws CursoException {
        if (divisor == 0)
            throw new CursoException("Não é possível realizar divisão por 0");

        return dividendo / divisor;
    }

    private static void escreverStackTracer(Exception ex) {
        System.out.println("\n\t" + ex.getMessage());

        for (StackTraceElement message : ex.getStackTrace()) {
            System.out.println("\t\t" + message);
        }
    }
}