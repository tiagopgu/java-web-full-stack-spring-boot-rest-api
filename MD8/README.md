# Operações Lógicas, Condicionais e Relacionais

###### _Anotações referentes ao módulo 8 do curso_

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