package com.minhhnn.challenges.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by @author minh on 02/01/2018.
 * given a set of digit from 1 to 9 {1,2,3,4,5,6,7,8,9},
 * write code to find k elements whose sum is equal to n.
 * i.e.
 * arr = {1,2,3,4,5,6,7,8,9}
 * k = 3; n = 9
 * print [1, 2, 6], [1, 3, 5], [2, 3, 4]
 */
public class KElementsWithSum {
    public static void main(String[] agrs) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        findKElementsWithSum(arr, 3, 9);
    }

    private static void findKElementsWithSum(int[] arr, int k, int n) {
        findKElementsWithSum(arr, k, 0, n, new ArrayList<>());
    }

    private static void findKElementsWithSum(int[] arr, int k, int index, int remaining, List<Integer> solution) {
        if (remaining == 0 && solution.size() == k) {
            printSolution(solution);
        } else if (remaining > 0 && index < arr.length) {
            for (int i = index; i < arr.length; i++) {
                solution.add(arr[i]);
                findKElementsWithSum(arr, k,i + 1, remaining - arr[i], solution);
                solution.remove(new Integer(arr[i])); // Remove Object Integer rather than remove index
            }
        }
    }

    private static void printSolution(List<Integer> solution) {
        System.out.println(Arrays.toString(solution.toArray()));
    }
}
