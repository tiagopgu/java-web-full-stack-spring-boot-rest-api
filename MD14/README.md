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
                Thread.sleep(2000);
                System.out.println("Mais código do processo 1.");
            }
        }.start(); // Aqui diz para iniciar a execução em paralelo do processo

        // Usando método anônimo para dizer o que executar na thread
        new Thread(() -> {
            System.out.println("Executando processo 2.");
            Thread.sleep(1000);
            System.out.println("Mais código do processo 2.");
        }).start();

        // Thread que recebe referência direta de um método a ser executado
        new Thread(Main::outroMetodo).start();
        
        // As threads podem ser controladas quando serão iniciadas, já que recebem um objeto Runnable
        Thread objThread1 = new Thread(metodoExecutavelEmThread());
        Thread objThread2 = new Thread(outroMetodoExecutavalEmThread("TESTE"));

        System.out.println("Qualquer código após a definição das threads será executado em paralelo.");
        
        // Iniciando uma thread
        objThread1.start();
        
        System.out.println("Outros processamentos do fluxo principal");
        
        // Iniciando outra thread
        objThread2.start();
        
        System.out.println("Continua o processamento do fluxo principal...");
    }

    private static void outroMetodo() {
        System.out.println("Executando processo 3.");
        Thread.sleep(500);
        System.out.println("Mais código do processo 3.");
    }

    // O retorno dos métodos abaixo serão parâmetros de uma thread, que podem ser executados quando necessário
    private static Runnable metodoExecutavelEmThread() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Executando processo 4.");
                Thread.sleep(1500);
                System.out.println("Mais código do processo 4.");
            }
        };
    }
    
    // Usando um método anônimo para retornar um objeto Runnable para ser executado em uma thread (implementação implícita do método run)
    private static Runnable outroMetodoExecutavalEmThread(String param) {
        () -> {
            System.out.println("Executando processo 5.");
            System.out.println(400);
            System.out.println("Mais código do processo 5.");
        }
    }
}
~~~~