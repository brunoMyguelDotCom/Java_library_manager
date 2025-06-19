# Sistema de Biblioteca Pessoal

Este projeto é um sistema simples de gerenciamento de uma biblioteca pessoal, desenvolvido em Java, com foco na prática dos principais conceitos de Programação Orientada a Objetos (POO).

## Objetivo

Permitir o cadastro de livros e usuários, além de controlar empréstimos e devoluções, simulando o funcionamento básico de uma biblioteca.

## Tecnologias utilizadas

- Java 24
- Paradigma de Programação Orientada a Objetos
- VS Code como IDE principal

## Estrutura do projeto

- `Livro`: representa um livro com título, autor, ISBN e status de empréstimo.
- `Usuario`: representa um usuário com nome, CPF e lista de livros emprestados.
- `Biblioteca`: gerencia o acervo de livros, os usuários cadastrados e as operações do sistema.

## Funcionalidades

- Cadastrar livros no acervo
- Cadastrar usuários
- Emprestar livros (limite de 3 livros por usuário)
- Devolver livros
- Listar livros disponíveis
- Consultar livros emprestados por usuário

## Regras do sistema

- Um livro só pode ser emprestado se estiver disponível.
- Cada usuário pode ter no máximo 3 livros emprestados ao mesmo tempo.
- Ao devolver um livro, ele volta para a lista de disponíveis.
