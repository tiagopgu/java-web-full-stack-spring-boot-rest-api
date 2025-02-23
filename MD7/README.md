# Tipos de Dados do Java

###### _Anotações referentes ao módulo 7 do curso_

## Tipagem no Java

- O Java é uma linguagem tipada
- Variáveis devem ter um tipo ao serem definidas

## Variáveis

- Cria um espaço na memória para guardar um dado
- Valor atribuído pode ser alterado durante a execução da aplicação
- Para declarar uma variável: `tipo_dado nome_variavel;`. Exemplo: `int idade;`
- Toda variável deve ser inicializada antes do seu uso. Exemplo: `idade = 35;`
- É possível inicializar a variável na sua criação. Exemplo: `int idade = 35;`
- Podem ser declaradas variáveis do mesmo tipo no mesmo comando. Exemplo: `int num1, num2, soma;`
- Não pode ser usada palavras reservadas como nome de variável. Algumas palavras reservadas: `class`, `package`, `import`, `private`, `protected`, `public`, `super`, `this`, `byte`, `boolean`
- Possui um escopo, que diz onde ela pode ser usada na aplicação:

  ~~~java
  class Inicio {
  
    // As variáveis abaixo possuem escopo global: é acessível em qualquer lugar da classe
    static int num1 = 10;
    static int num2 = 5;
  
    public static void main(String[] args) {
        // Esta variável possue escopo local: é acessível somente dentro desse método
        String saida;
  
        saida = num1 + " + " + num2 + " = " + Soma();
  
        System.out.println(saida);
    }
  
    public static int Soma() {
        // Esta variável possui escopo local: é acessível somente dentro desse método
        int resultado;
  
        resultado = num1 + num2;
  
        return resultado;
    }
  }
  ~~~

## Tipos primitivos

São os tipos mais básicos e usuais de uma linguagem de programação

### Tipos numéricos integrais

- **byte**: aceita valores na faixa de -128 a 127 (1 byte)
- **short**: aceita valores na faixa de -32768 a 32767 (2 bytes)
- **int**: aceita valores de -2<sup>31</sup> a 2<sup>31</sup> - 1 (4 bytes)
- **long**: aceita valores de -2<sup>63</sup> a 2<sup>63</sup>  - 1 (8 bytes)
  - Valores atribuídos devem terminar com o prefixo `L`. Exemplo: `long numero = 56515990L;`

> Valor padrão de inicialização: 0
> 
> A ordem acima indica que um valor de um tipo cabe dentro do próximo tipo, mas não o contrário. Ou seja: um int cabe em um long, mas não o contrário
> 
> Em operações matemáticas, o resultado será sempre o do maior tipo envolvido. Ou seja: na soma de um int com um long, o resultado será long
> 
> Em operações matemáticas envolvendo divisão, se todos os tipos forem integrais, o resultado será um integral, mesmo que, na prática, tenha ponto flutuante. Ou seja: a divisão de um int por outro int sempre resulta em int, mesmo que o resultado possua casas decimais

### Tipos numéricos de ponto flutuante

- **float**: aceita valores reais de precisão simples (4 bytes)
  - Valores atribuído deve terminar com o prefixo `F`. Exemplo: `float temperatura = 32.54F;`
- **double**: aceita valores reais de precisão dupla (8 bytes)
  - Por padrão, quando um valor real é atribuído, o compilador interpreta como _double_. Exemplo: `double valorTotal = 165.36;`

> Valor padrão de inicialização: 0
>
> A ordem acima indica que um valor de um tipo cabe dentro do próximo tipo, mas não o contrário. Ou seja: um float cabe em um double, mas não o contrário
>
> Em operações matemáticas, o resultado será sempre o do maior tipo envolvido. Ou seja: na soma de um float com um double, o resultado será double
> 
> Em operações matemáticas envolvendo tipos integrais, o resultado será sempre com ponto flutuante. Ou seja: a soma de um int com um double, sempre resultará em um double

### Tipo para texto

- **char**: aceita um único caractere, podendo ser um código Unicode. Exemplo: `char sexo = 'F'; char flag = '\u0000';`
  - Valores devem estar entre aspas simples

> Valor padrão de inicialização: caractere nulo ('\u0000')
  
### Tipo lógico

- **boolean**: aceita somente os valores `true` ou `false`. Exemplo: `boolean ativo = true;`

> Valor padrão de inicialização: false 

## Tipos não primitivos

Alguns tipos não são primitivos da linguagem, porém, devido ao uso, é quase considerado como sendo primitivo.

### Tipos para texto

- String: Representa uma cadeia de caracteres. Exemplo: `String nome = "Fulado da Silva";`
  - Valores devem estar entre aspas duplas.
  - Para juntar dados em um único texto, usamos a concatenação:

  ~~~java
  String nome = "Fulano de Tal";
  char sexo = 'M';
  String cidade = "Brasília";
  String uf = "DF";
  int idade = 30;
  float altura = 1.68F;
  
  // Juntando texto com a concatenação
  String saida = "Meu nome é " + nome + " (sexo " + sexo + ") e tenho " + idade + " anos. " +
            "Tenho " + altura + " de altura. Sou de " + cidade + "-" + uf + ".";
  ~~~

> Valor padrão de inicialização: null