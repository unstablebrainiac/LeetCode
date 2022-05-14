package dailychallenges.june2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        if (coins.length == 0) {
            return 0;
        }
        Arrays.sort(coins);
        int[][] lookup = new int[amount + 1][coins.length];
        for (int[] ints : lookup) {
            Arrays.fill(ints, -1);
        }
        return change(amount, coins, lookup, coins.length - 1);
    }

    private int change(int amount, int[] coins, int[][] lookup, int maxIndex) {
        if (lookup[amount][maxIndex] != -1) {
            return lookup[amount][maxIndex];
        }
        int change = 0;
        for (int i = 0; i <= maxIndex; i++) {
            if (coins[i] == amount) {
                change++;
            } else if (coins[i] < amount) {
                change += change(amount - coins[i], coins, lookup, i);
            }
        }
        lookup[amount][maxIndex] = change;
        return change;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(
                5,
                new int[]{1, 2, 5}
        ));
    }
}
