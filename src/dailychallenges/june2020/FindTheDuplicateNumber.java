package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(
                new int[]{3, 1, 3, 4, 2}
        )); // 3
    }
}
