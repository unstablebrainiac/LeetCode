package weeklycontest407;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/minimum-operations-to-make-array-equal-to-target/
 */
public class MinimumOperationsToMakeArrayEqualToTarget {
    public long minimumOperations(int[] nums, int[] target) {
        long[] diff = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            diff[i] = target[i] - nums[i];
        }
        return minimumOperations(diff);
    }

    private long minimumOperations(long[] diff) {
        long ans = 0;
        int start = 0;
        boolean positive = false;

        for (int i = 0; i < diff.length; i++) {
            long l = diff[i];
            if (l > 0) {
                if (!positive) {
                    ans += minimumOperations(diff, start, i, 0);
                    start = i;
                    positive = true;
                }
            } else if (l < 0) {
                if (positive) {
                    ans += minimumOperations(diff, start, i, 0);
                    start = i;
                    positive = false;
                }
            } else {
                ans += minimumOperations(diff, start, i, 0);
                start = i;
            }
        }

        return ans + minimumOperations(diff, start, diff.length, 0);
    }

    private long minimumOperations(long[] diff, int startInclusive, int endExclusive, long base) {
        if (startInclusive >= endExclusive) {
            return 0;
        }
        if (startInclusive == endExclusive - 1) {
            return Math.abs(diff[startInclusive]) - base;
        }
        long min = Arrays.stream(diff, startInclusive, endExclusive).map(Math::abs).min().orElseThrow();
        List<Integer> minIndices = new ArrayList<>();
        for (int i = startInclusive; i < endExclusive; i++) {
            if (Math.abs(diff[i]) == min) {
                minIndices.add(i);
            }
        }

        long ans = min - base;
        int start = startInclusive;
        for (int minIndex : minIndices) {
            ans += minimumOperations(diff, start, minIndex, min);
            start = minIndex + 1;
        }
        ans += minimumOperations(diff, start, endExclusive, min);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToMakeArrayEqualToTarget().minimumOperations(
                new int[]{3, 5, 1, 2},
                new int[]{4, 6, 2, 4}
        )); // 2
    }
}
