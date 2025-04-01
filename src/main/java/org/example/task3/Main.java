package org.example.task3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    private static final String FILE_NAME = "employee.txt";
    private static final String FILE_NAME2 = "employee2.txt";

    public static void main(String[] args) {
        String employees = readFile(FILE_NAME);
        System.out.println("Вариант из файла: " + employees);

        Employee employee = new Employee("Иванов", "Иван", 23, 100000);
        writeToFile(FILE_NAME2, employee);
        String newEmployee = readObjectFromFile(FILE_NAME2);
        System.out.println("Записанный объект: " + newEmployee);

    }

    private static void writeToFile(String fileName, Employee employee) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employee);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readObjectFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Employee empl = (Employee) ois.readObject();
            return empl.toString();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (reader.ready()) {
                stringBuilder.append(reader.readLine()).append("\n");
            }
            return stringBuilder.toString();

        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
