import javax.swing.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        new Thread(Main::enviarEmails).start();

        new Thread(Main::processarNotaFiscal).start();

        JOptionPane.showMessageDialog(null, "Envio de email em andamento. Você pode continuar acessando outras áreas do sistema. Você será notificado quando o envio de email finalizar.");
    }

    private static void enviarEmails() {
        System.out.println("Iniciando o envio de e-mails...\n");
        String prefixServico = "[EMAIL]";

        for (int i = 0; i < 10; i++) {
            String emailEmProcessamento = "'teste" + (i + 1) + "@teste.com.br'";
            System.out.println(prefixServico + " Processando e-mail " + emailEmProcessamento);

            try {
                Thread.sleep(1500);

                System.out.println(prefixServico + " Iniciando envio do e-mail " + emailEmProcessamento);
                Thread.sleep(1200);
                System.out.println(prefixServico + " E-mail " + emailEmProcessamento + " enviado.");

                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Finalizando o processamento de emails");

        JOptionPane.showMessageDialog(null, "Envio de e-mail finalizado.");
    }

    private static void processarNotaFiscal() {
        System.out.println("Iniciando processamento das notas fiscais\n");
        String prefixServico = "[NFe]";

        for (int i = 0; i < 10; i++) {
            String notaFiscalEmProcessamento = "NFe_000" + (i + 1);
            System.out.println(prefixServico + " Processando " + notaFiscalEmProcessamento);
            Thread threadMoverArquivo = new Thread(moverArquivoNFe(notaFiscalEmProcessamento));

            try {
                System.out.println(prefixServico + " Lendo arquivo " + notaFiscalEmProcessamento + ".pdf");
                Thread.sleep(5000);

                System.out.println(prefixServico + " Processando arquivo " + notaFiscalEmProcessamento + ".pdf");
                Thread.sleep(500);

                System.out.println(prefixServico + " Arquivo " + notaFiscalEmProcessamento + ".pdf processado.");

                Thread.sleep(1000);

                threadMoverArquivo.start();

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        JOptionPane.showMessageDialog(null, "Processamento de notas fiscais finalizado.");
    }

    private static Runnable moverArquivoNFe(String pathArquivo) {
        String prefixServico = "[NFe]";

        return new Runnable() {
            @Override
            public void run() {
                System.out.println(prefixServico + " Movendo arquivo processado " + pathArquivo + ".pdf");

                try {
                    Thread.sleep(2500);

                    System.out.println(prefixServico + " Arquivo " + pathArquivo + ".pdf movido com sucesso");
                } catch (InterruptedException e) {

                    System.out.println(prefixServico + " Erro ao mover o arquivo " + pathArquivo + ".pdf");

                    throw new RuntimeException(e);
                }
            }
        };
    }
}