package contests.biweekly.biweeklycontest30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/contest/biweekly-contest-30/problems/range-sum-of-sorted-subarray-sums/
 */
public class RangeSumOfSortedSubarraySums {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }
        return sums.stream()
                .sorted(Integer::compareTo)
                .skip(left - 1)
                .limit(right - left + 1)
                .mapToInt(value -> value)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new RangeSumOfSortedSubarraySums().rangeSum(
                new int[]{1,2,3,4},
                4,
                3,
                4
        ));
    }
}
