package curso.java;

public class Inicio {

	public static void main(String[] args) {
		variaveisTiposPrimitivos();
		
		System.out.println();		
		
		testeTexto();

		System.out.println();

		testeConcatenacao();

		System.out.println();

		testeOperacoesMatematicas();
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

	public static void testeTexto() {
		char sexo = 'M';
		String nomeCompleto = "Tiago Pires Guimarães";
		
		System.out.println("Tipos de texto");
		
		System.out.println("\tNome: " + nomeCompleto +
				"\n\tSexo: " + sexo);
	}

	public static void testeConcatenacao() {
		String nome = "Fulano de Tal";
		char sexo = 'M';
		String cidade = "Brasília";
		String uf = "DF";
		int idade = 30;
		float altura = 1.68F;

		// Juntando texto com a concatenação
		String saida = "Meu nome é " + nome + " (sexo " + sexo + ") e tenho " + idade + " anos. Tenho " + altura + " de altura. Sou de " + cidade + "-" + uf + ".";

		System.out.println("Teste de concatenação");
		System.out.println("\t" + saida);
	}

	public static void testeOperacoesMatematicas() {
		int numero1 = 15;
		int numero2 = 23;
		long numero3 = 5L;
		double numero4 = 5.0;

		System.out.println("Operações matemáticas");

		//int resultado1 = numero1 + numero3; // Erro
		long resultado1 = numero1 + numero3;

		//int resultado2 = numero1 + numero4; // Erro
		double resultado2 = numero1 + numero4;

		System.out.println("\tSoma de inteiros: " + numero1 + " + " + numero3 + " = " + resultado1);
		System.out.println("\tSoma de inteiro e double: " + numero1 + " + " + numero4 + " = " + resultado2);

		System.out.println("\n\tSubtração de inteiros: " + numero1 + " - " + numero3 + " = " + (numero1 - numero3));
		System.out.println("\tSubtração de inteiro e double: " + numero1 + " - " + numero4 + " = " + (numero1 - numero4));

		System.out.println("\n\tMultiplicação de inteiros: " + numero1 + " * " + numero3 + " = " + (numero1 * numero3));
		System.out.println("\tMultiplicação de inteiro e double: " + numero1 + " * " + numero4 + " = " + (numero1 * numero4));

		long resultado3 = ((numero1 + numero2) / numero3);

		//long resultado4 = ((numero1 + numero2) / numero4); // Erro
		double resultado4 = ((numero1 + numero2) / numero4);

		System.out.println("\n\tDivisão inteira: " + "((" + numero1 + " + " + numero2 + ")" + " / " + numero3 + ")" + " = " + resultado3);
		System.out.println("\tDivisão inteira e double: " + "((" + numero1 + " + " + numero2 + ")" + " / " + numero4 + ")" + " = " + resultado4);

		System.out.println("\n\tResto da divisão: " + "((" + numero1 + " + " + numero2 + ")" + " % " + numero3 + ")" + " = " + ((numero1 + numero2) % numero3));
		System.out.println("\tResto da divisão de inteiro e double: " + "((" + numero1 + " + " + numero2 + ")" + " % " + numero4 + ")" + " = " + ((numero1 + numero2) % numero4));
	}
}
