package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Book book = new Book("Life", "Bohdan", 2025);
        book.displayBookInfo();

        book.setAuthor("Nestor");
        System.out.println("New Author: " + book.getAuthor());
    }
}