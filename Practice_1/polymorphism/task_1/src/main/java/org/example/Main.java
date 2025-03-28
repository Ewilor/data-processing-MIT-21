package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Shape triangle = new Triangle(16, 3);
        Shape square = new Square(8);

        triangle.shapeArea("Triangle");
        square.shapeArea("Square");
    }
}
