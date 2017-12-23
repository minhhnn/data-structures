package com.minhhnn.challenges;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by minh on 23/12/17.
 * Find how many ways to pay from a given set of coins
 */
public class CoinChange {
    public static void main(String[] args) {
        double[] coins = {2, 5, 3, 6};

        double money = 10;

        int ways = findWays(coins, money);

        System.out.println(ways);
    }

    private static int findWays(double[] coins , double money) {
        return findWays(coins, money, 0, new HashMap<>());
    }

    private static int findWays(double[] coins, double money, int index, Map<String, Integer> memo) {
        if (money == 0) {
            return 1;
        } else if (index >= coins.length){
            return 0;
        }

        String key = money + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double amountWithCoin = 0;
        int ways = 0;
        while (amountWithCoin <= money) {
            double remaining = money  - amountWithCoin;
            ways += findWays(coins, remaining, index + 1, memo);
            amountWithCoin += coins[index];
        }

        memo.put(key, ways);

        return ways;
    }
}
