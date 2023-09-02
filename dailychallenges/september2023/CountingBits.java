package dailychallenges.september2023;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/counting-bits/
 */
public class CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        int latestPowerOf2 = 1;
        for (int i = 1; i <= n; i++) {
            if (i == latestPowerOf2 * 2) {
                latestPowerOf2 = i;
            }
            ans[i] = ans[i - latestPowerOf2] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(17))); // [0,1,1,2,1,2]
    }
}
