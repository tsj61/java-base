package org.example.basic_core.basic;

import java.util.Scanner;

public class TypeCastingAndConditionalOperators {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
    }

    /**
     * Ввести с клавиатуры два целых числа. Если Число1 четное, вывести произведение двух чисел, если нет - частное.
     * <p>
     * Также если числа равны - вывести надпись Числа равны!
     */
    private static void doTask1() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        if (a % 2 == 0) {
            System.out.println(a * b);
        } else {
            System.out.println(a / b);
        }

        if (a == b) {
            System.out.println("Числа равны!");
        }
    }

    /**
     * Написать программу, которая принимает строку с клавиатуры:
     * <p>
     * Если введенная строка равна Hi - вывести в консоль Hello; <p>
     * Если Bye - Good bye; <p>
     * Если How are you - How are your doing; <p>
     * Если любая другая строка - вывести Unknown message. <p>
     * Реализуйте решение через:
     * <p>
     * if-else;
     * switch-case
     */
    private static void doTask2() {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();

        if (string.equals("Hi")) {
            System.out.println("Hello");
        } else if (string.equals("Bye")) {
            System.out.println("Good bye");
        } else if (string.equals("How are you")) {
            System.out.println("How are your doing");
        } else {
            System.out.println("Unknown message");
        }

        switch (string) {
            case "Hi" -> System.out.println("Hello");
            case "Bye" -> System.out.println("Good bye");
            case "How are you" -> System.out.println("How are your doing");
            default -> System.out.println("Unknown message");
        }
    }

    /**
     * Заведите три переменные типа String. С клавиатуры введите в них вашу фамилию, имя и отчество соответственно.
     * <p>
     * Выведите в консоль ваше ФИО в одну строку.
     */
    private static void doTask3() {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        String lastName = scanner.nextLine();
        String surname = scanner.nextLine();

        System.out.println(name + " " + lastName + " " + surname);

        System.out.printf("%s %s %s%n", name, lastName, surname);
    }

    /**
     * Введите с клавиатуры два целых числа. Если первое – четное ИЛИ второе – кратно трем, выведите в консоль результат сравнения этих чисел в любом формате. Например, Число1 больше Числа2. Или true (если числа равны) и false - если нет.
     * <p>
     * Если первое число кратно и двум, и трем – также выведите на экран число один, возведенное в степень N, где N – второе число. Для возведения в степень можно использовать Math.pow(). В случае, если результат выражения выходит за пределы типа int (допустимые значения - [-2147483648; 2147483647]) – вывести сообщение Результат выражения слишком большой!.
     * <p>
     * Также минимальное и максимальное значение int содержится в константах Integer.MIN_VALUE и Integer.MAX_VALUE соответственно.
     * <p>
     */

    private static void doTask4() {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.close();

        if (a < Integer.MIN_VALUE || a > Integer.MAX_VALUE) {
            System.out.println("Результат выражения слишком большой!");
        }

        if (a % 2 == 0 || b % 3 == 0) {
            System.out.println(a == b);
        }

        if (a % 2 == 0 && a % 3 == 0) {
            double result = Math.pow(a, b);
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                System.out.println("Результат выражения слишком большой!");
            } else {
                System.out.println((int) result);
            }
        }
    }
}
