package funcionalidades;

import java.util.ArrayList;

public class User {
    private String nome;
    private String cpf;
    public ArrayList<Livro> listaLivros;

    public User(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.listaLivros = new ArrayList<>();
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

                ___________________________________

                * NUMERO DE LIVRO(S) EMPRESTADO(S): %d
                """.formatted(listaLivros.size()));

        // ForEach para exibir livro por livro dentro da lista
        for (Livro livroExibir : listaLivros) {
            System.out.print("***********************\n\n");

            System.out.println("LIVRO Nº: %d:".formatted(listaLivros.indexOf(livroExibir) + 1));

            System.out.print("\n\n");

            livroExibir.exibeInfosToUser();

            System.out.print("***********************\n\n");
        }
    }
}
