package com.example.demo;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("utente non trovato ");
    }
}
