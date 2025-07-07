public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando o envio de e-mails...");

        for (int i = 0; i < 10; i++) {
            System.out.println("Processando e-mail 'teste" + (i + 1) + "@teste.com.br'");

            try {
                Thread.sleep(1500);

                System.out.println("\t> Iniciando envio do e-mail...");
                Thread.sleep(1500);
                System.out.println("\t> E-mail enviado.\n");

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finalizando o processamento de emails");
    }
}