package com.example.demo;

import java.util.Objects;

public class Account {
    private String nome;
    private String cognome;
    private String username;
    private String password;

    public Account() {

    }
    public Account(String nome, String cognome, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            throw new RuntimeException();
        }
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        if (cognome == null || cognome.isEmpty()) {
            throw new RuntimeException();
        }
        this.cognome = cognome;
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new RuntimeException();
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new RuntimeException();
        }
        this.password = password;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(nome, account.nome) && Objects.equals(cognome, account.cognome) && Objects.equals(username, account.username) && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, username, password);
    }
}
