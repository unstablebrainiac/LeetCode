package dailychallenges.october2023;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/integer-break/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int ans = integerBreak(n, new HashMap<>());
        if (ans == n) {
            return (n / 2) * (n - n / 2);
        }
        return ans;
    }

    private int integerBreak(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }

        int max = n;
        for (int i = 1; i <= n / 2; i++) {
            max = Math.max(max, integerBreak(i, dp) * integerBreak(n - i, dp));
        }

        dp.put(n, max);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(10)); // 36
    }
}
