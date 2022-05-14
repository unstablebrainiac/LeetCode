package weeklycontest197;

/*
 * https://leetcode.com/contest/weekly-contest-197/problems/number-of-good-pairs/
 */
public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfGoodPairs().numIdenticalPairs(
                new int[]{1, 2, 3, 1}
        )); // 0, 3
    }
}
