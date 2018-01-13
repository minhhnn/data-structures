package com.minhhnn.challenges;

import java.util.Arrays;

/**
 * Created by @author minh on 13/01/2018.
 * Knapsack 0 1
 * You have n items, where the ith item type has a weight wi and a real value vi.
 * You need to ﬁll a knapsack of total capacity C with a selection of items of maximum value.
 * There are multiple instances of an item type
 */
public class KnapsackWithDuplicate {
    public static void main(String[] args) {
        int n = 3;
        int k = 100;
        int[] value = {10, 30, 20};
        int[] weight = {5, 10, 15};

        System.out.println("Knapsach value = " + knapsack(n, k, value, weight));
    }

    /**
     *
     * @param n total items
     * @param k total Capacity
     * @param values values of all items
     * @param weights weights of all items
     * @return knapsack value
     */
    private static int knapsack(int n, int k, int[] values, int[] weights) {
        int[] arr = new int[k + 1];

        for (int currentWeight = 0; currentWeight <= k; currentWeight++) {
            for (int currentItem = 0; currentItem < n; currentItem++) {
                if (weights[currentItem] <= currentWeight) {
                    arr[currentWeight] = Math.max(arr[currentWeight], arr[currentWeight - weights[currentItem]] + values[currentItem]);
                }
            }
        }

        System.out.println(Arrays.toString(arr));

        return arr[k];
    }
}
