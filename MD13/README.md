# Estrutura de Dados

###### Anotações referentes ao módulo 13

Estrutura de dados na programação é como os dados serão estruturados e manipulados.

## Array

- Dados são dispostos em posições
  - Posição iniciada em `0`
  - Quando criado, um array terão as posições sequênciais na memória
- Deve ser tipado: array de um tipo só aceita em suas posições valores daquele tipo.
- Manipulação
  - Criando: `tipo_dado[] nome_array = new tipo_dado[qtd_posicoes];`. Exemplo: `double[] notas = new double[4];`
    - Neste exemplo, as posições vão de 0 a 3
    - Tentar acessar uma posição inexistente, gera a exceção `ArrayIndexOutOfBoundsException`
    - Para saber o tamanho do array: `int tamanho = nome_array.length;`
    - Para criar um array inicializado: `double[] notas = { 8.9, 5.6, 8.1, 6.9 };`
      - Este array inicializado tem 4 posições
  - Atribuindo valor a uma posição: `nome_vetor[posicao] = valor;`. Exemplo: `notas[1] = 9.5;`
  - Lendo valor de uma posição: `variavel = nome_vetor[posicao];`. Exemplo: `double nota = notas[3];`
    - Podem ser usadas estruturas de repetição para leitura de todas as posições. Exemplos:
      - Acesso à posição: `for (int i = 0; i < notas.length; i++) System.out.println(notas[i]);`
      - Sem acesso à posição: `for (double nota : notas) System.out.println(nota);`

> Dica: Para entrada de dados via console, use a classe `Scanner`, que provê diversos métodos para leitura de diferente tipos de dados. Exemplo:
> 
> ~~~java
> import java.util.Scanner;
> 
> public class TestScanner {
>   public static void main(String[] args) {
>       // É aconselhável usar num bloco catch
>       try {
>           
>           // Objeto para ler dados do console
>           Scanner console = new Scanner(System.in);
> 
>           // Lendo uma palavra (não usa espaço)
>           String palavra = console.next();
> 
>           // Lendo uma frase (terminada com ENTER)
>           String frase = console.nextLine();
> 
>           // Para leitura sequencial de dados de diferentes tipos, esvazie o buffer de memória
>           console.nextLine();
> 
>           // Para ler um número inteiro
>           int valorInteiro = console.nextInt();
> 
>           // Para ler um long
>           log valorLong = console.nextLong();
> 
>           // Para ler um valor real (considera a localização da máquina)
>           int valorReal = console.nextDouble();
> 
>           // Para ler um caractere
>           char caractere = (char)System.in.read();
> 
>       } catch(Exception ex) {
>           System.out.println("Erro na entrada de dados");
>       }
>   }
> }
> ~~~

### Método Split de String

- Retorna um array onde em cada posição terá uma parte do texto, que foi quebrado no ponto que coincide com o caractere informado no método
  - O caractere usado como ponto de quebra não estará presente no array.
- Exemplo:
  ~~~java
  public class SplitString {
    public static void main(String[] args) {
        String texto = "Valor 1;Valor 2;Valor 3;Valor 4";
  
        // Array terá 4 posições
        String[] valores = texto.split(";");
  
        // Acessa o "Valor 3"
        String valor = valores[2]; 
    }
  }
  ~~~

### Conversão entre lista e array

- Para converter um array para lista: `List<tipo> list = Arrays.asList(array);`
  - Para usar `Arrays`, necessário importar o pacote `java.utils`
  - Tipo da lista deve ser o mesmo tipo do array
- Para converter uma lista para array: `String[] arr = list.toArray(new String[0]);`
  - Tipo da lista deve ser o mesmo do array

## Matriz

- São chamados de vetores multidimensionais
- É como um array com outro array em suas posições
- Podem existir diversos tipos de vetores multidimensionais, mas o mais comum é o bidimensional, com linhas e colunas
  - Posição das linhas e colunas iniciadas em 0
  - Posição acessada por chave de valores. Exemplo: `vetor[0][0]`. As chaves representam as linhas e colunas, respectivamente.
- Quanto mais dimensões existirem, mais complexa fica a manipulação desse tipo de vetor
- Deve ser tipado
- Manipulação:
  - Criando: `double[][] notas = new double[4][3];`
    - Neste exemplo, o vetor tem 4 linhas e 3 colunas
  - Inserindo informações em uma posição: `notas[2][1] = 5.9;`
  - Lendo informação de uma posição: `double nota = notas[1][2];`
  - Percorrendo uma matriz
    ~~~java
    public class Matriz {
        public static void main(String[] args) {
            double[][] notas = new double[2][4];
    
            notas[0][0] = 5.3;
            notas[0][1] = 6.4;
            notas[0][2] = 8.1;
            notas[0][3] = 6.9;
    
            notas[1][0] = 3.6;
            notas[1][1] = 8.8;
            notas[1][2] = 7.6;
            notas[1][3] = 9.1;
    
            // Acesso direto à posição
            for (int linha = 0; linha < notas.length; linha++) {
                for (int coluna = 0; coluna < notas[linha].length; coluna++) {
                    System.out.println("[" + linha + "][" + coluna + "] = " + notas[linha][coluna]);
                }
            }
    
            // Acesso direto ao valor, sem acesso à posição
            for (double[] linha : notas) {
                for (double nota : linha) {
                    System.out.println(nota);
                }
            }
        }
    }
    ~~~