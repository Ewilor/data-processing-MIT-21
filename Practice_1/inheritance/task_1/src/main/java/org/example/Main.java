package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehicle car = new Vehicle("Vehicle", "Vehicle model");
        Motorcycle motorcycle = new Motorcycle("Motorcycle", "Motorcycle model", 200);
        car.displayInfo();
        System.out.println();
        motorcycle.displayInfo();
    }
}