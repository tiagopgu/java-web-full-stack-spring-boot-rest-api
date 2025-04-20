import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nEstudos dos Arrays\n");

        double[] notas = new double[getTamanhoArray()];

        System.out.println();

        for (int i = 0; i < notas.length; i++) {
            notas[i] = getNota(i + 1);
        }

        System.out.println("\nNotas:");

        for (int i = 0; i < notas.length; i++)
            System.out.println("\t" + (i + 1) + "ª nota = " + notas[i]);

        System.out.println("\n\tMédia: " + getMedia(notas));
        System.out.println("\tMenor nota: " + getMenorNota(notas));
        System.out.println("\tMaior nota: " + getMaiorNota(notas));
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

    private static double getMaiorNota(double[] notas) {
        double maiorNota = -1; // Pela regra, nota não pode ser menor que 0

        for (double nota : notas)
            maiorNota = nota > maiorNota ? nota : maiorNota;

        return maiorNota;
    }

    private static double getMenorNota(double[] notas) {
        double menorNota = 11; // Pela regra, nota não pode ser maior que 10

        for (double nota : notas)
            menorNota = nota < menorNota ? nota : menorNota;

        return menorNota;
    }
}