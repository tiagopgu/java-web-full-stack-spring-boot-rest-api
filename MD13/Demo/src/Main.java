public class Main {
    public static void main(String[] args) {
        System.out.println("\nEstudos dos Arrays\n");

        double[] notas = new double[4];

        notas[0] = 8.6;
        notas[1] = 7.3;
        notas[2] = 9.9;
        notas[3] = 6.9;

        System.out.println("Primeira nota: " + notas[0] + "\n");

        for (int i = 0; i < notas.length; i++)
            System.out.println("Nota " + (i + 1) + " = " + notas[i]);
    }
}