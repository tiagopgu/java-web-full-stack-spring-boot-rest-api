package jdev.curso;

import jdev.curso.classes.Aluno;
import jdev.curso.classes.Instrutor;
import jdev.curso.classes.Pessoa;
import jdev.curso.classes.Secretario;
import jdev.curso.interfaces.Colaborador;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();
        List<Colaborador> colaboradores = new ArrayList<>();

        Aluno aluno = new Aluno("123", "Fulano da Silva", "A569CC");
        aluno.setDataNascimento("1981-05-22");

        pessoas.add(aluno);

        // Erro: aluno não implementa a interface Colaborador
        //colaboradores.add(aluno);

        Aluno aluno2 = new Aluno("123456789123", "Ciclana Alves", "B5599CD");
        aluno2.setDataNascimento("2001-02-15");

        pessoas.add(aluno2);

        Instrutor instrutor = new Instrutor("15936805", "Marcia Nunes Bueno", "59886505");

        pessoas.add(instrutor);
        colaboradores.add(instrutor);

        Secretario secretario = new Secretario("34487689449", "Nair Jaqueline Cristiane Castro");
        secretario.setAtribuicao("Teste");

        pessoas.add(secretario);
        colaboradores.add(secretario);

        System.out.println();

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
            System.out.println("Documento Formatado: " + pessoa.getDocumentoFormatado());
            System.out.println();
        }

        for (Colaborador colaborador : colaboradores) {
            System.out.println("Salário: R$ " + colaborador.calcularSalario());

            baterPonto(colaborador);

            System.out.println();
        }

        // Esse código gera erro: classe abstrata não pode ser instanciada
        //Pessoa pessoa = new Pessoa();
    }

    private static void baterPonto(Colaborador colaborador) {
        Random rnd = new Random();

        String data = "2025-05-" + rnd.nextInt(1, 30);

        boolean bateuPonto = colaborador.baterPonto(data);

        System.out.println("Colaborador" + (bateuPonto ? "" : " não") + " bateu ponto em " + data);
    }
}