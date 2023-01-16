package dailychallenges.january2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/insert-interval/
 */
public class InsertInterval {

    private int start(int[] interval) {
        return interval[0];
    }

    private int end(int[] interval) {
        return interval[1];
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> ans = new ArrayList<>();

        int i = 0;

        // Keep adding intervals as is until start of newInterval is reached
        while (i < intervals.length && start(newInterval) > end(intervals[i])) {
            ans.add(intervals[i]);
            i++;
        }

        // Next interval starts from lower of newInterval and currentInterval
        if (i < intervals.length) {
            newInterval[0] = Math.min(start(intervals[i]), start(newInterval));
        }

        // Skip all intervals until end of newInterval is reached
        while (i < intervals.length && end(newInterval) > end(intervals[i])) {
            i++;
        }

        // Compute end of new interval on the basis of overlap with last interval
        if (i < intervals.length && start(intervals[i]) <= end(newInterval)) {
            newInterval[1] = end(intervals[i]);
            i++;
        }

        ans.add(newInterval);

        // Keep adding intervals as is until end of array
        while (i < intervals.length) {
            ans.add(intervals[i]);
            i++;
        }

        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new InsertInterval().insert(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 5},
                        new int[]{6, 7},
                        new int[]{8, 10},
                        new int[]{12, 16}
                },
                new int[]{4, 8}
        ))); // [[1, 2], [3, 10], [12, 16]]
    }
}
