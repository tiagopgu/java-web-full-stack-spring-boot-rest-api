import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEstudos dos Arrays\n");

        double[] notas = new double[getTamanhoArray()];

        System.out.println();

        for (int i = 0; i < notas.length; i++) {
            notas[i] = getNota(i + 1);
        }

        System.out.println("\nPrimeira nota: " + notas[0] + "\n");

        for (int i = 0; i < notas.length; i++)
            System.out.println("Nota " + (i + 1) + " = " + notas[i]);

        System.out.println("\nMédia: " + getMedia(notas));
    }

    private static int getTamanhoArray() {
        Scanner console = new Scanner(System.in);
        int valor = 0;
        String msgErro = "Valor inválido: deve ser informado um número maior que 0.";

        do {
            System.out.print("Informe a quantidade de notas: ");

            try {
                valor = console.nextInt();

                if (valor <= 0)
                    System.out.println(msgErro + "\n");
            } catch (Exception ex) {
                System.out.println(msgErro + "\n");
            }

            console.nextLine();
        } while (valor <= 0);

        return valor;
    }

    private static double getNota(int pos) {
        Scanner console = new Scanner(System.in);
        double nota = -1;
        String msgErro = "Nota inválida: deve estar entre 0 e 10";

        do {
            System.out.print("Informe a " + pos + "ª nota: ");

            try {
                nota = console.nextDouble();

                if (nota < 0 || nota > 10)
                    System.out.println(msgErro + "\n");
            } catch (Exception ex) {
                System.out.println(msgErro + "\n");
            }

            console.nextLine();
        } while(nota < 0 || nota > 10);

        return nota;
    }

    private static double getMedia(double[] notas) {
        double notaTotal = 0;

        for (double nota : notas)
            notaTotal += nota;

        return notaTotal / notas.length;
    }
}