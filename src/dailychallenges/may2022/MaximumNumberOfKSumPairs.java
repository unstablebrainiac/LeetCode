package dailychallenges.may2022;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/max-number-of-k-sum-pairs/
 */
public class MaximumNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> occurences = new HashMap<>();

        int pairs = 0;
        for (int num : nums) {
            if (occurences.containsKey(k - num) && occurences.get(k - num) > 0) {
                occurences.put(k - num, occurences.get(k - num) - 1);
                pairs++;
            } else {
                if (occurences.containsKey(num)) {
                    occurences.put(num, occurences.get(num) + 1);
                } else {
                    occurences.put(num, 1);
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfKSumPairs().maxOperations(
                new int[]{1, 2, 3, 4},
                5
        )); // 2
    }
}
