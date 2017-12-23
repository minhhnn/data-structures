package com.minhhnn.challenges.string;

/**
 * Created by minh on 23/12/17.
 * Implement a method to perform basic string compression using the count of repeated characters method
 * i.e. "aabccccaaa" => "a2b1c4a3"
 * Return original String if result is not smaller than the original
 * "abc" => "abc". because rather than return "a1b1c1" which is longer than  original
 */
public class Compression {
    public static void main(String[] args) {
        String str = "aabccccaaa";
        String str2 = "cat";

        System.out.println("Compressed String = " + compress(str));
        System.out.println("Compressed String = " + compress(str2));
    }

    private static String compress(String str) {
        StringBuilder output = new StringBuilder("");
        int counterOutside = 0;
        while (counterOutside < str.length()) {
            char c = str.charAt(counterOutside);
            int counterInside = counterOutside + 1;
            while (counterInside < str.length() && c == str.charAt(counterInside)) {
                counterInside++;
            }

            output.append(c).append(counterInside - counterOutside);

            // Move counterOutside along
            counterOutside = counterInside;
        }
        if (output.toString().length() < str.length()) {
            return output.toString();
        } else {
            return str;
        }
    }
}
