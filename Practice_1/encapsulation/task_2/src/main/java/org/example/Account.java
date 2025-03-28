package org.example;

public class Account  {
    private double balance;
    private String accountNumber;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
    }

    public void addMoney(double money) {
        balance += money;
        System.out.println("Added money: " + money);
        System.out.println("Current balance: " + balance);
    }

    public void withdrawMoney(double amount) {
        balance -= amount;
        System.out.println("Withdrawed: " + amount);
        System.out.println("Current balance: " + balance);
    }

    public void displayAccountInfo() {
        System.out.println(
            "Account number: " + accountNumber +
            "\nBalance: " + balance
        );
    }
}
