package dailychallenges.june2022;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/maximum-erasure-value/
 */
public class MaximumErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> window = new HashSet<>();
        int start = 0, end = 0;
        int maxSoFar = 0, currentSum = 0;

        while (end < nums.length) {
            while (window.contains(nums[end])) {
                window.remove(nums[start]);
                currentSum -= nums[start++];
            }
            window.add(nums[end]);
            currentSum += nums[end++];
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumErasureValue().maximumUniqueSubarray(
                new int[]{4, 2, 4, 5, 6}
        )); // 17
    }
}
