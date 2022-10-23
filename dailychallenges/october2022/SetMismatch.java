package dailychallenges.october2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/set-mismatch/
 */
public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] encountered = new int[nums.length];
        int missingNumber = 0, repeatedNumber = 0;
        for (int num : nums) {
            if (encountered[num - 1] == 0) {
                encountered[num - 1] = 1;
            } else {
                repeatedNumber = num;
            }
        }
        for (int i = 0; i < encountered.length; i++) {
            if (encountered[i] == 0) {
                missingNumber = i + 1;
            }
        }
        return new int[]{repeatedNumber, missingNumber};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums(
                new int[]{1, 2, 2, 4}
        ))); // [2, 3]
    }
}
