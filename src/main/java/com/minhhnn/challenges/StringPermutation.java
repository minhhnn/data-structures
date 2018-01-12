package com.minhhnn.challenges;

import java.util.*;

/**
 * Created by minh on 23/12/17.
 * Find all permutations of a given string
 * i.e. s = "abc"
 * ==> permutations: [acb, bca, abc, cba, bac, cab]
 * s = "aaa"
 * ==> permutations: [aaa]
 */
public class StringPermutation {
    public static void main(String[] agrs) {
        String s = "abc";

        Set<String> permutation = findPermutations(s);

        System.out.println(Arrays.toString(permutation.toArray()));
    }

    private static Set<String> findPermutations(String s) {
        Set<String> permuations = new HashSet<>();
        findPermutations("", s, permuations);

        return permuations;
    }

    private static void findPermutations(String prefix, String suffix, Set<String> permutations) {
        // We can also stop when suffix length == 1 (when there is only 1 character left
        if (suffix.length() == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                findPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1), permutations);
            }
        }

    }
}
