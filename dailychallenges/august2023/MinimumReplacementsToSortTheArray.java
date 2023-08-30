package dailychallenges.august2023;

/*
 * https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 */
public class MinimumReplacementsToSortTheArray {
    public long minimumReplacement(int[] nums) {
        int minSoFar = Integer.MAX_VALUE;
        long replacements = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            if (num > minSoFar) {
                if (num % minSoFar == 0) {
                    replacements += num / minSoFar - 1;
                } else {
                    int pieces = num / minSoFar + 1;
                    minSoFar = num / pieces;
                    replacements += pieces - 1;
                }
            } else {
                minSoFar = num;
            }
        }
        return replacements;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumReplacementsToSortTheArray().minimumReplacement(
                new int[]{12, 9, 7, 6, 17, 19, 21}
        )); // 6
    }
}
