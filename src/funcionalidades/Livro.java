package funcionalidades;

public class Livro {

    private String titulo;
    private String autor;
    private String codigo;
    private String disponivel;

    public Livro(String titulo, String autor, String codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.disponivel = "DISPONIVEL";
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

    public void exibeInfosToBiblioteca() {
        System.out.println("""
                Titulo: %s
                Autor: %s
                Codigo: %s
                Disponivel: %s
                """.formatted(this.titulo, this.autor, this.codigo, disponivel));
    }

    public void exibeInfosToUser() {
        System.out.println("""
                Titulo: %s
                Autor: %s
                Codigo: %s
                """.formatted(this.titulo, this.autor, this.codigo));
    }
}
