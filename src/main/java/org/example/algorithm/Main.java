package org.example.algorithm;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AlgorithmService algorithmService = new AlgorithmService();

        System.out.println(algorithmService.binarySearch(-5, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));

        System.out.println(Arrays.toString(algorithmService.selectionSort(new int[]{5, 3, 6, 2, 10})));

        System.out.println(Arrays.toString(algorithmService.selectionSortForJava(new int[]{5, 3, 6, 2, 10})));

        System.out.println(algorithmService.sum(new int[]{2, 4, 6}));
        System.out.println(algorithmService.count(new int[]{2, 4, 6}));
        System.out.println(algorithmService.max(new int[]{-2, 8, -9, 14, -25}));

        System.out.println(Arrays.toString(algorithmService.quickSort(new int[]{-2, 8, -9, 14, -25})));
        System.out.println(algorithmService.quickSort(List.of(-2, 8, -9, 14, -25)));
        System.out.println(algorithmService.mergeSort(List.of(-2, 8, -9, 14, -25)));

        LeetCodeAnswer leetCodeAnswer = new LeetCodeAnswer();
        System.out.println(leetCodeAnswer.canConstruct1("aa", "aab"));

    }

}
