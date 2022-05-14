package biweeklycontest28;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/biweekly-contest-28/problems/final-prices-with-a-special-discount-in-a-shop/
 */
public class FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        int[] finalPrices = new int[prices.length];
        Arrays.fill(finalPrices, -1);
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    finalPrices[i] = prices[i] - prices[j];
                    break;
                }
            }
            if (finalPrices[i] == -1) {
                finalPrices[i] = prices[i];
            }
        }
        return finalPrices;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FinalPricesWithASpecialDiscountInAShop().finalPrices(
                new int[]{10, 1, 1, 6}
        )));
    }
}
