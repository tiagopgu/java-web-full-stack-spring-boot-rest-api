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
        
        // Aqui inicia uma thread
        new Thread(() -> {
            
            // Dentro deste método estará o código que será executado em paralelo
            System.out.println("Executando processo em paralelo");
                
            }).start(); // Aqui diz para iniciar a execução em paralelo do processo
        
        System.out.println("Qualquer código após a definição da thread será executado em paralelo com a thread");
    }
}
~~~~