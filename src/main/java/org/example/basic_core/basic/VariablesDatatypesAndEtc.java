package org.example.basic_core.basic;

public class VariablesDatatypesAndEtc {
    public static void main(String[] args) {
        task1();
        task2();
    }

    /**
     * Присвоить переменной a значение переменной b и наоборот.
     */
    private static void task1() {
        int a = 5;
        int b = 10;

        a = a + b; // a = 15
        b = a - b; // b = 5
        a = a - b; // a = 10
        // т.е., в одном храним сумму двух чисел, а в другой сеттим разницу суммы и изначального значения 2 переменной

        System.out.println("a = " + a + ", b = " + b);
    }

    /**
     * Используя
     * <p>
     * Переменную типа String;
     * Несколько переменных типа char;
     * Одну переменную типа char.
     * вывести свое имя в консоль.
     */
    private static void task2() {
        char ch = 'Ю';
        System.out.println(ch);
        ch = 'л';
        System.out.println(ch);
        ch = 'и';
        System.out.println(ch);
        ch = 'я';
        System.out.println(ch);

        String name = """
                Ю
                л
                и
                я
                """;
        System.out.println(name);

        char ch1 = 'Ю';
        char ch2 = 'л';
        char ch3 = 'и';
        char ch4 = 'я';
        System.out.print(ch1 + "\n" + ch2 + "\n" + ch3 + "\n" + ch4);

    }
}
