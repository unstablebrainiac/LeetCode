package dailychallenges.august2020;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3425/00
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparing(ints -> ints[1]));
        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                count++;
                end = intervals[i][1];
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals(
                new int[][]{
                        {1, 2},
                        {2, 3},
                        {3, 4},
                        {1, 3}
                }
        )); // 1
    }
}
