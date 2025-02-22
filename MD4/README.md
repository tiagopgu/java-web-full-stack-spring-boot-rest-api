# Ambiente Java

###### _Anotações dos módulos 4 e 5 do curso_

## Plataforma Java x Linguagem Java

- Plataforma Java: disponibiliza recursos, ferramentas e facilidades que auxiliam no desenvolvimento
- Linguagem Java: provê a sintaxe usada para escrever um algoritmo que será executado pelo computador

## Características do Java

- Orientada a Objetos
- Portável: roda em qualquer lugar
- Segura e performática
- Interpretada: usa máquina virtual (JVM)
- Independente de plataforma
- Tipada

## Execução da aplicação

- Código-fonte (arquivo _.java_ escrito pelo desenvolvedor) é compilado (pelo _javac_) e transformado em código intermediário (arquivo _.class_, também chamado de byte-code)
- Código intermediário é transformado em código de máquina pela máquina virtual (JVM) de cada plataforma

## Nomenclaturas

- JVM: Máquina virtual do java, que converte os bytecodes em código executável pela máquina
- JRE: Ambiente de tempo de execução, responsável por executar uma aplicação Java. Dentro dela está a JVM. É a versão que será usada em ambiente produtivo.
- JDK: Kit de desenvolvimento Java, que provê diversas ferramentas e utilitários que auxiliam no desenvolvimento de software. Composto pelo compilador (_javac_, responsável por transformar o código-fonte em byte-code), e por outras bibliotecas. Junto vem o JRE.

## Instalação

- [Clique aqui](https://www.oracle.com/br/java/technologies/downloads/) para baixar o JDK da versão desejada e realizar a instalação padrão para a plataforma desejada (Windows, Linux, MacOS, etc.)
    > É possível ter mais de uma versão instalada na máquina
- Configurar as seguintes variáveis de ambiente:
  - JAVA_HOME: apontar para o diretório raiz da JDK desejada. Exemplo: `C:\Program Files\Java\jdk-23`
  - CLASS_PATH: apontar para o diretório _lib_ da versão configurada. Exemplo: `.;%JAVA_HOME%\lib`
  - JRE_HOME: caso não instalado o JDK, configurar para a versão desejada do JRE. Exemplo: `C:\Program Files\Java\jre-23`
- Path: Configurar, caso não exista, no final dessa variável de ambiente o diretório dos binários da versão desejada: `%JAVA_HOME%\bin`

    > Obs1.: No Windows acesse as variáveis de ambiente usando o seguinte caminho: _Botão direito do mouse em Iniciar > Sistema > Configurações avançadas do sistema > Variáveis de Ambiente..._\
    Obs2.: Configurar dentro de variáveis do sistema\
    Obs3.: Caso o comando de verificação de versão não funcione, pode ser necessário reiniciar o equipamento\
    Obs4.: Caso o terminal não reconheça o comando de verificação de versão, inserir no início da variável de ambiente Path, o mesmo valor da variável de ambiente JAVA_HOME
- Verificar, via CLI, a versão instalada: `java -version`

## IDE

- É uma interface gráfica que facilita o desenvolvimento de uma aplicação
- Provê recursos e facilidades que um editor de texto comum não têm
- Principais IDE's para Java:
  - IntelliJ IDEA: possui verão paga e gratuita (community)
  - Eclipe: gratuito e mais usada
  - NetBeans: gratuito e também bastante usado
  - Visual Studio Code: depende de extensões.

## Estrutura base da aplicação

- Códigos-fonte devem estar dentro do diretório _src_ (criar como sub-diretório dentro do diretório onde a aplicação será desenvolvida)
- Código-fonte tem a extensão _.java_
- Arquivo compilado tem a extensão _.class_
- Endpoint da aplicação está no método _main_, que possui a seguinte assinatura:
  ~~~java
  class NomeClasse {
    public static void main(String[] args) {
        // Aqui inicia a execução da aplicação
    }
  }
  ~~~

## Compilação e execução via CLI

- Para compilar uma classe: `javac caminho_arquivo_classe`
- Para executar o arquivo compilado: `java caminho_arquivo_compilado_sem_extensao`