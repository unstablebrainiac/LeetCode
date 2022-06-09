package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = numbers.length - 1;
        while (numbers[index1] + numbers[index2] != target) {
            if (numbers[index1] + numbers[index2] < target) {
                index1++;
            } else {
                index2--;
            }
        }
        return new int[]{index1 + 1, index2 + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum2().twoSum(
                new int[]{2, 7, 11, 15},
                9
        )));
    }
}
