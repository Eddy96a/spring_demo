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
        accounts.add(new Account("Mario","Tino","mario","589"));
        accounts.add(new Account("Luigi","Fillo","luigi","243"));
        accounts.add(new Account("Giovanni","Franco","giovanni","796"));

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
