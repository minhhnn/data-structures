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

    private static void findPermutations(String prefix, String s, Set<String> permutations) {
        if (s.length() == 1) {
            permutations.add(prefix + s);
        } else if (s.length() > 1){
            for (int i = 0; i < s.length(); i++) {
                findPermutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), permutations);
            }
        }

    }
}
