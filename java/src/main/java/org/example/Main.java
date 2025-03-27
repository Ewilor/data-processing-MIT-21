package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/data.json";

        // Перевірка, чи існує файл
        System.out.println("Файл існує? " + Files.exists(Paths.get(path)));

        // Спроба прочитати файл
        try {
            String json = new String(Files.readAllBytes(Paths.get(path)));
            System.out.println("Зміст файлу: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}