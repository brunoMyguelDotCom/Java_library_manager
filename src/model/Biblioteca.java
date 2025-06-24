package model;

import java.util.ArrayList;

public class Biblioteca {
    private String nomeBiblioteca;
    public ArrayList<User> listaUsers;
    public ArrayList<Livro> listaLivros;

    public Biblioteca() {
        this.nomeBiblioteca = "BIBLIOTECA TOP";
        this.listaUsers = new ArrayList<>();
        this.listaLivros = new ArrayList<>();
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public ArrayList<User> getListaUsers() {
        return listaUsers;
    }

    public void addUserBiblioteca(User user) {
        listaUsers.add(user);
    }

    public void addLivroBiblioteca(Livro livro) {
        listaLivros.add(livro);
    }

}
