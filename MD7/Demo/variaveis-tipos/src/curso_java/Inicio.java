package curso_java;

public class Inicio {

	public static void main(String[] args) {
		variaveisTiposPrimitivos();
	}

	public static void variaveisTiposPrimitivos() {
		byte tpByte;

		tpByte = 59;

		System.out.println("Variável tipo byte");
		System.out.println("\t- Tamanho (bytes): " + Byte.BYTES);
		System.out.println("\t- Valor mínimo: " + Byte.MIN_VALUE);
		System.out.println("\t- Valor máximo: " + Byte.MAX_VALUE);
		System.out.println("\t- Valor inicializado: " + tpByte);

		short tpShort = 31012;

		System.out.println("\nVariável tipo short");
		System.out.println("\t- Tamanho (bytes): " + Short.BYTES);
		System.out.println("\t- Valor mínimo: " + Short.MIN_VALUE);
		System.out.println("\t- Valor máximo: " + Short.MAX_VALUE);
		System.out.println("\t- Valor inicializado: " + tpShort);

		int tpInt = 1598456;

		System.out.println("\nVariável tipo int");
		System.out.println("\t- Tamanho (bytes): " + Integer.BYTES);
		System.out.println("\t- Valor mínimo: " + Integer.MIN_VALUE);
		System.out.println("\t- Valor máximo: " + Integer.MAX_VALUE);
		System.out.println("\t- Valo inicializado: " + tpInt);

		long tpLong = 896269L;

		System.out.println("\nVariável tipo long");
		System.out.println("\t- Tamanho (bytes): " + Long.BYTES);
		System.out.println("\t- Valor mínimo: " + Long.MIN_VALUE);
		System.out.println("\t- Valor máximo: " + Long.MAX_VALUE);
		System.out.println("\t- Valor inicializado: " + tpLong);
		
		float tpFloat = 189.53F;
		
		System.out.println("\nVariável tipo float");
		System.out.println("\t- Tamanho (bytes): " + Float.BYTES);
		System.out.println("\t- Precisão: " + Float.PRECISION);
		System.out.println("\t- Valor mínimo expoente: " + Float.MIN_EXPONENT);
		System.out.println("\t- Valor máximo expoente: " + Float.MAX_EXPONENT);
		System.out.println("\t- Valor mínimo normal: " + Float.MIN_NORMAL);
		System.out.println("\t- Valor mínimo: " + Float.MIN_VALUE);
		System.out.println("\t- Valor máximo: " + Float.MAX_VALUE);
		System.out.println("\t- Valor inicializado: " + tpFloat);
		
		double tpDouble = 35981.22659;
		
		System.out.println("\nVariável tipo double");
		System.out.println("\t- Tamanho (bytes): " + Double.BYTES);
		System.out.println("\t- Precisão: " + Double.PRECISION);
		System.out.println("\t- Valor mínimo expoente: " + Double.MIN_EXPONENT);
		System.out.println("\t- Valor máximo expoente: " + Double.MAX_EXPONENT);
		System.out.println("\t- Valor mínimo normal: " + Double.MIN_NORMAL);
		System.out.println("\t- Valor mínimo: " + Double.MIN_VALUE);
		System.out.println("\t- Valor máximo: " + Double.MAX_VALUE);
		System.out.println("\t- Valor inicializado: " + tpDouble);
		
		boolean tpBoolean = true;
		
		System.out.println("\nVariável tipo boolean");
		System.out.println("\t- Valor inicializado: " + tpBoolean);
		
		char tpChar = 'T';
		
		System.out.println("\nVariável tipo char");
		System.out.println("\t- Valor inicializado: " + tpChar);
	}
}
