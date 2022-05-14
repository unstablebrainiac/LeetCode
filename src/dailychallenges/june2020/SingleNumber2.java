package dailychallenges.june2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        long numNonZeroes = Arrays.stream(nums).filter(value -> value != 0).count();
        if (numNonZeroes == 0) {
            return 0;
        } else if (numNonZeroes == 1) {
            return Arrays.stream(nums).filter(value -> value != 0).findFirst().getAsInt();
        }
        long sum = computeSum(nums);
        int form = positiveMod(sum, 3);
        for (int i = 0; i < nums.length; i++) {
            if (positiveMod(nums[i], 3) == form) {
                if (positiveMod(nums[i] - form, 3) == 0) {
                    nums[i] = (nums[i] - form) / 3;
                } else {
                    // Handle wraparound
                    nums[i] = nums[i] - form;
                }
            } else {
                nums[i] = 0;
            }
        }
        int ans = singleNumber(nums);
        if (ans > Integer.MAX_VALUE / 3) {
            // Handle wraparound
            return ans + form;
        }
        return ans * 3 + form;
    }

    private long computeSum(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private int positiveMod(long n, int k) {
        int mod = (int) (n % k);
        if (mod < 0) {
            mod += k;
        }
        return mod;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber2().singleNumber(
                new int[]{0, 1, 0, 1, 0, 1, 99}
        )); // 99
    }
}
