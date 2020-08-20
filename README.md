# Projeto MV Backend

Este é Backend do projeto para seleção da empresa MV.

## Tecnologias do projeto

 - Swagger
 - EJB
 - Hibernate
 - Java 8
 - Wildfly 14
 - Maven
 - Oracle Database 12g

## Como rodar a aplicação:

Tenha as seguintes ferramentas no seu computador:
  
  - Java 8
  - Wildfly 14
  - Maven
  - Oracle Database 12g

Para rodas a aplicação baixe o wildfly 14 para ser o seu servidor de aplicação, e coloque 
o standalone na pasta do servidor, e configure sua senha do oracle instalado em sua maquina.

Baixe as dependencias do seu projeto com o maven.

Atualize o `persistence.xml` para que o hibernate crie as tabelas do banco automaticamente, é so descomentar a linha no arquivo.

## Scripts para serem rodados na base de dados:

Primeiramente se deve inserir o arquivo `script-criacao-usuario-schema.sql` para criação do usuario e schema da base de dados, como de suas 
permissões necessarias para realizar os procedimentos de cadastro, alteração e exclusão dos dados do sistema.

Proximo passo será inserção na sua base de dados o arquivo `script-categoria-dados.sql`, que é a massa de dados para a tabela de categoria.

Por último, mas nao menos importante o arquivo `script-reajuste-preco-produto.sql` aonde contém o PLSQL com as procedures para algumas funcionalidades que seram executadas via sistema.

OBS: Todos os scripts se encontram a raiz do projeto.

