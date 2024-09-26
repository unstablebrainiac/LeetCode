package contests.weekly.weeklycontest415;

import java.util.Optional;

/*
 * https://leetcode.com/problems/maximum-multiplication-score/
 */
public class MaximumMultiplicationScore {

    public long maxScore(int[] a, int[] b) {
        return maxScore(a, b, 0, 0, new Long[4][b.length]).orElseThrow();
    }

    private Optional<Long> maxScore(int[] a, int[] b, int aIndex, int bIndex, Long[][] dp) {
        if (aIndex == 4) {
            return Optional.of(0L);
        }
        if (bIndex == b.length) {
            return Optional.empty();
        }
        if (dp[aIndex][bIndex] != null) {
            return Optional.of(dp[aIndex][bIndex]);
        }

        Optional<Long> option1 = maxScore(a, b, aIndex + 1, bIndex + 1, dp);
        Optional<Long> option2 = maxScore(a, b, aIndex, bIndex + 1, dp);
        if (option1.isEmpty()) {
            dp[aIndex][bIndex] = option2.orElse(null);
            return option2;
        }
        long option1Added = (long) a[aIndex] * b[bIndex] + option1.get();
        if (option2.isEmpty()) {
            dp[aIndex][bIndex] = option1Added;
            return Optional.of(option1Added);
        }
        long ans = Math.max(option1Added, option2.get());

        dp[aIndex][bIndex] = ans;

        return Optional.of(ans);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumMultiplicationScore().maxScore(new int[]{3, 2, 5, 6}, new int[]{2, -6, 4, -5, -3, 2, -7})); // 26
    }
}
