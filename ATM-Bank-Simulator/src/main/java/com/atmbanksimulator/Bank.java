//IGNORE - Git Commit test 
// edits today
package com.atmbanksimulator;

public class Bank {
    private int maxAccounts = 10;
    private int numAccounts = 0;
    private BankAccount[] accounts;
    private BankAccount loggedInAccount;


    public enum AccountType {
        STANDARD, STUDENT, PRIME, SAVING
    }

    public Bank() {
        this.accounts = new BankAccount[this.maxAccounts];
        this.loggedInAccount = null;
    }


    public BankAccount makeBankAccount(String accNumber, String accPasswd, int balance, AccountType type) {
        switch (type) {
            case STUDENT:
                return new StudentAccount(accNumber, accPasswd, balance);
            default:
                return new BankAccount(accNumber, accPasswd, balance);
        }
    }

    public boolean addBankAccount(BankAccount a) {
        if (this.numAccounts < this.maxAccounts) {
            this.accounts[this.numAccounts] = a;
            ++this.numAccounts;
            return true;
        } else {
            return false;
        }
    }


    public boolean addBankAccount(String accNumber, String accPasswd, int balance, AccountType type) {
        return this.addBankAccount(this.makeBankAccount(accNumber, accPasswd, balance, type));
    }

    public boolean login(String accountNumber, String password) {
        this.logout();
        for(BankAccount b : this.accounts) {
            if (b != null && b.getAccNumber().equals(accountNumber) && b.getaccPasswd().equals(password)) {
                this.loggedInAccount = b;
                return true;
            }
        }
        this.loggedInAccount = null;
        return false;
    }

    public void logout() {
        if (this.loggedIn()) {
            this.loggedInAccount = null;
        }
    }

    public boolean loggedIn() {
        return this.loggedInAccount != null;
    }

    public boolean deposit(int amount) {
        return this.loggedIn() ? this.loggedInAccount.deposit(amount) : false;
    }

    public boolean withdraw(int amount) {
        return this.loggedIn() ? this.loggedInAccount.withdraw(amount) : false;
    }

    public int getBalance() {
        return this.loggedIn() ? this.loggedInAccount.getBalance() : -1;
    }
}

// I am making more changes
//more changes
