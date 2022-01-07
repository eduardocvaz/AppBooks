package com.example.appbooks.model;

public class Livro {
    private String nome;
    private String autor;
    private String genero;
    private int lastPage;
    private int lastLine;
    public Livro(){
        this.autor="";
        this.nome="";
        this.genero="";
        this.lastLine=0;
        this.lastPage=0;
    }
    public Livro(String nome, String autor, String genero, int lastPage, int lastLine) {
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.lastPage = lastPage;
        this.lastLine = lastLine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getLastLine() {
        return lastLine;
    }

    public void setLastLine(int lastLine) {
        this.lastLine = lastLine;
    }
    @Override
    public String toString(){

        return nome;
    }
}
