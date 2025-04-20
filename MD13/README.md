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
  - Atribuindo valor a uma posição: `nome_vetor[posicao] = valor;`. Exemplo: `notas[1] = 9.5;`
  - Lendo valor de uma posição: `variavel = nome_vetor[posicao];`. Exemplo: `double nota = notas[3];`
    - Podem ser usadas estruturas de repetição para leitura de todas as posições. Exemplo: `for (int i = 0; i < notas.length; i++) System.out.println(notas[i]);`