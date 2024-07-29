package contests.weekly.weeklycontest192;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-192/problems/the-k-strongest-values-in-an-array/
 */
public class TheKStrongestValuesInAnArray {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int medianIndex = (arr.length - 1) / 2;
        int median = arr[medianIndex];
        int minIndex = 0;
        int maxIndex = arr.length - 1;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int min = arr[minIndex];
            int max = arr[maxIndex];
            if ((median - min) > (max - median)) {
                ans[i] = min;
                minIndex++;
            } else {
                ans[i] = max;
                maxIndex--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TheKStrongestValuesInAnArray().getStrongest(
                new int[]{6, 7, 11, 7, 6, 8},
                5
        )));
    }
}
