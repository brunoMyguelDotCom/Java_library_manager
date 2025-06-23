package funcionalidades;

import java.util.ArrayList;

public class User {
    private String nome;
    private String cpf;
    public ArrayList<Livro> listaLivros;
    private Biblioteca biblioteca;

    public User(String nome, String cpf, Biblioteca biblioteca) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaLivros = new ArrayList<>();
        // Adiciona usuario a lista da biblioteca
        this.biblioteca = biblioteca;
        this.biblioteca.addUserBiblioteca(this);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }   

    public void emprestaLivro(Livro emprestaLivro) {
        // Verifica se a lista ja contem 3 livros emprestados
        if (listaLivros.size() < 3) {
            emprestaLivro.setDisponivel("INDISPONIVEL");
            listaLivros.add(emprestaLivro);

            /*
             * Informa sobre o emprestimo feito com sucesso,
             * dizendo nome do livro e quantidade emprestados atualmente pelo usuario
             */
            System.out.println("LIVRO: \"%s\" EMPRESTADO COM SUCESSO!\nVOCE TEM %d LIVRO(S) EMPRESTADO(S)"
                    .formatted(emprestaLivro.getTitulo(), listaLivros.size()));
        }
        // Tratamento de erro: Numero maximo de livros emprestados
        else {
            System.out.println("Voce ja tem 3 livros emprestados, devolva ao menos 1 livro para emprestar um novo!");
        }
    }

    public void devolveLivro(Livro devolveLivro) {
        // Verifica se o livro esta na lista
        if (listaLivros != null && listaLivros.contains(devolveLivro)) {
            listaLivros.remove(devolveLivro);
            devolveLivro.setDisponivel("DISPONIVEL");

            /*
             * Informa sobre a devolucao feita com sucesso,
             * dizendo nome do livro e quantidade total emprestados atualmente pelo usuario
             */
            System.out.println("LIVRO: \"%s\" DEVOLVIDO COM SUCESSO!\nVOCE TEM %d LIVRO(S) EMPRESTADO(S)"
                    .formatted(devolveLivro.getTitulo(), listaLivros.size()));
        }
        // Tratamento de erro: Livro nao emprestado
        else {
            System.out.println("O Livro nao foi emprestado! Impossivel devolver!");
        }
    }

    public void exibeEmprestados() {
        System.out.println("""
                ╔════════════════════════════════════════════════════════════╗
                ║                    LIVROS EMPRESTADOS                     ║
                ╠════════════════════════════════════════════════════════════╣
                ║  NUMERO DE LIVRO(S) EMPRESTADO(S): %-24d        ║
                ╚════════════════════════════════════════════════════════════╝
                """.formatted(listaLivros.size()));

        // ForEach para exibir livro por livro dentro da lista
        for (Livro livroExibir : listaLivros) {
            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.printf("║ LIVRO Nº: %-38s ║%n", listaLivros.indexOf(livroExibir) + 1);
            System.out.println("╚════════════════════════════════════════════════╝\n");

            livroExibir.exibeInfosToUser();

            System.out.println("╔════════════════════════════════════════════════╗");
            System.out.println("║               FIM DO LIVRO ACIMA               ║");
            System.out.println("╚════════════════════════════════════════════════╝\n");
        }
    }

    public void interfaceInicial() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║ Livros emprestados:           [  %d  ]         ║".formatted(listaLivros.size()));
        System.out.println("║ Empréstimos restantes:        [  %d  ]         ║".formatted(3 - listaLivros.size()));
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.println("║   Opções:                                      ║");
        System.out.println("║   [1] Listar livros disponíveis                ║");
        System.out.println("║   [2] Ver livros emprestados                   ║");
        System.out.println("║   [3] Sair                                     ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.print("Escolha uma opção: ");
    }

}
