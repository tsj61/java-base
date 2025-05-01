package org.example.basic_core.basic;

import java.util.Scanner;

public class Cycles {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    /**
     * Ввести с клавиатуры целое число. Вывести в консоль его факториал.
     */
    private static void task1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (n < 0) {
            System.out.println("Ошибка: число должно быть неотрицательным");
        } else {
            int result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }

            System.out.println(result);
        }
    }

    /**
     * Ввести с клавиатуры целое число. Вывести в консоль сумму цифр введенного числа.
     */
    private static void task2() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        scanner.close();

        int result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }

        // сумма цифр даже отрицательного числа должна быть положительна
        if (result < 0) {
            result *= -1;
        }

        System.out.println(result);
    }

    /**
     * Написать программу, которая принимает длину и ширину прямоугольника (2 целых числа). Нарисовать в консоли заданный прямоугольник, используя - и |. Углы прямоугольника обозначить символом   (пробел). Каждая единица длины должна обозначаться одним символом -, каждая единица ширины – символом |.
     */
    private static void task3() {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.close();

        StringBuilder horizontalLine = new StringBuilder();
        horizontalLine.append(" ");
        for (int i = 0; i < length; i++) {
            horizontalLine.append("-");
        }
        horizontalLine.append(" \n");

        StringBuilder verticalLinesUnit = new StringBuilder();
        verticalLinesUnit.append("|");
        for (int i = 0; i < length; i++) {
            verticalLinesUnit.append(" ");
        }
        verticalLinesUnit.append("|\n");

        StringBuilder verticalLines = new StringBuilder();
        for (int i = 0; i < width; i++) {
            verticalLines.append(verticalLinesUnit);
        }

        System.out.println(horizontalLine.toString() + verticalLines + horizontalLine);
    }

    /**
     * Ввести с клавиатуры целое число (Число 2). Для каждого из чисел от 1 до 10 выполнить:
     * <p>
     * Если Число1 четное, вывести сумму двух чисел, если нет - разность. Также если числа равны - вывести надпись Числа равны!.
     */
    private static void task4() {
        Scanner scanner = new Scanner(System.in);
        int num2 = scanner.nextInt();
        scanner.close();

        for (int i = 1; i <= 10; i++) {
            if (i == num2) {
                System.out.println("Числа равны!");
            } else {
                if (i % 2 == 0) {
                    System.out.println(num2 + i);
                } else {
                    System.out.println(num2 - i);
                }
            }
        }
    }

    /**
     * Выводить на экран Не угадал! до тех пор, пока с клавиатуры не будет введено число 1. Запрашивать число с клавиатуры:
     * <p>
     * Вариант 1: перед выводом на экран Не угадал!
     * <p>
     * Вариант 2: после вывода на экран Не угадал!
     */
    private static void task5() {
        Scanner scanner = new Scanner(System.in);

        while (scanner.nextInt() != 1) {//Перед каждым выводом фразы будет запрашиваться число
            System.out.println("Не угадал!");
        }

        scanner.close();
    }
}
