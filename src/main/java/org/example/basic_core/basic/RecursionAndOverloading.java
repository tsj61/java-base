package org.example.basic_core.basic;

import java.util.Scanner;

public class RecursionAndOverloading {
    public static void main(String[] args) {
        doTask1();
        doTask2();
        doTask3();
        doTask4();
    }

    /**
     * Написать программу, которая объединяет любое количество строк, объединяя их через пробел. Реализацию конкатенации строк вынести в отдельный метод.
     */
    private static void doTask1() {
        System.out.println(concatStrings("one", "two", "three", "four"));
    }

    private static String concatStrings(String... strings) {
        StringBuilder result = new StringBuilder();
        for (String string : strings) {
            result.append(string).append(" ");
        }
        return result.toString();
    }

    /**
     * Реализовать методы «вычисления суммы» для всех примитивных типов, кроме void. Возвращать:
     * <p>
     * Для числовых типов — тот же тип. Даже если это ведет к потере точности. При угрозе потери данных — выводить сообщение в консоль и возвращать текущий результат (для byte, short, int);
     * Для boolean — определение истинности всех переданных параметров, принимая то, что их стоит объединять через логическое И;
     * Для char — строку, полученную в результате конкатенации всех переданных параметров.
     * Количество параметров может быть любым. Используйте перегрузку — у всех методов должны быть одинаковые названия.
     */
    private static void doTask2() {
        System.out.println(sum(1L, 2L, 3L));
        System.out.println(sum(1, 2, 3));
        System.out.println(sum((short) 1, (short) 2, (short) 3));
        System.out.println(sum((byte) -120, (byte) 2, (byte) -30));
        System.out.println(sum(1d, 2d, 3d));
        System.out.println(sum(1f, 2f, 3f));
        System.out.println(sum(true, false, true));
        System.out.println(sum('1', '2', '3'));
    }

    /**
     * Вычислите факториал введенного с клавиатуры целого числа, используя рекурсивный алгоритм.
     */
    private static void doTask3() {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        scanner.close();

        if (a < 0) {
            System.out.println("The number must be at least 0");
            return;
        }

        System.out.println(getFactorial(a));
    }

    /**
     * Вычислите результат выражения, используя рекурсивный алгоритм. n — число, введенное с клавиатуры. Для N < 1 — вывести соответствующее сообщение в консоль и завершить выполнение программы.
     * Выражение: √(1 + √(2 + ... + √n)))
     */
    private static void doTask4() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println("The number must be at least 1");
            return;
        }

        System.out.println(calculateExpression(n));

    }

    static double calculateExpression(int number) {
        return calculateExpression(1, number);
    }

    static double calculateExpression(int number, int maxNumber) {
        if (number == maxNumber) {
            return Math.sqrt(number);
        }

        return Math.sqrt(number + calculateExpression(number + 1, maxNumber));
    }

    private static long getFactorial(int a) {
        if (a == 0) {
            return 1;
        }

        if (a == 1) {
            return 1;
        }

        return a * getFactorial(a - 1);
    }

    private static long sum(long... numbers) {
        long result = 0;
        for (long number : numbers) {
            result += number;
        }
        return result;
    }

    private static int sum(int... numbers) {
        int result = 0;
        for (int number : numbers) {
            if (isBeyondLimit(Integer.MIN_VALUE, Integer.MAX_VALUE, result, number)) {
                System.out.println("Переполнение int. Возврат последнего значения до переполнения");
                return result;
            }
            result += number;
        }
        return result;
    }

    private static short sum(short... numbers) {
        short result = 0;
        for (short number : numbers) {
            if (isBeyondLimit(Short.MIN_VALUE, Short.MAX_VALUE, result, number)) {
                System.out.println("Переполнение short. Возврат последнего значения до переполнения");
                return result;
            }
            result += number;
        }
        return result;
    }

    private static byte sum(byte... numbers) {
        byte result = 0;
        for (byte number : numbers) {
            if (isBeyondLimit(Byte.MIN_VALUE, Byte.MAX_VALUE, result, number)) {
                System.out.println("Переполнение byte. Возврат последнего значения до переполнения");
                return result;
            }
            result += number;
        }
        return result;
    }

    private static double sum(double... numbers) {
        double result = 0;
        for (double number : numbers) {
            result += number;
        }
        return result;
    }

    private static float sum(float... numbers) {
        float result = 0;
        for (float number : numbers) {
            result += number;
        }
        return result;
    }

    private static boolean sum(boolean... booleans) {
        for (boolean b : booleans) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    private static String sum(char... chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static boolean isBeyondLimit(long minLimit, long maxLimit, long currentSum, long term) {
        return (currentSum < minLimit && term < 0) ||
                (currentSum > maxLimit && term > 0) ||
                (currentSum + term < minLimit) ||
                (currentSum + term > maxLimit);
    }

}
