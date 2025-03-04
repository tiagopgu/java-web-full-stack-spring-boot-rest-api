# Programação Orientada a Objetos (POO)

###### Anotações referentes ao módulo 9

## Introdução

- Modelo de análise, projeto e programação de software que se baseia na composição e interação entre diversas unidades chamadas _objetos_
- Modelo mais próximo do mundo real, onde objetos e conceitos podem ser representados através da programação

## Classe

- Define um modelo de objeto, que possui dados (características) e comportamentos
- Abstrai objetos e conceitos do mundo real, geralmente nomeado por um substantivo
  - Nome usa a anotação PascalCase.
  - Exemplo:

    ~~~java
    // Permite organizar as classes do projeto. Não é obrigatório
    package br.jdevcursos.classes;
    
    // Nome usa a notação PascalCase
    public class NomeClasse {
    }
    ~~~

    > Para uma melhor organização das classes, use os pacotes do Java. Normalmente os pacotes são subdiretórios dentro da raiz do projeto e o uso da seguinte sintaxe no início do arquivo que define a classe: `package subdiretorio.subdiretorio2;`

- Atributos representam as características.
  - Declarado semelhante a uma variável
  - Usar anotação camelCase, iniciando com letra minúscula. Exemplo: `String nomePai;`
  - É uma boa prática ter acesso `private` e usar métodos acessores para manipulação fora da classe

    ~~~java
    public class NomeClasse {
        // Este atributo não pode ser acessado fora da classe por ser private (padrão)
        int atributo1;

        // public permite que o atributo seja acessado fora da classe.
        // Não é uma boa prática manter atributos com este nível de acesso
        public String atributo2;

        // Atributo só pode se acessado dentro da classe.
        // É uma boa prática os atributos terem esse nível de acesso
        private double atributo3;
    }
    ~~~

- Métodos representam os comportamentos (semelhante aos procedimentos e funções da programação estruturada)
  - Métodos especiais chamados de acessores, que permitem manipular atributos _private_:
    - **set**: Configura o valor de um atributo
    - **get**: Retorna o valor de um atributo
    - Exemplo:

      ~~~java
      public class NomeClasse {
        int atributo;
    
        // Os dois métodos a seguir são chamados de acessores do atributo acima
        public void setAtributo(int atributo) {

            // this se refere a própria instância do objeto
            // Neste caso, usado para diferenciar o atributo da classe e do parâmetro do método
            this.atributo = atributo;
        }
    
        public int getAtributo() {
            return atributo;
        }
      
        // Métodos acessores para os demais atributos, se necessário
      }
      ~~~

  - Método especial chamado de construtor
    - Possui o mesmo nome da classe e não tem retorno
    - Responsável por construir um objeto, inicializando os atributos da classe com valores padrão (caso não passado na construção do objeto com um construtor parametrizado)
    - Exemplo:

      ~~~java
      public class NomeClasse {
        int atributo1;
        String atributo2;

        // Métodos acessores

        // Construtor sem parâmetro.
        // Definido implicitamente, caso nenhum outro construtor seja definido
        // Se definido outro construtor e este for necessário, deve definido explicitamente
        public NomeClasse() {
        }
        
        // Construtor com dois parâmetros
            
        public NomeClasse(int atributo1, String atributo2) {
            this.atributo1 = atributo1;
            this.atributo2 = atributo2;
        }
      }
      ~~~

  - Método especial chamado _toString_
    - Permite escrever a classe como uma string.
    - Se não declarada explicitamente na classe, irá escrever endereço de memória do objeto instanciado.
    - Exemplo:

      ~~~java
      public class NomeClasse {
        int atributo1;
        String atributo2;
        // Outros membros da classe

        // Sobrescreve o comportamento padrão
        // Comportamento padrão escreve o nome do pacote, da classe e do seu endereço de memória.
        // Exemplo: br.jdevcursos.classes.NomeClasse@fd26e58f (depois de @ é um valor aleatório, que é a posição de memória do objeto )
        public String toString() {
            return "Valor atributo1: " + atributo1 +
                    "Valor atributo2: " + atributo2;
        }
      }
      ~~~

  - Outros métodos
    - Semelhante à declaração de funções da programação estruturada
    - Exemplo:

    ~~~java
    public class NomeClasse {

        // Outros membros da classe
    
        // Método com retorno e acessado externamente
        // A boa prática diz que a classe deve encapsular a lógica para alterar e validar seus atributos
        // Métodos devem ter uma única responsabilidade.
        // Divida a lógica em mais métodos para mais clareza do que está sendo feito
        public String metodo1() {
            return "Faz alguma coisa";
        }
    
        // Método sem retorno e acessado somente internamente.
        // Se não definido o modificador de acesso, o padrão é private
        void metodo2 () {
            // Faz alguma coisa
        }
    }
    ~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/57401b56169fcca3c05264c3ac8b7a993c56f020/MD9/Demo/src/jdev/curso/classes/Aluno.java#L1)

## Objeto

- Criado a partir de um modelo de _classe_ (processo chamado de _instanciação_)
- Tem seus dados carregados e irá interagir (por meio de mensagens) com outros objetos criados durante a execução do sistema
- A instanciação cria o objeto na memória
- A instanciação ocorre quando é usado o comando `new`: `NomeClasse obj = new NomeClasse();`
  - A tentativa de chamar um método ou propriedade da classe a partir de uma variável do tipo da classe, porém não instanciado o objeto, gera a execeção `NullPointerException`.
- Exemplo

~~~java
// Indicando o pacote da classe em uso (necessário se esta classe estiver em outro pacote)
import subdiretorio.subdiretorio2.NomeClasse;

class Main {
    public static void main(String[] args) {
        // Variável do tipo a ser instanciado
        // A variável faz referência ao endereço de memória onde o objeto foi criado
        // Neste caso não aponta para nenhum objeto ainda
        NomeClasse obj1 = null;

        // Essa chamada irá gerar o erro 'NullPointerException'
        //obj1.atributo2 = "Valor";
        
        // Instanciando o objeto
        // Neste caso é chamado o construtor sem parâmetro
        // Pode ser usado outro construtor, se definido na classe
        obj1 = new NomeClasse();
      
        obj1.atributo2 = "Valor"; // Configurando valor de atributo público
        obj1.setAtributo1("Valor"); // Configurando valor de atributo privado através de método acessor

        System.out.println(obj1.getAtributo1()); // Lendo valor de atributo privado através de método acessor

        NomeClasse obj2 = new NomeClasse(1324, "Valor 2"); // Chamado o construtor com 2 parâmetros
        obj2.setAtributo1("Valor");

        // Chamado um método do objeto
        System.out.println("Valor: " + obj2.metodo2());

        // Chamado o método toString (implicitamente)
        System.out.println(obj1);

        // Chamando o método toString (explicitamente)
        System.out.println("Dados do objeto: \n" + obj2.toString());
    }
}
~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/57401b56169fcca3c05264c3ac8b7a993c56f020/MD9/Demo/src/Main.java#L7)