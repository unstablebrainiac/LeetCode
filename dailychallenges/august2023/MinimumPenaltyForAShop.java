package dailychallenges.august2023;

/*
 * https://leetcode.com/problems/minimum-penalty-for-a-shop/
 */
public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        int penalty = 0, min = 0, closingHour = 0;
        for (int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if (c == 'Y') {
                penalty--;
            } else {
                penalty++;
            }
            if (penalty < min) {
                min = penalty;
                closingHour = i + 1;
            }
        }
        return closingHour;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPenaltyForAShop().bestClosingTime("YYNY")); // 2
    }
}
