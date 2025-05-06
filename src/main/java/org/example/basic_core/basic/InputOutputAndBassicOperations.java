package org.example.basic_core.basic;

import java.util.Scanner;

public class InputOutputAndBassicOperations {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
    }

    /**
     * Введите с клавиатуры вещественные числа a и b. Выведите на экран результат выражения
     * <p>
     * c = ba(a + b)/(a2)
     * <p>
     * Совпадает ли результат выражения, если a и b — переменные типа int (для проверки не забудьте также использовать подходящий метод Scanner)?
     */
    private static void doTask1() {
        Scanner scanner = new Scanner(System.in);
        float a = scanner.nextFloat();
        float b = scanner.nextFloat();
        scanner.close();
        System.out.print(b * a * (a + b) / Math.pow(a, 2));
    }

    /**
     * Введите с клавиатуры целые числа a и b. Выведите на экран результат сравнения:
     * <p>
     * a3 > b2
     */
    private static void doTask2() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.print(Math.pow(a, 3) > Math.pow(b, 2));
        scanner.close();
    }

    private static void doTask3() {
        int a = 1;
        int b = a++;
        b += a++;
        System.out.println(b);
    }
}
