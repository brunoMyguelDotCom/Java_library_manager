Sistema de Gerenciamento de Biblioteca - Java CLI
Configuração e Execução
Requisitos

    Java JDK 11 ou superior instalado

    Terminal/linha de comando

Inicialização
bash

# Compilar
javac -d . *.java

# Executar
java Main

Acesso Inicial

    Usuário padrão para testes:

        Nome: "user"

        CPF: "123"

Arquitetura Principal
Entidades do Sistema

    Biblioteca (Biblioteca.java)

        Mantém registros de todos os livros e usuários

        Métodos para gestão de coleções

    Livro (Livro.java)

        Atributos: título, autor, código único, status

        Controle de disponibilidade (DISPONIVEL/INDISPONIVEL)

    Usuário (User.java)

        Capacidade máxima: 3 empréstimos simultâneos

        Métodos para transações de livros

    Controle Principal (Main.java)

        Fluxo de navegação

        Interfaces de usuário

Operações Suportadas
Para Usuários

    Autenticação no sistema

    Consulta de livros disponíveis

    Empréstimo de itens (até 3 simultâneos)

    Devolução de livros

    Visualização de itens emprestados

Para Administradores

    Visualização completa do acervo

    Monitoramento de empréstimos ativos

Dados Iniciais
Livros Pré-cadastrados

    Entendendo Algoritmos (Aditya Bhargava)

    Arquitetura Limpa (Robert C. Martin)

    O Programador Pragmático (Andrew Hunt e David Thomas)

    Python Fluente (Luciano Ramalho)

    Refatoração (Martin Fowler)

Roadmap de Desenvolvimento
Próximas Versões

    Implementação de cadastro de novos usuários

    Sistema de persistência em arquivo

    Módulo administrativo completo

    Funcionalidade de reservas

    Geração de relatórios

Documentação Técnica
Validações Implementadas

    Verificação de limites de empréstimo

    Controle de disponibilidade de itens

    Validação de existência de usuário

    Consistência de transações

Métodos Críticos

    emprestaLivro(): Gerencia todo o ciclo de empréstimo

    devolveLivro(): Processa devoluções e atualizações

    interfaceLogin(): Controla o acesso ao sistema

Licenciamento

MIT License - Disponível para uso acadêmico e comercial, sem garantias implícitas.