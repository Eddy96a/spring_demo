package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private static final String PASSWORD = "465";
    private static final String USERNAME = "admin";
    private static final String USERNAME_PASSWORD = "123";

    @GetMapping("/checkCode")
    public boolean checkCode(@RequestParam String password) {
        System.out.println("password = "+ password);
        if (password.equals(PASSWORD)){
            return true;
        }else {
            return false;
        }
    }

    @GetMapping("/login")
    public Account login(@RequestParam String username, @RequestParam String password) throws UserNotFoundException, WrongPasswordException {
        System.out.println("username: "+ username);
        System.out.println("password: "+ password);
        return AccountManager.getInstance().login(username, password);

    }
    @GetMapping("/books")
    public List<Libro> getBooks(@RequestParam String username) throws UserNotFoundException {
        return AccountManager.getInstance().getLibri(username);
    }
}
