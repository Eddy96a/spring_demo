package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class AccountManager {

    private static AccountManager instance = null;
    private Account currentAccount = null;
    public List<Account> accounts = new ArrayList<>();

    private AccountManager() {
        loadDatabase();
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }
    public Account getCurrentAccount() {
        return this.currentAccount;
    }
    private void loadDatabase() {
        System.out.println("Loanding database");
        Account a1 = new Account("Mario","Tino","mario","589", true);
        a1.addLibro(new Libro("Mario Rossi", "Il libro di Mario"));
        a1.addLibro(new Libro("Mario Rossi", "Paura delle formiche"));

        Account a2 = new Account("Luigi","Fillo","luigi","243", false);
        a2.addLibro(new Libro("Luigi Fillo", "Diario di Fillo"));
        a2.addLibro(new Libro("Luigi Fillo", "Orient Express , la vendetta"));
        a2.addLibro(new Libro("Luigi Fillo", "Al bar con il cane"));

        Account a3 = new Account("Giovanni","Franco","giovanni","796", false);
        a3.addLibro(new Libro("Giovanni Franco", "Giovannone il gran ciccione"));


        accounts.add(a1);
        accounts.add(a2);
        accounts.add(a3);

    }

    public boolean isUsernameExisting(String username){
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                return true;
            }
        }
        System.out.println("Non ho trovatto nessuno");
        return false;
    }

    public Account login(String username, String password) throws UserNotFoundException, WrongPasswordException {
        if (!isUsernameExisting(username)){
            System.out.println("Sto lacindo un eccesione");
            throw new UserNotFoundException();
        }
        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)){
                this.currentAccount = account;
                return account;
            }
        }
        throw new WrongPasswordException();
    }

}
