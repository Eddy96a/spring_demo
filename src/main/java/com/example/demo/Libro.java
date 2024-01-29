package com.example.demo;

public class Libro {
    private String autore;
    private String titolo;

    public Libro() {

    }
    public Libro(String autore, String titolo) {
        this.autore = autore;
        this.titolo = titolo;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return this.autore;
    }

    public String getTitolo() {
        return this.titolo;
    }
}
