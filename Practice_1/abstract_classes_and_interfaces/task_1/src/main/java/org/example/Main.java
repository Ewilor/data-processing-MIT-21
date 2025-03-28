package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Appliance washing_machine = new WashingMachine();
        Appliance microwave = new Microwave();

        washing_machine.turnOn();
        microwave.turnOn();
    }
}
