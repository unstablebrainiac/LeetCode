package contests.weekly.weeklycontest414;

import java.util.List;

/*
 * https://leetcode.com/problems/reach-end-of-array-with-max-score/
 */
public class ReachEndOfArrayWithMaxScore {

    public long findMaximumScore(List<Integer> nums) {
        int max = nums.get(0);
        long ans = 0;
        for (int i = 1; i < nums.size(); i++) {
            ans += max;
            max = Math.max(max, nums.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ReachEndOfArrayWithMaxScore().findMaximumScore(List.of(1, 3, 1, 5))); // 7
    }
}
