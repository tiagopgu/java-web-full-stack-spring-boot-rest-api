# Thread e Programação Paralela ou Concorrente

###### Anotações referentes ao módulo 14

Thread permite com que diversos processamentos ocorram em paralelo, sem travar o processo principal. Isso garante mais fluidez ao sistema, não travando o usuário em tarefas que demandam um tempo maior de processamento, liberando-o para realizar diversas tarefas.

## Inserindo Interrupção via código

Para inserir interrupção por um período na execução do código, use `Thread.sleep(tempo_millisegundos)`. `Thread` pertence ao pacote `java.lang`

## Inserindo processamento paralelo

~~~java
import java.lang;

public class Demo {
    public static void main(String[] args) {
        // A seguir formas de iniciar uma thread
        
        // Aqui inicia uma thread
        new Thread() {
            // Dentro deste método estará o código que será executado em paralelo
            public void run() {
                System.out.println("Executando processo 1.");
                System.out.println("Mais código do processo 1.");
            }
        }.start(); // Aqui diz para iniciar a execução em paralelo do processo
        
        // Usando método anônimo para dizer o que executar na thread
        new Thread(() -> {
            System.out.println("Executando processo 2.");
            System.out.println("Mais código do processo 2.");
        }).start();
        
        // Thread que recebe referência direta de um método a ser executado
        new Thread(Main::outroMetodo).start();
        
        System.out.println("Qualquer código após a definição das threads será executado em paralelo.");
    }
    
    private static void outroMetodo() {
        System.out.println("Executando processo 3.");
        System.out.println("Mais código do processo 3.");
    }
}
~~~~