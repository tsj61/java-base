package org.example.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * "Грокаем алгоритмы" Бхаргава А.
 */
public class AlgorithmService {

    public Integer binarySearch(int number, int[] arr) {
        int lowIndex = 0;
        int highIndex = arr.length - 1;

        Integer result = null;

        while (lowIndex <= highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            int guess = arr[mid];

            if (guess == number) {
                result = mid;
            } else if (guess > number) {
                highIndex = mid - 1;
            } else {
                lowIndex = mid + 1;
            }
        }

        return result;
    }

    /**
     * Учебный пример общий
     */
    public int[] selectionSort(int[] arr) {
        int[] newArr = new int[arr.length];
        int[] arrCopy = arr.clone();

        for (int i = 0; i < arrCopy.length; i++) {
            int smallestIndex = findIndexOfSmallest(arrCopy);
            newArr[i] = arrCopy[smallestIndex];
            arrCopy[smallestIndex] = Integer.MAX_VALUE;
        }

        return newArr;
    }

    private int findIndexOfSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }


    /**
     * Пример для Java
     */
    public int[] selectionSortForJava(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // меняем местами текущий элемент и минимальный
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    /**
     * Рекурсия(сумма)
     */
    public int sum(int[] arr) {
        int sum = 0;

        if (arr.length != 0) {
            sum = arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
        }

        return sum;
    }

    /**
     * Рекурсия(кол-во)
     */
    public int count(int[] arr) {
        int count = 0;

        if (arr.length != 0) {
            count = 1 + count(Arrays.copyOfRange(arr, 1, arr.length));
        }

        return count;
    }

    /**
     * Рекурсия(макс.число)
     */
    public int max(int[] arr) {
        if (arr.length == 1) return arr[0];
        int tailMax = max(Arrays.copyOfRange(arr, 1, arr.length));
        return arr[0] > tailMax ? arr[0] : tailMax;
    }

    /**
     * Быстрая сортировка на базе массивов
     */
    public int[] quickSort(int[] arr) {
        if (arr.length < 2) return arr;

        int point = arr[0];
        int[] subLess = new int[arr.length - 1];
        int[] subGreater = new int[arr.length - 1];
        int countLess = 0, countGreater = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= point) {
                subLess[countLess++] = arr[i];
            } else {
                subGreater[countGreater++] = arr[i];
            }
        }

        subLess = Arrays.copyOf(subLess, countLess);
        subGreater = Arrays.copyOf(subGreater, countGreater);

        int[] sortedLess = quickSort(subLess);
        int[] sortedGreater = quickSort(subGreater);

        int[] result = new int[sortedLess.length + 1 + sortedGreater.length];
        int index = 0;

        for (int x : sortedLess) result[index++] = x;
        result[index++] = point;
        for (int x : sortedGreater) result[index++] = x;

        return result;
    }

    /**
     * Быстрая сортировка на базе листов
     */
    public List<Integer> quickSort(List<Integer> list) {
        if (list.isEmpty()) return Collections.emptyList();

        Integer point = list.get(0);
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= point) {
                less.add(list.get(i));
            } else {
                greater.add(list.get(i));
            }
        }

        List<Integer> sortedLess = quickSort(less);
        List<Integer> sortedGreater = quickSort(greater);

        List<Integer> result = new ArrayList<>(sortedLess);
        result.add(point);
        result.addAll(sortedGreater);

        return result;
    }

    /**
     * Сортировка слиянием
     */
    public List<Integer> mergeSort(List<Integer> list) {
        if (list == null || list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Integer> leftPart = new ArrayList<>(list.subList(0, mid));
        List<Integer> rightPart = new ArrayList<>(list.subList(mid, list.size()));

        leftPart = mergeSort(leftPart);
        rightPart = mergeSort(rightPart);

        List<Integer> result = new ArrayList<>();

        int i = 0, j = 0;
        while (i < leftPart.size() && j < rightPart.size()) {
            if (leftPart.get(i) <= rightPart.get(j)) {
                result.add(leftPart.get(i));
                i++;
            } else {
                result.add(rightPart.get(j));
                j++;
            }
        }

        while (i < leftPart.size()) {
            result.add(leftPart.get(i));
            i++;
        }
        while (j < rightPart.size()) {
            result.add(rightPart.get(j));
            j++;
        }

        return result;
    }

}
