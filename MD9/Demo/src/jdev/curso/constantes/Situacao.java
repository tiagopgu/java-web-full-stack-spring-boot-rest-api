package jdev.curso.constantes;

public class Situacao {
    public static String APROVADO = "AP";
    public static String REPROVADO = "RP";
    public static String RECUPERACAO = "RC";

    public static String getDescricao(String situacao) {
        return switch (situacao) {
            case "AP" -> "Aprovado";
            case "RP" -> "Reprovado";
            case "RC" -> "Em Recuperação";
            default -> "Situação Inválida";
        };
    }
}
