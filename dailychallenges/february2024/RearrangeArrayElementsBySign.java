package dailychallenges.february2024;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/
 */
public class RearrangeArrayElementsBySign {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> positive = new LinkedList<>();
        Queue<Integer> negative = new LinkedList<>();

        for (int num : nums) {
            if (num > 0) {
                positive.offer(num);
            } else {
                negative.offer(num);
            }
        }

        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 0) {
                ans[i] = positive.poll();
            } else {
                ans[i] = negative.poll();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(new RearrangeArrayElementsBySign().rearrangeArray(
                new int[]{3, 1, -2, -5, 2, -4}
        ))); // [3, -2, 1, -5, 2, -4]
    }
}
