package dailychallenges.june2020;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
 */
public class PerfectSquares {
    public int numSquares(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        return numSquares(n, dp);
    }

    private int numSquares(int n, Map<Integer, Integer> dp) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        if (Math.pow((int) Math.sqrt(n), 2) == n) {
            dp.put(n, 1);
            return 1;
        }
        int ans = 1 + IntStream.range(1, (int) Math.ceil(Math.sqrt(n)))
                .map(operand -> (int) Math.pow(operand, 2))
                .map(operand -> numSquares(n - operand, dp))
                .min()
                .getAsInt();
        dp.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }
}
