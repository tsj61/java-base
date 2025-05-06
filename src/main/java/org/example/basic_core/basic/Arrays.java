package org.example.basic_core.basic;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
    }

    /**
     * Создать массив char, заполненный буквами своего имени в верном порядке. Используя этот массив, вывести свое имя в консоль.
     * <p>
     * Вариант 1: не используя переменную типа String;
     * Вариант 2: предварительно собрав значения массива в переменную типа String.
     */
    private static void doTask1() {
        char[] chars = {'Ю', 'л', 'и', 'я'};
        for (char ch : chars) {
            System.out.print(ch);
        }

        System.out.println();

        StringBuilder s = new StringBuilder();
        for (char ch : chars) {
            s.append(ch);
        }
        System.out.println(s);
    }


    /**
     * Создать массив int из 5 элементов. Заполнить его значениями, введенными с клавиатуры. Вывести на экран сумму каждого значения с предыдущим. Предыдущим значением для 0-го (нулевого) элемента считать последнее значение массива.
     */
    private static void doTask2() {
        int[] array = new int[5];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        scanner.close();

        int previous = 0;
        for (int k : array) {
            int result = k + previous;
            System.out.print(result + " ");
            previous = k;
        }
        System.out.println();
    }

    /**
     * Вычислить и записать в массив первые 10 простых чисел.
     * <p>
     * Простое число – положительное целое число, которое делится без остатка лишь на себя и на 1. 1 не является простым числом.
     * <p>
     * Вывести в консоль сумму всех элементов полученного массива.
     */
    private static void doTask3() {
        int[] primeNumbers = new int[10];

        for (int i = 0; i < primeNumbers.length; i++) {
            if (i == 0) {
                //Первое простое число очевидно, поскольку оно следующее за 1 и других делителей иметь не может
                primeNumbers[i] = 2;
            } else {
                //В рамках этого блока ищем простые числа только среди нечетных. Единственное четное простое число найдено в предыдущем блоке
                int addingValue = i == 1 ? 1 : 2;
                int number = primeNumbers[i - 1] + addingValue;
                //0 - значение элемента массива int'ов по умолчанию. Если значение все еще 0 - мы не нашли простое число
                while (primeNumbers[i] == 0) {
                    int j = 0;
                    boolean isPrime = true;
                    //Перебираем все простые делители из массива, которые меньше половины текущего числа. Составные делители проверять нет смысла - они состоят из простых.
                    //Перебирать делители, большие половины числа смысла нет - деления нацело не будет. При number / primeNumbers[j] == 1 делитель уже больше, чем 0.5*number.
                    while (isPrime && j < i && number / primeNumbers[j] > 1) {
                        //Если число поделилось на простой делитель - оно составное. Проверять остальные делители смысла не имеет
                        if (number % primeNumbers[j] == 0) {
                            isPrime = false;
                        } else {
                            //В ином случае переходим к следующему делителю
                            j++;
                        }
                    }
                    //Если проверили все подходящие делители, а флаг еще true - число простое
                    if (isPrime) {
                        primeNumbers[i] = number;
                    } else {
                        //Если текущее число не подошло - переходим к следующему нечетному
                        number += 2;
                    }
                }
            }
        }

        int result = 0;

        for (int i : primeNumbers) {
            result += i;
        }

        System.out.println(result);
    }

    private static void doTask4() {
        int[] arr1 = new int[5]; // сразу выделена память под 5 элементов
        int[] arr2 = new int[]{1, 2, 3, 4, 5}; // анонимное создание массива

        String[] nums = new String[5];
        for (String s : nums) {
            s = "!";
            System.out.println(s);
        }

        for (String s : nums) {
            System.out.println(s);
        }
        // получим 5 ! и 5 null, т.к. это immutable и при изменении значения, фактически, создается новый объект
    }
}
