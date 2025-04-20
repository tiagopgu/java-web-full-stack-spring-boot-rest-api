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