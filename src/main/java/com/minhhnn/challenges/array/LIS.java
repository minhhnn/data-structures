package com.minhhnn.challenges.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by @author minh on 02/01/2018.
 * Longest increasing subsequence
 */
public class LIS {
    public static void main(String[] agrs) {
        int[] arr1 = { 10, 22, 9, 33, 21, 50, 41, 60 };

        List<Integer> lis = findLis(arr1);
        System.out.println("Input: " + Arrays.toString(arr1));
        System.out.println("Output : Length of LIS = " + lis.size());
        System.out.println("The longest increasing subsequence is " + Arrays.toString(lis.toArray()));
    }

    /**
     * Find the longest increasing subsequence
     * This method only returns 1 possible list.
     * @param arr input array
     * @return list of longest increasing subsequence elements
     */
    private static List<Integer> findLis(int[] arr) {
        if (arr.length < 1) {
            throw new IllegalArgumentException();
        }

        int[] tempLis = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            tempLis[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && tempLis[i] < tempLis[j] + 1) {
                    tempLis[i] = tempLis[j] + 1;
                }
            }
        }

        int max = 0;
        List<Integer> lis = new ArrayList<>();
        for (int i = 0; i < tempLis.length; i++) {
            if (tempLis[i] > max) {
                max = tempLis[i];
                lis.add(arr[i]);
            }
        }

        return lis;
    }
}
