# Herança, Polimorfismo e Interface

###### Anotações referentes ao módulo 10

## Herança

- Permite que uma classe herde atributos e comportamentos de outra classe
- Classe herdada é chamada de superclasse, classe mãe ou classe base
- Classe que herda é chamada de classe filha, subclasse ou classe derivada
- Conceito de generalização/especialização
  - Caso seja necessário impedir a instanciação da classe genérica, use a palavra `abstract` após o modificador de acesso na declaração da classe
    - Palavra-chave `abstract` também pode ser usada em métodos, para obrigar a implementação deste nas classes derivadas. Portanto, método abstrato não possui implementação.
- Conceito do _é-um_: tipo da classe derivada é um tipo da classe base
- Herança indicada pelo uso da palavra-chave `extends`
  - Modificador de acesso `protected` permite que membros possam ser acessados somente na classe base e classe derivada
  - Membros da classe base podem ser referenciados na classe derivada com o uso da palavra-chave `super`
  - Métodos da classe base podem ser reescritos na classe derivada. Para indicar esse comportamento, use a anotação `@Override`.
- Toda classe automaticamente herda da classe `Object`
- Exemplo:

  ~~~java
  // A classe base não pode ser instanciada
  public abstract class ClasseBase {
    // Modificador de acesso protected permite acesso somente na classe base e derivadas
    protected String atributo;
  
    protected ClasseBase(String atributo) {
        setAtributo(atributo);
    }
  
    public String getAtributo() {
        return atributo;
    }
  
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }
  
    public boolean validarAtributo() {
        return atributo.length() > 5 && atributo.length() < 60;
    }
  
    // Classes derivadas são obrigadas a implementarem este método
    public abstract String gerarCodigo();
  }
  
  public class ClasseDerivada extends ClasseBase {
    private boolean ativo;
  
    public ClasseDerivada(String atributo) {
        // super permite acessar membros da classe base
        // Neste caso, acesso ao construtor com um parâmetro
        super(atributo);
  
        setAtivo(true);
    }
  
    public boolean getAtivo() {
        return ativo;
    }
  
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
  
    @Override
    public String gerarCodigo() {
        return "AB123";
    }
  }
  
  public class ClasseDerivada2 extends ClasseBase {
    private int valor;
  
    public ClasseDerivada2(int valor, String atributo) {
        super(atributo);
  
        setValor(valor);
    }
  
    public int getValor() {
        return valor;
    }
  
    public void setValor(int valor) {
        this.valor = valor;
    }
  
    // Método toString é herdado da classe Object
    @Override
    public String toString() {
        // Atributos da classe base pode ser acessado normalmente, desde que não seja private
        return "[" + valor + "] " + atributo; 
    }
  
    // Sobrescrevendo comportamento padrão definido na classe base 
    @Override
    public boolean validarAtributo() {
        return atributo.length() > 1 && atributo.length() <= 10;
    }
  
    @Override
    public String gerarCodigo() {
        return "GTY869";
    }
  }
  
  public class TesteHeranca {
    public static void main(String[] args) {
        // Código abaixo gera erro
        //ClasseBase objBase = new ClasseBase();
  
        ClasseDerivada objDerivado1 = new ClasseDerivada("Valor 1");
        ClasseDerivada2 objDerivado2 = new ClasseDerivada2(5, "Valor 2");
  
        // Chamando membro da classe derivada
        System.out.println(objDerivado1.getAtivo());
        System.out.println(objDerivado2.getValor());
  
        // Chamando membro herdado da classe base
        System.out.println(objDerivado1.getAtributo());
        System.out.println(objDerivado2.getAtributo());
  
        // Chamando comportamento definido na classe base
        System.out.println(objDerivado1.validarAtributo());
  
        // Chamando comportamento sobrescrito na classe derivada
        System.out.println(objDerivado1.gerarCodigo());
        System.out.println(objDerivado2.gerarCodigo());
        System.out.println(objDerivado2.validarAtributo());
    }
  }
  ~~~
  
## Interface

- Define a assinatura de métodos públicos, sem implementá-los
- Cria um contrato com uma classe, obrigando esta implementar os comportamentos definidos na interface
- Uma classe implementa uma interface usando a palavra-chave `implements`
  - Mais de uma interface pode ser implementada, separando-as por `,`. Exemplo: `public class Teste implements Interface1, Interface2 { }`
- Exemplo:
- 
  ~~~java
  public interface Pagamento {
    // Automaticamente, o método é público
    double calcularSalario();
  }
  
  public class Gerente implements Pagamento {
    // Demais membros
  
    @Override
    public double calcularSalario() {
        return 73659.56;
    }
  }
  
  public class Secretario implements Pagamento {
    // Demais membros
  
    @Override
    public double calcularSalario() {
        return 3659.98;
    }
  }
  
  public class Socio {
    // membros
  }
  
  public class Teste {
    public static void main(String[] args) {
        Gerente gerente = new Gerente();
        Secretario secretario = new Secretario();
        Socio socio = new Socio();
  
        // Chamando comportamento definido na interface
        System.out.println(gerente.calcularSalario());
        System.out.println(secretario.calcularSalario());
        
        // Chamada inválida: Socio não implementa a interface Pagamento
        //System.out.println(socio.calcularSalario());
    }
  }
  ~~~