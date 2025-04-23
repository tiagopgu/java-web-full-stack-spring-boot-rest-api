package services;

import javax.swing.*;

public abstract class BaseService {
    private static String tituloPrograma;

    public static String getTituloPrograma() {
        return getTituloPrograma(null);
    }

    public static String getTituloPrograma(String nomeModulo) {
        return tituloPrograma + (nomeModulo != null && !nomeModulo.isBlank() ? " - " + nomeModulo : "");
    }

    public static void setTituloPrograma(String titulo) {
        tituloPrograma = titulo;
    }

    public static int getQtdInsercao(String message) {
        return getQtdInsercao(message, Integer.MAX_VALUE, null);
    }

    public static int getQtdInsercao(String message, int maxInsercao) {
        return getQtdInsercao(message, maxInsercao, null);
    }

    public static int getQtdInsercao(String message, String nomeModulo) {
        return getQtdInsercao(message, Integer.MAX_VALUE, nomeModulo);
    }

    public static int getQtdInsercao(String message, int maxInsercao, String nomeModulo) {
        int qtdInsercao = -1;
        String msgErro = "Entrada inválida: informe um número maior que 0" + (maxInsercao != Integer.MAX_VALUE ? " e menor ou igual " + maxInsercao : "");
        String titErro = "Quantidade Inválida";

        do {
            try {
                String input = JOptionPane.showInputDialog(null, message, getTituloPrograma(nomeModulo), JOptionPane.QUESTION_MESSAGE);

                if (input == null)
                    System.exit(0);

                qtdInsercao = Integer.parseInt(input);

                if (!validarQtdInsercao(qtdInsercao, maxInsercao))
                    JOptionPane.showMessageDialog(null, msgErro, titErro, JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, msgErro, titErro, JOptionPane.ERROR_MESSAGE);
            }
        } while (!validarQtdInsercao(qtdInsercao, maxInsercao));

        return qtdInsercao;
    }

    private static boolean validarQtdInsercao(int valor, int maxInsercao) {
        return valor > 0 && valor <= maxInsercao;
    }
}
