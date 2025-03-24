package jdev.curso;

import jdev.curso.classes.Aluno;
import jdev.curso.classes.Instrutor;
import jdev.curso.classes.Pessoa;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("123", "Fulano da Silva", "A569CC");
        aluno.setDataNascimento("1981-05-22");

        Aluno aluno2 = new Aluno("123456789123", "Ciclana Alves", "B5599CD");
        aluno2.setDataNascimento("2001-02-15");

        System.out.println();

        System.out.println(aluno);
        System.out.println("Documento Formatado: " + aluno.getDocumentoFormatado() + "\n");

        System.out.println(aluno2);
        System.out.println("Documento Formatado: " + aluno2.getDocumentoFormatado() + "\n");

        Instrutor instrutor = new Instrutor("15936805", "Marcia Nunes Bueno", "59886505");

        System.out.println(instrutor);
        System.out.println("Documento Formatado: " + instrutor.getDocumentoFormatado());

        // Esse código gera erro: classe abstrata não pode ser instanciada
        //Pessoa pessoa = new Pessoa();
    }
}