package dailychallenges.december2023;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/buy-two-chocolates/
 */
public class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        int minCost = Arrays.stream(prices)
                .sorted()
                .limit(2)
                .sum();
        return minCost <= money ? money - minCost : money;
    }

    public static void main(String[] args) {
        System.out.println(new BuyTwoChocolates().buyChoco(new int[]{1, 2, 2}, 3)); // 0
    }
}
