package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Employee", "QA");
        Manager manager = new Manager("Manager", "CEO", 3);

        employee.displayInfo();
        System.out.println();
        manager.displayInfo();
    }
}