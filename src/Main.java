import java.util.Scanner;

import funcionalidades.Biblioteca;
import funcionalidades.Livro;
import funcionalidades.User;

public class Main {

    // LIVRO: Exibe informacoes do livro COM status de disponibilidade
    public static void exibeInfosToBiblioteca(Livro livro) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              INFORMAÇÕES DO LIVRO              ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ Título:     %-35s ║%n", livro.getTitulo());
        System.out.printf("║ Autor:      %-35s ║%n", livro.getAutor());
        System.out.printf("║ Código:     %-35s ║%n", livro.getCodigo());
        System.out.printf("║ Disponível: %-35s ║%n", livro.isDisponivel());
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    // LIVRO: Exibe informacoes do livro SEM status de disponibilidade
    public static void exibeInfosToUser(Livro livro) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║              INFORMAÇÕES DO LIVRO              ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ Título:     %-35s ║%n", livro.getTitulo());
        System.out.printf("║ Autor:      %-35s ║%n", livro.getAutor());
        System.out.printf("║ Código:     %-35s ║%n", livro.getCodigo());
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    // BIBLIOTECA: exibe lista de livros
    public static void exibeLivros(Biblioteca biblioteca) {
        for (Livro livro : biblioteca.listaLivros) {
            exibeInfosToBiblioteca(livro);
        }
    }

    // MAIN
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        // Criando os livros com a referência da biblioteca
        Livro livro1 = new Livro("Entendendo Algoritmos", "Aditya Bhargava", "TEC006", biblioteca);

        Livro livro2 = new Livro("Arquitetura Limpa", "Robert C. Martin", "TEC007", biblioteca);

        Livro livro3 = new Livro("O Programador Pragmático", "Andrew Hunt e David Thomas", "TEC008", biblioteca);

        Livro livro4 = new Livro("Python Fluente", "Luciano Ramalho", "TEC009", biblioteca);

        Livro livro5 = new Livro("Refatoração: Aperfeiçoando o Design de Códigos Existentes", "Martin Fowler", "TEC010",
                biblioteca);

        // Criando o usuário fictício
        User usuario1 = new User("123", "123", biblioteca);

        // Inicio software
        System.out.println(
                "╔═══════════════════════════════════════╗\n" +
                        "║    Bem vindo à biblioteca maneira!    ║\n" +
                        "╚═══════════════════════════════════════╝");

        while (true) {
            // Variavel de opcao
            int opcao = 0;
            System.out.println("╔══════════════════════════════════════╗");
            System.out.println("║           MENU DA BIBLIOTECA         ║");
            System.out.println("╠══════════════════════════════════════╣");
            System.out.println("║        Digite [1] - para LOGIN       ║");
            System.out.println("║        Digite [2] - para CADASTRAR   ║");
            System.out.println("║        Digite [3] - para SAIR        ║");
            System.out.println("║                                      ║");
            System.out.println("║Digite sua opção:                     ║\n");
            opcao = scanner.nextInt();
            System.out.println("\n╚══════════════════════════════════════╝");

            switch (opcao) {
                case 1:
                    // Limpeza buffer teclado
                    scanner.nextLine();

                    // Flag para pesquisa
                    User usuarioEncontrado = null;

                    System.out.println("\n");

                    // Variaveis para pesquisa
                    String nome;
                    String cpf;

                    System.out.println("╔══════════════════════════════════════╗");
                    System.out.println("║            TELA DE LOGIN             ║");
                    System.out.println("╠══════════════════════════════════════╣");
                    System.out.print("║ Nome: ");
                    nome = scanner.nextLine();

                    System.out.println("║                                      ║");

                    System.out.print("║ CPF:  ");
                    cpf = scanner.nextLine();

                    System.out.println("╚══════════════════════════════════════╝");

                    // Pesquisa
                    for (User user : biblioteca.getListaUsers()) {
                        if (cpf.equals(user.getCpf())) {
                            // Se achar muda a flag
                            usuarioEncontrado = user;

                            System.out.println("LOGIN REALIZADO COM SUCESSO!");
                            System.out.println("Bem vindo! %s".formatted(user.getNome()));

                            // break ao encontrar o usuario
                            break;
                        }
                    }

                    if (usuarioEncontrado == null) {
                        System.out.println("╔══════════════════════════════════════╗");
                        System.out.println("║      [ERRO] CPF não encontrado!      ║");
                        System.out.println("╚══════════════════════════════════════╝");

                        System.out.println("* CASO NAO TENHA CONTA, FACA UM CADASTRO *");
                    }
                    if (usuarioEncontrado != null) {
                        // Variavel de opcao
                        int opcaoInterface = 0;

                        // Interface inicial:
                        do {
                            usuarioEncontrado.interfaceInicial();
                            opcaoInterface = scanner.nextInt();

                            switch (opcaoInterface) {
                                case 1:
                                    exibeLivros(biblioteca);
                                    break;

                                case 2:
                                    usuarioEncontrado.exibeEmprestados();
                                    break;

                                case 3:
                                    System.exit(0);
                                    break;

                                default:
                                    System.out.println("Opcao invalida! Digite novamente!");
                                    break;
                            }
                        } while (opcao == 0);
                    }

                    // break por erro, voltando nas opcoes iniciais
                    break;

                case 3:
                    // Finaliza software
                    System.exit(0);

                default:
                    System.out.println("Opcao invalida! Digite novamente!");
                    break;
            }
        }

    }
}
