package model;

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
}
