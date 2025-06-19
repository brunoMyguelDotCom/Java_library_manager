import funcionalidades.Livro;
import funcionalidades.User;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User("bruno", "numeSei");
        Livro livroPoggers = new Livro("livroMassa", "autorMassa", "codigoMassa");
        Livro livroPoggers2 = new Livro("livroMassa2", "autorMassa2", "codigoMassa2");

        livroPoggers.exibeInfosToBiblioteca();

        user.emprestaLivro(livroPoggers);
        user.emprestaLivro(livroPoggers2);

        user.exibeEmprestados();

        livroPoggers.exibeInfosToBiblioteca();

        user.devolveLivro(livroPoggers);

        livroPoggers.exibeInfosToBiblioteca();

        user.exibeEmprestados();

    }
}
