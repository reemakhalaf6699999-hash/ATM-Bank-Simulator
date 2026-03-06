package com.atmbanksimulator;

public class StudentAccount extends BankAccount {

    private final int dailyLimit = 50; // final added
    private int withdrawnToday = 0;

    public StudentAccount(String accNumber, String accPasswd, int balance) {
        super(accNumber, accPasswd, balance);
    }

    @Override
    public boolean withdraw(int amount) {
        if (withdrawnToday + amount > dailyLimit) {
            return false;
        }

        boolean success = super.withdraw(amount);

        if (success) {
            withdrawnToday += amount;
        }

        return success;
    }

    // The method is kept as is, or you can delete it if you're sure you won't use it
    public int getRemainingLimit() {
        return dailyLimit - withdrawnToday;
    }
}