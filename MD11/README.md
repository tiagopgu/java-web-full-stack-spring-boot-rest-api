# Tratamento de Erros e Exceções

###### Anotações referentes ao módulo 11

## Exceção

- Erros imprevistos que podem ocorrer durante a execução da aplicação
- Erros podem ser:
  - Internos: problemas no código, que podem ser corrigidos rapidamente pela equipe. Exemplos: manipulação de objeto nulo, divisão por 0, conversão inválida de dados, etc.
  - Externos: problemas em componentes externos, onde não se tem controle pela equipe. Exemplos: manipulação de arquivo inexistente, acesso a um banco de dados indisponível, tentativa de conexão com um servidor fora de serviço, etc.
- No Java, temos diversas classes que representam exceções, todas tendo como base a classe `Exception`. Classes mais comuns:
  - `NullPointerException`: Tentativa de manipulação de objeto nulo
  - `ClassCastException`: Conversão inválida entre classes
  - `ArrayIndexOutOfBoundsException`: Índice fora dos limites de um array
  - `FileNotFoundException`: Tentativa de manipulação de arquivo não encontrado
  - `NumberFormatException`: Erro na conversão de string em número (string não tem só números)
  - `ClassNotFoundException`: Tentativa de usar classe não encontrada (ocorre principalmente quando um framework não foi carregado)

### Anatomia

  ~~~text
  Exception in thread "main" java.lang.NullPointerException <- Esta foi a exceção lançada
        at caminho.pacote.NomeClasse.metodo(NomeClasse.java:25) <- Exceção lançada aqui
        at caminho.pacote.NomeClasse2.metodo(NomeClasse2.java:11) <- Requisição passou por aqui
        at caminho.pacote.NomeClasse3.main(NomeClasse3.java:32) <- Requisição iniciou aqui
  ~~~

- Quando uma exceção é lançada, é gerada uma pilha de chamadas internas
  - No topo está a exceção gerada
  - Logo após a descrição da exceção, está o ponto o erro foi gerado.
  - Em seguida a caminho por onde o processamento passou, de trás para frente
- Leia de baixo para cima ao analisar o erro gerado.

### Tratamento

- Uma exceção lançada causa a parada da aplicação
- O tratamento faz com que a aplicação se recupere e continue o funcionamento
- Para tratar uma exceção, é usado o bloco `try {} catch(Exception e) {} finally {}`
  - É possível ter vários blocos `catch`, para tratar exceções específicas
  - O bloco `finally` é opcional, e sempre será executado, independente de erro ou não. Muito usado, por exemplo, para encerrar algum recurso (um arquivo aberto, por exemplo).

  ~~~java
  public class TestException {
    public static void main(String[] args) {
        try {
            // Aqui algum código que pode lançar exceção
        }
        catch(NumberFormatException ex) {
            // Aqui realizamos o tratamento de uma exceção específica
        }
        catch (Exception ex) {
            // Aqui realizamos o tratamento de qualquer exceção não capturada em blocos anteriores

            ex.printStackTrace(); // Este método escreve a pilha de chamados no console 
        }
        finally {
          // Este bloco é opcional e será sempre executado, tendo erro ou não
        }
    }
  }
  ~~~