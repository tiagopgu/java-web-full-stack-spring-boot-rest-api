# Versionamento de Código

###### _Anotações referentes ao módulo 6 do curso_

## Git x GitHub

- Git: Sistema de controle de versão, que permite o versionamento de arquivos, criando assim um histórico de alterações realizadas no projeto.
  - Evita perda de código e arquivos, controlando suas versões
  - Permite voltar na linha do tempo do projeto
  - Repositório para controle de versão criado localmente
  - [Clique aqui](https://git-scm.com/) para baixar o Git e acessar sua documentação
- GitHub: É uma rede social de desenvolvedores, que permite o compartilhamento de projetos que usam o Git como versionamento. Com isso, diversos desenvolvedores podem trabalhar ao mesmo tempo em um projeto e de qualquer lugar.
  - Guarda remotamente um repositório Git, permitindo assim seu compartilhamento
  - [Clique aqui](https://github.com/) para acessar a plataforma e criar sua conta
  - [Clique aqui](https://docs.github.com/pt) para acessar a documentação do GitHub

## Comandos mais usados

- Commit: Envia as alterações para o repositório local, inserindo uma linha no histórico do repositório
- Push: Envia para o repositório remoto as alterações locais já salvas via commit
- Pull: Atualiza o repositório local com alterações existentes no repositório remoto
- Revert: Volta um arquivo para a última versão do histórico, desfazendo alterações atuais ou voltando para versão anterior
- Clone: Copia um repositório remoto para a máquina local, permitindo assim trabalhar localmente
- Branch: Ramificação do projeto criada a partir de outra branch. Permite trabalhar de forma separada de outros desenvolvedores
  - Normalmente, existe uma branch principal chamada de _main_ ou _master_, onde novas implementações são realizadas criando-se uma branch a partir dessa principal e, posteriormente, são mescladas estas alterações na branch principal
- Merge: Mescla alterações de uma branch em outra
  - Podem ocorrer conflitos que devem se tratados manualmente

> Normalmente as IDE's de desenvolvimento possuem integração com o Git, permitindo graficamente usar os comandos acima.
> 
> É possível também utilizar os comandos do Git via CLI.

> [Clique aqui](https://www.freecodecamp.org/news/how-to-use-git-submodules/) para saber sobre o recurso de submódulos do git

> <a href="https://semver.org/lang/pt-BR/" target="_blank">Clique aqui</a> para entender mais sobre versionamento semântico, muito usado para criar versões de sistema.