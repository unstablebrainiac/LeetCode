package dailychallenges.december2023;

/*
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank/
 */
public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int monday = 0;
        int current = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 7 == 0) {
                monday++;
                current = monday;
            } else {
                current++;
            }
            sum += current;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new CalculateMoneyInLeetcodeBank().totalMoney(10)); // 37
    }
}
