package contests.weekly.weeklycontest414;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximize-score-of-numbers-in-ranges/
 */
public class MaximizeScoreOfNumbersInRanges {

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);

        int left = 0;
        int right = (start[start.length - 1] + d) / (start.length - 1) + 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isPossible(start, d, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    private boolean isPossible(int[] start, int d, int score) {
        long current = start[0];
        for (int i = 1; i < start.length; i++) {
            if (current + score > start[i] + d) {
                return false;
            }
            current = Math.max(current + score, start[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MaximizeScoreOfNumbersInRanges().maxPossibleScore(new int[]{6, 0, 3}, 2)); // 4
    }
}
