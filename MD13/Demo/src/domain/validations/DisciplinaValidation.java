package domain.validations;

public abstract class DisciplinaValidation {

    public static class Nome {
        public static boolean validar(String nome) {
            return nome != null && !nome.isBlank();
        }

        public static String getMessageValidaton() {
            return "Nome da disciplina deve ser informado";
        }
    }

    public static class Nota {
        public static double MIN_NOTA = 0.0;
        public static double MAX_NOTA = 10.0;

        public static boolean validarNota(double nota) {
            return nota >= MIN_NOTA && nota <= MAX_NOTA;
        }

        public static String getMessageValidation() {
            return "Nota deve estar entre " + MIN_NOTA + " e " + MAX_NOTA;
        }

        public static boolean validarNotas(double[] notas) {
            if (notas == null)
                return false;

            for (double nota : notas)
                if (!validarNota(nota))
                    return false;

            return true;
        }

        public static boolean validarNotas(double[][] semestresNotas) {
            if (semestresNotas == null)
                return false;

            for (double[] notas : semestresNotas)
                    if (!validarNotas(notas))
                        return false;
            
            return true;
        }

        public static String getMessageValidationNotas() {
            return "Lista de notas vazia ou com notas que não estejam entre " + MIN_NOTA + " e " + MAX_NOTA;
        }
    }
}
