# Operações Lógicas, Condicionais e Relacionais

###### _Anotações referentes ao módulo 8 do curso_

## Operadores Relacionais

- Compara dois valores, retornando `true` ou `false` conforme o resultado da comparação
- Operadores: `==` (igual), `!=` (diferente), `>` (maior), `<` (menor), `>=` (maior ou igual), `<=` (menor ou igual)
- Exemplo: `String resultado = idade >= 18 && idade < 30 ? "Idade permitida" : "Idade não permitida";`

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/f31591a1653bd4cec5671e80ee598f4cd7099e2e/MD8/Demo/src/Inicio.java#L15)

## Estrutura de Decisão

- Executa um bloco de código com base em um valor lógico
- Exemplo:

~~~java
float media = 7.1F;

if (media >= 7F) { // Entra no bloco se verdade
    System.out.println("Aprovado");    
} else if (media >= 5F) { // Podem existir mais de uma condição, caso a anterior falhe
    System.out.println("Em Recuperação");
} else { // Pode existir um caso padrão, caso todos os anteriores falhe
    media = media + .25F;
    
    // Pode ser aninhado dentro de outro if/else
    if (media >= 5F) {
        System.out.println("Em Recuperação");
    } else {
        System.out.println("Reprovado");
    }
}
~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/74cdec436f423520b8a8933aea810158b5172a39/MD8/Demo/src/Inicio.java#L5)

### Operador ternário

- Retornar um valor com base em uma decisão
  - Valores retornados quando `true` ou `false` devem ser do mesmo tipo
- Substitui a estrutura `if/else` quando precisa retornar um valor com base em uma condição
- Pode ser aninhado, porém, é desaconselhável por dificultar a leitura do código
- Sintaxe: `tipo_dado resultado = condicao_logica ? retorno_quando_true : retorno_quando_false;`

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/454fb1878aad516a7784992d1f4e666da79fbd38/MD8/Demo/src/Inicio.java#L7)

## Estrutura Seleção

- Executa um bloco de código com base em um valor testado
- Pode substituir o uso de `if/else if/else`
- Sintaxe:

  ~~~java
  /* Estrutura abaixo permite executar um bloco de código */
  switch (valor_testar) {
    case valor_1:
        // Executa um bloco de código
        break; // Finaliza o teste de valor e sai da estrutura
    case valor_2:
        // Executa um bloco de código
        break; // Finaliza o teste de valor e sai da estrutura
    case valor_3:
    case valor_4:
        // Executa um bloco de código para qualquer um dos dois casos anteriores
        break; // Finaliza o teste de valor e sai da estrutura
    default:
        // Executa um bloco de código para quando nenhum caso anterior corresponder ao valor
        break; // Sai da estrutura
  }
  
  /* Estrura abaixo retorna um valor com base no valor testado. Retorno deve ser do mesmo tipo*/
  String retorno = switch(valor_testar) {
    case valor_1 -> "Valor Retorno 1";
    case valor_2 -> "Valor Retorno 2";
    case valor_3 -> "Valor Retorno 3";
    default -> "Valor Retorno padrão";
  };
  ~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/120f70818852728443f984ccbf81a79395d17da3/MD8/Demo/src/Inicio.java#L11)

## Estrutura de Repetição

- Executa repetidamente um bloco de código com base em uma condição lógica
- Deve ter uma condição de parada para não entrar em loop infinito
- Comumente chamado de laço de repetição

### Teste no início

- Testa a condição lógica no início do laço
- Repete o bloco de código enquanto condição for verdadeira
- Sintaxe:

  ~~~java
  while (condicao_logica) {
    bloco_de_codigo;
    alteracao_para_permitir_que_condicao_logica_falhe_em_algum_momento_para_encerrar_laco;
  }
  ~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/84ff032434db3b98d13461163b0dd771f28f93c0/MD8/Demo/src/Inicio.java#L187)

### Teste no final

- Testa a condição lógica no final do laço
- Repete o bloco de código enquanto a condição for verdadeira
- Bloco de código é executado ao menos uma vez
- Sintaxe:
  
  ~~~java
  do {
    bloco_de_codigo;
    alteracao_para_permitir_que_condicao_logica_falhe_em_algum_momento_para_encerrar_laco;
  } while (condicao_logica)
  ~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/84ff032434db3b98d13461163b0dd771f28f93c0/MD8/Demo/src/Inicio.java#L200)

### Total de repetição conhecida

- Estrutura onde a quantidade de repetição é conhecida
- Repete enquanto condição verdadeira
- Substitui as estruturas de repetições anteriores em muitas situações
- Após cada execução, o contador é atualizado e a condição validada
- Sintaxe:

  ~~~java
  for (declaracao_e_inicializacao_contador; condicao_parada; atualizacao_contador) {
    bloco_codigo;
  }
  ~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/6659186c5cebb7b0a990da311d677849a80f06b9/MD8/Demo/src/Inicio.java#L211)

### Forçando parada

- Usar a palavra-chave `break` permite a saída do laço antes da condição se tornar `false`
- Sintaxe:

  ~~~java
  for (declaracao_e_inicializacao_contador; condicao_parada; atualizacao_contador) {
    codigo;
  
    if (condicao) {
        codigo;
        break; // força a saída antes da condicao_parada ser false
    }
  
    codigo;
  }
  ~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/989b47703c4af787f77bf68ea8760a999f6099a3/MD8/Demo/src/Inicio.java#L220)

### Forçando avanço da iteração

- Usar `continue` força o avanço para a próxima iteração do laço, não executando código após o continue
- Sintaxe

  ~~~java
  for (declaracao_e_inicializacao_contador; condicao_parada; atualizacao_contador) {
    codigo;
  
    if (condicao) {
        codigo;
        continue; // Ignora código subsequente e avança para a próxima iteração
    }
  
    codigo;
  }
  ~~~