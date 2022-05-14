package dailychallenges.july2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3382/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (Arrays.stream(digits).filter(value -> value != 9).count() == 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        return plusOne(digits, digits.length - 1);
    }

    private int[] plusOne(int[] digits, int index) {
        if (digits[index] == 9) {
            digits[index] = 0;
            return plusOne(digits, index - 1);
        }
        digits[index]++;
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(
                new int[]{1, 2, 9}
        ))); // 130
    }
}
