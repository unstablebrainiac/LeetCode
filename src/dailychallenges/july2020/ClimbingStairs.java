package dailychallenges.july2020;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3407/
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    private int climbStairs(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        int ans = 1;
        for (int i = 0; i < n - 1; i++) {
            ans += climbStairs(i, dp);
        }
        dp.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(6)); // 13
    }
}
