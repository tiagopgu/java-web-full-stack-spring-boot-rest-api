# Projeto "Média Escolar"

###### _Projeto para prática dos assuntos estudados até o módulo 8 de curso._

## Introdução

O projeto consiste em uma pequena calculadora da média de um aluno nos 4 bimestres do ano, mostrando também a situação do mesmo.

## Regras de negócio

- Será solicitado o nome do aluno, com pelo menos 2 caracteres
- A média será calcula com base nas notas inseridas no sistema
- A nota de cada bimestre estará entre 0 e 10
- Para validação da situação, o sistema calcula uma média auxiliar, somando o valor de _0.25_ à media calculada anteriormente
  - Essa média auxiliar serve para arredondar a nota de um aluno, permitindo mudar sua situação caso falte alguns décimos
- A situação é analisada com base na média ou na média auxiliar calculada anteriormente
    - _Aprovado_, caso tenha média maior ou igual a 7
    - _Em Recuperação_ para média maior ou igual a 5 e menor que 7
    - _Reprovado_, para média menor que 5
- Deve ser mostrado para o usuário o nome do aluno, sua média (não a média auxiliar) e sua situação.