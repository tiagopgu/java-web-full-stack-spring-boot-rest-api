import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        new Thread() {
            public void run() {
                System.out.println("Iniciando o envio de e-mails...");

                enviarEmails();

                System.out.println("Finalizando o processamento de emails");

                JOptionPane.showMessageDialog(null, "Envio de e-mail finalizado.");
            }
        }.start();

        JOptionPane.showMessageDialog(null, "Envio de email em andamento. Você pode continuar acessando outras áreas do sistema. Você será notificado quando o envio de email finalizar.");
    }

    public static void enviarEmails() {
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
    }
}