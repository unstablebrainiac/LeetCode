package dailychallenges.may2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, new int[amount + 1]);
    }

    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int ans = Arrays.stream(coins)
                .map(coin -> coinChange(coins, amount - coin, dp))
                .filter(coin -> coin != -1)
                .min()
                .orElse(-2) + 1;
        dp[amount] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(
                new int[]{1, 2, 5},
                11
        )); // 3
    }
}
