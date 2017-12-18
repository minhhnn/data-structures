package com.minhhnn.challenges;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by minh on 18/12/17.
 */
public class PairWithSum {
    /**
     * Find a pair of integer in an array that has a sum equal to X
     *
     */
    public static void main(String[] agrs) {
        int[] arr = {1, 3, 2 , 8, 6, 4, 4};
        int x = 10;

        List<Pair> allPairWithSumX = findAllPairWithSumX(arr, x);
        StringBuffer output = new StringBuffer();
        allPairWithSumX.stream().forEach(p -> output.append(p.toString()).append(" "));

        System.out.println(output.toString());
    }

    private static List<Pair> findAllPairWithSumX(int[] arr, int x) {
        List<Pair> result = new ArrayList<>();
        Map<Integer, Integer> visisted = new HashMap(); //Map<num, count>

        for (int i = 0; i < arr.length; i++) {
            // check if complement of arr[i] already exist
            int complement = x - arr[i];
            Integer count = visisted.get(complement);
            if (count != null && count > 0) {
                Pair newPair = new Pair(arr[i], complement);
                result.add(newPair);
                visisted.put(complement, --count);
            }
            else {
                Integer count2 = visisted.get(arr[i]);
                visisted.put(arr[i], count2 == null ? 1 : count2++);
            }
        }

        return result;
    }

    private static class Pair {
        private int num1;
        private int num2;
        private Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
        }

        public String toString() {
            return "[" + num1 + " ," + num2 + "]";
        }
    }
}
