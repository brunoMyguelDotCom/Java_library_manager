import model.Biblioteca;
import model.Livro;
import model.User;

public class Main {

    // LIVRO: Exibe informacoes do livro COM status de disponibilidade
    public static void exibeInfosToBiblioteca(Livro livro, Biblioteca biblioteca) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.printf("║         INFORMAÇÕES DO LIVRO Nº - 0%d           ║\n",
                biblioteca.getListaLivros().indexOf(livro) + 1);
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ Título:     %-34s ║%n", livro.getTitulo());
        System.out.printf("║ Autor:      %-34s ║%n", livro.getAutor());
        System.out.printf("║ Código:     %-34s ║%n", livro.getCodigo());
        System.out.printf("║ Disponível: %-34s ║%n", livro.isDisponivel());
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    // LIVRO: Exibe informacoes do livro SEM status de disponibilidade
    public static void exibeInfosToUser(User user, Livro livro, Biblioteca biblioteca) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.printf("║         INFORMAÇÕES DO LIVRO Nº - 0%d           ║\n",
                user.getListaLivros().indexOf(livro) + 1);
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ Título:     %-34s ║%n", livro.getTitulo());
        System.out.printf("║ Autor:      %-34s ║%n", livro.getAutor());
        System.out.printf("║ Código:     %-34s ║%n", livro.getCodigo());
        System.out.println("╚════════════════════════════════════════════════╝");
    }

    // BIBLIOTECA: Exibe lista de livros disponiveis
    public static void exibeLivros(Biblioteca biblioteca) {
        for (Livro livro : biblioteca.listaLivros) {
            exibeInfosToBiblioteca(livro, biblioteca);
        }
    }

    // USER: Exibe lista de emprestados
    public static void exibeEmprestados(User user, Biblioteca biblioteca) {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════╗
                ║                    LIVROS EMPRESTADOS                      ║
                ╠════════════════════════════════════════════════════════════╣
                ║  NUMERO DE LIVRO(S) EMPRESTADO(S): %d                       ║
                ╚════════════════════════════════════════════════════════════╝
                """.formatted(user.listaLivros.size()));

        // ForEach para exibir livro por livro dentro da lista
        for (Livro livroExibir : user.listaLivros) {
            exibeInfosToUser(user, livroExibir, biblioteca);

            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║               FIM DO LIVRO ACIMA               ║");
            System.out.println("╚════════════════════════════════════════════════╝\n");
        }
    }

    // FUNCOES DE INTERFACE:
    // Interface inicial
    public static int interfaceBemVindo(Biblioteca biblioteca) {
        // Inicio software
        System.out.println(
                "╔═══════════════════════════════════════╗\n" +
                        "║    Bem vindo à biblioteca maneira!    ║\n" +
                        "╚═══════════════════════════════════════╝");

        // Variavel de opcao
        int opcao = 0;
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           MENU DA BIBLIOTECA         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.println("║        Digite [1] - para LOGIN       ║");
        System.out.println("║        Digite [2] - para CADASTRAR   ║");
        System.out.println("║        Digite [3] - para SAIR        ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
        opcao = model.ScannerGlobal.scanner.nextInt();

        // Logica de escolha de opcao
        switch (opcao) {
            case 1:
                // Declara usuario como nao encontrado por padrao
                User usuarioEncontrado = null;

                // Recebe retorno de funcao para encontrar o usuario
                usuarioEncontrado = interfaceLogin(biblioteca);
                interfaceInicial(usuarioEncontrado, biblioteca);

                // break por erro, voltando nas opcoes iniciais
                break;

            case 3:
                // Finaliza software
                System.exit(0);

            default:
                System.out.println("Opcao invalida! Digite novamente!");
                break;
        }
        return opcao;
    }

    // Interface Login
    public static User interfaceLogin(Biblioteca biblioteca) {
        // Limpeza buffer teclado
        model.ScannerGlobal.scanner.nextLine();

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
        nome = model.ScannerGlobal.scanner.nextLine();

        System.out.println("║                                      ║");

        System.out.print("║ CPF:  ");
        cpf = model.ScannerGlobal.scanner.nextLine();

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

            System.out.println("\n* CASO NAO TENHA CONTA, FACA UM CADASTRO *\n");

            interfaceBemVindo(biblioteca);
        }

        return usuarioEncontrado;
    }

    // Interface Home LOGADO
    public static void interfaceInicial(User usuarioEncontrado, Biblioteca biblioteca) {
        // Variavel de opcao
        int opcao = 0;
        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println(
                    "║ Livros emprestados:           [  %d  ]          ║"
                            .formatted(usuarioEncontrado.listaLivros.size()));
            System.out.println("║ Empréstimos restantes:        [  %d  ]          ║"
                    .formatted(3 - usuarioEncontrado.listaLivros.size()));
            System.out.println("╠════════════════════════════════════════════════╣");
            System.out.println("║   Opções:                                      ║");
            System.out.println("║   [1] Listar livros disponíveis                ║");
            System.out.println("║   [2] Ver livros emprestados                   ║");
            System.out.println("║   [3] Sair                                     ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            opcao = model.ScannerGlobal.scanner.nextInt();

            if (usuarioEncontrado != null) {
                // Logica de escolha de opcao
                switch (opcao) {
                    case 1:
                        exibeLivros(biblioteca);
                        emprestimolivro(usuarioEncontrado, biblioteca);
                        break;

                    case 2:
                        exibeEmprestados(usuarioEncontrado, biblioteca);
                        devolucaoLivro(usuarioEncontrado, biblioteca);
                        break;

                    case 3:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opcao invalida! Digite novamente!");
                        break;
                }
            }

        } while (opcao != -1);

    }

    // Interface emprestimo livro
    public static void emprestimolivro(User user, Biblioteca biblioteca) {
        int opcao = 0;
        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   Opções:                                      ║");
            System.out.println("║   [1] Emprestar Livro                          ║");
            System.out.println("║   [2] Voltar                                   ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            opcao = model.ScannerGlobal.scanner.nextInt();

            if (opcao != 1 && opcao != 2) {
                System.out.println("Opcao invalida! Digite novamente!");
            }
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1) {
            int numeroEmprestimoLivro = 0;
            do {
                System.out.println("Digite o numero do livro desejado: ");

                // Variavel para numero do livro desejado
                numeroEmprestimoLivro = model.ScannerGlobal.scanner.nextInt();

                if (numeroEmprestimoLivro > biblioteca.getListaLivros().size()) {
                    System.out.println("Opcao invalida! Digite novamente!");
                } else {
                    // Tratamento de erro: Livro indisponivel
                    if (biblioteca.getListaLivros().get(numeroEmprestimoLivro - 1).isDisponivel() == "INDISPONIVEL") {
                        System.out.println("LIVRO INDISPONIVEL, ESCOLHA OUTRO");
                    } else {
                        // Pega livro diretamente da lista da biblioteca com seu numero de index
                        user.emprestaLivro(biblioteca.getListaLivros().get(numeroEmprestimoLivro - 1));
                    }
                }
            } while (numeroEmprestimoLivro > biblioteca.getListaLivros().size());
        } else if (opcao == 2) {
            // Volta para funcao anterior
            interfaceInicial(user, biblioteca);
        }
    }

    // Interface devolucao livro
    public static void devolucaoLivro(User user, Biblioteca biblioteca) {
        int opcao = 0;
        do {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║   Opções:                                      ║");
            System.out.println("║   [1] Devolver Livro                           ║");
            System.out.println("║   [2] Voltar                                   ║");
            System.out.println("╚════════════════════════════════════════════════╝");
            System.out.print("Escolha uma opção: ");
            opcao = model.ScannerGlobal.scanner.nextInt();
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1) {
            System.out.println("Digite o numero do livro a ser devolvido: ");

            // Declara variavel para numero do livro desejado
            int numeroDevolucaoLivro = model.ScannerGlobal.scanner.nextInt();

            // Caso numero seja maior que a quantidade de livros na lista
            if (numeroDevolucaoLivro > user.getListaLivros().size()) {
                System.out.println("Irmao nem vem com essa que aqui ce nao passa nao");
            }
            // Devolucao
            else {
                user.devolveLivro(user.getListaLivros().get(numeroDevolucaoLivro - 1));
            }

        } else if (opcao == 2) {
            // Volta para funcao anterior
            interfaceInicial(user, biblioteca);
        }
    }

    // MAIN
    public static void main(String[] args) throws Exception {
        Biblioteca biblioteca = new Biblioteca();

        // Criando os livros com a referência da biblioteca
        Livro livro1 = new Livro("Entendendo Algoritmos", "Aditya Bhargava", "TEC006", biblioteca);

        Livro livro2 = new Livro("Arquitetura Limpa", "Robert C. Martin", "TEC007", biblioteca);

        Livro livro3 = new Livro("O Programador Pragmático", "Andrew Hunt e David Thomas", "TEC008", biblioteca);

        Livro livro4 = new Livro("Python Fluente", "Luciano Ramalho", "TEC009", biblioteca);

        Livro livro5 = new Livro("Refatoração: Aperfeiçoando o Design de Códigos Existentes", "Martin Fowler", "TEC010",
                biblioteca);

        // Criando o usuário fictício
        User usuario1 = new User("bruno", "123", biblioteca);

        // inicio
        interfaceBemVindo(biblioteca);
    }
}

// ate agora ja ta com todos os erros de usuario corrigido, ja ta emprestando e
// devolvendo os livros, falta fazer o cadastro e acaba