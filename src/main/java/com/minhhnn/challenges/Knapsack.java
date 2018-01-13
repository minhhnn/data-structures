package com.minhhnn.challenges;

/**
 * Created by @author minh on 13/01/2018.
 * Knapsack 0 1
 * You have n items, where the ith item type has a weight wi and a real value vi.
 * You need to ﬁll a knapsack of total capacity C with a selection of items of maximum value.
 * There is only 1 instance of each item type
 */
public class Knapsack {
    public static void main(String[] args) {
        int n = 4;
        int k = 10;
        int[] value = {10, 40, 30, 50};
        int[] weight = {5, 4, 6, 3};

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
        int[][] arr = new int[n + 1][k + 1];

        //If the bag is 0 kg no matter how many items there are, we can't put anything in it, therefore bag's value = 0
        for (int item = 0; item < n; item++) {
            arr[item][0] = 0;
        }

        // If there is no item, no matter how big the bag is, there is nothing to put in bag, therefore bag's value = 0
        for (int weight = 0; weight < k; weight++) {
            arr[0][weight] = 0;
        }

        for (int currentItem = 1; currentItem <= n; currentItem++) {
            for (int currentWeight = 1; currentWeight <= k; currentWeight++) {
                if (weights[currentItem - 1] <= currentWeight) {
                    arr[currentItem][currentWeight] = Math.max(arr[currentItem - 1][currentWeight],
                            arr[currentItem - 1][currentWeight - weights[currentItem - 1]] + values[currentItem - 1]);
                } else {
                    arr[currentItem][currentWeight] = arr[currentItem - 1][currentWeight];
                }
            }
        }

        printArray(arr, n + 1, k + 1);

        return arr[n][k];
    }

    private static void printArray(int[][] arr, int totalRows, int totalCol) {
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCol; col++) {
                System.out.format("%5d", arr[row][col]);
            }
            System.out.println();
        }
    }
}
