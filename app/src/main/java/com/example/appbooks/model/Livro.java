package com.example.appbooks.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Livro implements Serializable {
    private int id;
    private String nome;
    private String autor;
    private String genero;
    private int lastPage;
    private int lastLine;
    private Date modificacao;
    public Livro(){
        this.id = IdGenerator.nextId();
    }
    public Livro(String nome, String autor, String genero, int lastPage, int lastLine) {
        this.id = IdGenerator.nextId();
        this.nome = nome;
        this.autor = autor;
        this.genero = genero;
        this.lastPage = lastPage;
        this.lastLine = lastLine;
        this.modificacao = new Date();
    }

    public int getId() {
        return id;
    }
    public String getModificacao(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return formatter.format(this.modificacao);
    }
    public void setModificacao(){
        this.modificacao = new Date();
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
