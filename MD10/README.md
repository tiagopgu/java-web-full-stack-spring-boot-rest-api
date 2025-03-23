# Herança, Polimorfismo e Interface

###### Anotações referentes ao módulo 10

## Herança

- Permite que uma classe herde atributos e comportamentos de outra classe
- Classe herdada é chamada de superclasse, classe mãe ou classe base
- Classe que herda é chamada de classe filha, subclasse ou classe derivada
- Conceito de generalização/especialização
- Conceito do ´é-um´: classe derivada é uma classe base
- Herança indicada pelo uso da palavra-chave `extends`
  - Modificador de acesso `protected` permite que membros possam ser acessados somente na classe base e classe derivada
  - Membros da classe base podem ser referenciados na classe derivada com o uso da palavra-chave `super`
  - Métodos da classe base podem ser reescritos na classe derivada. Para indicar esse comportamento, use a anotação `@Override`.
- Toda classe automaticamente herda da classe `Object`
- Exemplo:

  ~~~java
  public class ClasseBase {
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
  }
  
  public class ClasseDerivada extends ClasseBase {
    private boolean ativo;
  
    public ClasseDerivada(String atributo) {
        base(atributo);
  
        setAtivo(true);
    }
  
    public boolean getAtivo() {
        return ativo;
    }
  
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
  }
  
  public class ClasseDerivada2 extends ClasseBase {
    private int codigo;
  
    public ClasseDerivada2(int codigo, String atributo) {
        // super permite acessar membros da classe base
        // Neste caso, acesso ao construtor com um parâmetro
        super(atributo);
  
        setCodigo(codigo);
    }
  
    public int getCodigo() {
        return codigo;
    }
  
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
  
    // Método toString é herdado da classe Object
    @Override
    public String toString() {
        // Atributos da classe base pode ser acessado normalmente, desde que não seja private
        return "[" + codigo + "] " + atributo; 
    }
  
    // Sobrescrevendo comportamento padrão definido na classe base 
    @Override
    public boolean validarAtributo() {
        return atributo.length() > 1 && atributo.length() <= 10;
    }
  }
  
  public class TesteHeranca {
    public static void main(String[] args) {
        ClasseDerivada objDerivado1 = new ClasseDerivada("Valor 1");
  
        // Chamando membro da classe derivada
        System.out.println(objDerivado1.getAtivo());
  
        // Chamando membro da classe base
        System.out.println(objDerivado1.getAtributo());
  
        // Chamando comportamento definido na classe base
        System.out.println(objDerivado1.validarAtributo());
  
        ClasseDerivada2 objDerivado2 = new ClasseDerivada2(5, "Valor 2");
  
        // Chamando comportamento sobrescrito na classe derivada
        System.out.println(objDerivado2.validarAtributo());
    }
  }
  ~~~