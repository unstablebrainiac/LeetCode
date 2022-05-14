package dailychallenges.june2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3359/
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> largestSubset = new ArrayList<>();
        List<Integer> subset;
        for (int i = 0; i < nums.length; i++) {
            subset = new ArrayList<>();
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    subset.add(nums[j]);
                }
            }
            if (subset.size() > largestSubset.size()) {
                largestSubset = subset;
            }
        }
        return largestSubset;
    }

    public static void main(String[] args) {
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(
                new int[]{4, 8, 10, 240}
        )); // 1,2,4,8
    }
}
