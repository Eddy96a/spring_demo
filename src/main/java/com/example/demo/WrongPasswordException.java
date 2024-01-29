package com.example.demo;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super("errore di password errata");
    }
}
