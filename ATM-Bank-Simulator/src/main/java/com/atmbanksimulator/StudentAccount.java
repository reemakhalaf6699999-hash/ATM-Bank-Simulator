package com.atmbanksimulator;

public class StudentAccount extends BankAccount {

    private int dailyLimit = 50;      // Maximum withdrawal per day
    private int withdrawnToday = 0;   // Amount withdrawn so far today

    // Constructor
    public StudentAccount(String accNumber, String accPasswd, int balance) {
        super(accNumber, accPasswd, balance);
    }

    // Override withdraw method to enforce daily limit
    @Override
    public boolean withdraw(int amount) {
        // Check if this withdrawal would exceed daily limit
        if (withdrawnToday + amount > dailyLimit) {
            return false;  // Exceeds daily limit
        }

        // Try to withdraw from parent class
        boolean success = super.withdraw(amount);

        // If successful, update withdrawn amount
        if (success) {
            withdrawnToday += amount;
        }

        return success;
    }

    // Get remaining daily limit
    public int getRemainingLimit() {
        return dailyLimit - withdrawnToday;
    }

    // Get amount withdrawn today
    public int getWithdrawnToday() {
        return withdrawnToday;
    }

    // Reset daily limit (call this each new day)
    public void resetDailyLimit() {
        withdrawnToday = 0;
    }

    // Display account info
    @Override
    public String toString() {
        return "Student Account: " + getAccNumber() +
                " | Balance: $" + getBalance() +
                " | Daily Limit Remaining: $" + getRemainingLimit();
    }
}