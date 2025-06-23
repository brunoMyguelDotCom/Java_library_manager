package funcionalidades;

public class Livro {

    private String titulo;
    private String autor;
    private String codigo;
    private String disponivel;
    private Biblioteca biblioteca;

    public Livro(String titulo, String autor, String codigo, Biblioteca biblioteca) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponivel = "DISPONIVEL";
        // Adiciona livro a lista da biblioteca
        this.biblioteca = biblioteca;
        this.biblioteca.addLivroBiblioteca(this);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(String isDisponivel) {
        this.disponivel = isDisponivel;
    }

    /*
    // Exibe informacoes do livro COM status de disponibilidade
    public void exibeInfosToBiblioteca() {
    System.out.println("╔════════════════════════════════════════════════╗");
    System.out.println("║              INFORMAÇÕES DO LIVRO              ║");
    System.out.println("╠════════════════════════════════════════════════╣");
    System.out.printf("║ Título:     %-35s ║%n", this.titulo);
    System.out.printf("║ Autor:      %-35s ║%n", this.autor);
    System.out.printf("║ Código:     %-35s ║%n", this.codigo);
    System.out.printf("║ Disponível: %-35s ║%n", disponivel);
    System.out.println("╚════════════════════════════════════════════════╝");
    }
 */

    // Exibe informacoes do livro SEM status de disponibilidade
    public void exibeInfosToUser() {
        System.out.println("╔════════════════════════════════════════════════╗");
    System.out.println("║              INFORMAÇÕES DO LIVRO              ║");
    System.out.println("╠════════════════════════════════════════════════╣");
    System.out.printf("║ Título:     %-35s ║%n", this.titulo);
    System.out.printf("║ Autor:      %-35s ║%n", this.autor);
    System.out.printf("║ Código:     %-35s ║%n", this.codigo);
    System.out.println("╚════════════════════════════════════════════════╝");
    }
}
