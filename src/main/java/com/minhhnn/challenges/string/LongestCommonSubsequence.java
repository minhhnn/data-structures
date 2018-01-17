package com.minhhnn.challenges.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by minh on 17/01/2018.
 * Find Longest Common Subsequence
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        System.out.println("Longest common subsequence between '" + s1 + "' and '" + s2 + "' = " + lcsUsingMemo(s1, s2));

        String s3 = "AGGTAB";
        String s4 = "GXTXAYB";
        System.out.println("Longest common subsequence between '" + s3 + "' and '" + s4 + "' = " + lcsUsingMemo(s3, s4));
    }

    private static int lcsUsingMemo(String s1, String s2) {
        return lcsUsingMemo(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), new HashMap<>());
    }

    /**
     * Calculate longest common subsequence using memoization
     * @param s1 string 1 char array
     * @param s2 string 2 char array
     * @param s1Index
     * @param s2Index
     * @param memo memo table
     * @return
     */
    private static int lcsUsingMemo(char[] s1, char[] s2, int s1Index, int s2Index, Map<String, Integer> memo) {
        if (s1Index == 0 || s2Index == 0) {
            return 0;
        }

        String key = s1Index + "-" + s2Index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int result;
        if (s1[s1Index - 1] == s2[s2Index - 1]) {
            result = 1 + lcsUsingMemo(s1, s2, s1Index - 1, s2Index - 1, memo);
        } else {
            result = Math.max(lcsUsingMemo(s1, s2, s1Index, s2Index - 1, memo),
                    lcsUsingMemo(s1, s2, s1Index - 1, s2Index, memo));
        }

        memo.put(key, result);
        return result;
    }
}
