package domain.validations;

public abstract class AlunoValidation {
    public static class Nome {

        public static boolean validar(String nome) {
            return nome != null && !nome.isBlank() && nome.length() >= 2;
        }

        public static String getMessageValidation() {
            return "Informe o nome do aluno com pelo menos dois caracteres";
        }
    }

    public static class Disciplina {
        public static boolean validar(domain.Disciplina disciplina) {
            return disciplina != null;
        }

        public static String getMessageValidation() {
            return "Deve ser informada a disciplina";
        }

        public static boolean validarLista(domain.Disciplina[] disciplinas) {
            return disciplinas != null;
        }

        public static String getMessageValidationLista() {
            return "Lista de disciplina não inicializada";
        }
    }
}
