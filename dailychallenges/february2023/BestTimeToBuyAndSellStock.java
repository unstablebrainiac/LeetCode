package dailychallenges.february2023;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minSoFar = Integer.MAX_VALUE;
        int ans = 0;
        for (int price : prices) {
            ans = Math.max(ans, price - minSoFar);
            minSoFar = Math.min(minSoFar, price);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(
                new int[]{7, 1, 5, 3, 6, 4}
        )); // 5
    }
}
