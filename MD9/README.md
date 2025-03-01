# Programação Orientada a Objetos (POO)

###### Anotações referentes ao módulo 9

## Introdução

- Modelo de análise, projeto e programação de software que se baseia na composição e interação entre diversas unidades chamadas _objetos_
- Modelo mais próximo do mundo real, onde objetos e conceitos podem ser representados através da programação

## Classe

- Define um modelo de objeto, que possui dados (características) e comportamentos
- Abstrai objetos e conceitos do mundo real, geralmente nomeado por um substantivo
- Atributos representam as características.
  - Declarado semelhante a uma variável
  - Usar anotação camelCase, iniciando com letra minúscula. Exemplo: `String nomePai;`
  - É uma boa prática ter acesso `private` e usar métodos acessores _setters_ e _getters_ para acesso fora da classe
- Métodos representam os comportamentos (semelhante aos procedimentos e funções da programação estruturada)
  - Possui um método especial chamado de construtor, que possui o mesmo nome da classe e não tem retorno, responsável por construir um objeto, inicializando os atributos da classe
- No Java, tem a seguinte sintaxe:
  
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
  
    // Os dois métodos a seguir são chamados de acessores
    public void setAtributo1(int atributo1) {
        // this se refere a própria instância do objeto
        // Neste caso, usado para diferenciar o atributo da classe e do parâmetro do método
        this.atributo1 = atributo1;
    }
  
    public int getAtributo1() {
        return atributo1;
    }
  
    // Métodos acessores para os demais atributos da classe
  
    // Construtor sem parâmetro.
    // Definido implicitamente, caso nenhum outro construtor seja definido
    public NomeClasse() {
    }
  
    // Construtor com dois parâmetros
    // Se definido um construtor com parâmetro, se necessário o sem parâmetro, este deve ser definido explicitamente
    public NomeClasse(int pAtributo1, String pAtributo2) {
        atributo1 = pAtributo1;
        atributo2 = pAtributo2;
    }
  
    // Método acessado externamente
    // A boa prática diz que a classe deve encapsular a lógica para trabalhar com seus atributos
    // Métodos devem ter uma única responsabilidade. Divida a lógica em mais métodos para mais clareza
    public String metodo1() {
        return "Faz alguma coisa";
    }
  
    // Método acessado somente internamente.
    // Se não definido o modificador de acesso, o padrão é private
    void metodo2 () {
        // Faz alguma coisa
    }
}
~~~
    
> Para uma melhor organização das classes, use os pacotes do Java. Normalmente os pacotes são subdiretórios dentro da raiz do projeto e o uso da seguinte sintaxe no início do arquivo que define a classe: `package subdiretorio.subdiretorio2;`
> 
> Em outro arquivo onde for usada a classe, teria que ser colocado, no início do arquivo, o import desse pacote: `import subdiretorio.subdiretorio2.NomeClasse;`
> 
> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/57401b56169fcca3c05264c3ac8b7a993c56f020/MD9/Demo/src/jdev/curso/classes/Aluno.java#L1)

## Objeto

- Criado a partir de um modelo de _classe_ (processo chamado de _instanciação_)
- Tem seus dados carregados e irá interagir (por meio de mensagens) com outros objetos criados durante a execução do sistema
- A instanciação cria o objeto na memória
- A instanciação ocorre quando é usado o comando `new`, com a seguinte sintaxe

~~~java
class Main {
    public static void main(String[] args) {
        // Instanciando uma classe para criar objetos
        // As variáveis fazem referência oa endereço de memória onde o objeto foi criado
        NomeClasse obj1 = new NomeClasse(); // Chamando o construtor sem parâmetro
        obj1.atributo2 = "Valor"; // Configurando valor de atributo público
        obj1.setAtributo1("Valor"); // Configurando valor de atributo privado através de método acessor

        Sytem.out.println(obj1.getAtributo1()); // Lendo valor de atributo privado através de método acessor

        NomeClasse obj2 = new NomeClasse(1324, "Valor 2"); // Chamado o construtor com 2 parâmetros
        obj2.setAtributo1("Valor");
    }
}
~~~

> [Projeto Demo](https://github.com/tiagopgu/java-web-full-stack-spring-boot-rest-api/blob/57401b56169fcca3c05264c3ac8b7a993c56f020/MD9/Demo/src/Main.java#L7)