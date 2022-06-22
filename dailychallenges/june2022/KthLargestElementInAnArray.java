package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        return Arrays.stream(nums).sorted().skip(nums.length - k).findFirst().orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAnArray().findKthLargest(
                new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6},
                4
        )); // 4
    }
}
