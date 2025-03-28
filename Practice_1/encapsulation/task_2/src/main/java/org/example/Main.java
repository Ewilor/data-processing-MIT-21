package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main  {
    public static void main(String[] args)
    {
        Account account = new Account("4343 4343 4343 4343");
        account.displayAccountInfo();
        System.out.println();
        account.addMoney(999.9);
        account.withdrawMoney(111.9);
        System.out.println();
        account.displayAccountInfo();
    }
}