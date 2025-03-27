package org.example.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = initEmployees();

        employees = employees.stream()
                .filter(e -> e.getAge() >= 30 &&
                        e.getAge() <= 50 && e.getSalary() >= 60000)
                .toList();

        System.out.println("1) Оставить только тех сотрудников, у которых возраст от 30 до 50 лет и зарплата выше 60,000. (John, Bob, Charlie, David)");
        employees.forEach(System.out::println);

        System.out.println("2) Извлечь все названия проектов из списка сотрудников в одном потоке. (Website, Mobile App, Game, Mobile App, Game, Website, Enterprise App, Mobile App, Game)");
        employees.stream()
                .flatMap(e -> e.getProjects().stream()
                        .map(Project::getName))
                .forEach(System.out::println);

        System.out.println("3) Извлечь только те проекты, длительность которых больше 6 месяцев. ('Game'[7], 'Game'[7], 'Enterprise App'[12], 'Game'[7]");
        employees.stream()
                .flatMap(e -> e.getProjects().stream()
                        .filter(p -> p.getDuration() > 6))
                .forEach(System.out::println);

        System.out.println("4) Преобразовать все названия проектов в верхний регистр. (WEBSITE, MOBILE APP, GAME, MOBILE APP, GAME, WEBSITE, ENTERPRISE APP, MOBILE APP, GAME)");
        employees.stream()
                .flatMap(e -> e.getProjects().stream()
                        .map(p -> p.getName().toUpperCase()))
                .forEach(System.out::println);

        System.out.println("5) Удалить дублирующиеся названия проектов. (Website, Mobile App, Game, Enterprise App)");
        employees.stream()
                .flatMap(e -> e.getProjects().stream()
                        .map(Project::getName)).distinct()
                .forEach(System.out::println);

        System.out.println("6) Сортировать проекты по длительности (по убыванию). ('Enterprise App'[12], 'Game'[7], 'Mobile App'[5], 'Website'[2])");
        employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .sorted((p1, p2) -> Integer.compare(p2.getDuration(), p1.getDuration()))
                .distinct()
                .forEach(System.out::println);

        System.out.println("7) Собрать результат в структуру данных, где: Ключом будет проект (название), Значением будет средняя длительность всех проектов с таким названием, где участвовали сотрудники из первого шага. (Enterprise App: 12.0, Game: 7.0, Website: 2.0, Mobile App: 5.0)");
        employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .collect(Collectors.groupingBy(Project::getName, Collectors.averagingInt(Project::getDuration)))
                .forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static List<Employee> initEmployees() {
        List<Employee> employees = new ArrayList<>();

        Project website = new Project("Website", 2);
        Project mobileApp = new Project("Mobile App", 5);
        Project enterpriseApp = new Project("Enterprise App", 12);
        Project game = new Project("Game", 7);

        employees.add(new Employee("John", 39, List.of(website, mobileApp, game), 85000.6));
        employees.add(new Employee("Alice", 28, List.of(enterpriseApp), 76500.9));
        employees.add(new Employee("Bob", 35, List.of(mobileApp, game), 95000.2));
        employees.add(new Employee("Charlie", 47, List.of(website, enterpriseApp), 100000.3));
        employees.add(new Employee("David", 30, List.of(mobileApp, game), 77122.3));
        employees.add(new Employee("Eve", 20, List.of(website, mobileApp), 28000));
        employees.add(new Employee("Mike", 45, List.of(enterpriseApp), 32000));
        employees.add(new Employee("Sarah", 55, List.of(website, enterpriseApp, game), 80000));

        return employees;
    }
}

