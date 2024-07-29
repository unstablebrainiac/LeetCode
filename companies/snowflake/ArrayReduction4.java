package companies.snowflake;

import java.util.*;

public class ArrayReduction4 {
    public static int[] getMaxArray(int[] arr) {
        int n = arr.length;
        boolean[] b2 = new boolean[n + 1];

        int mex = 0;

        int[] suffixMex = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            // Mark the current element as present
            b2[arr[i]] = true;

            // Update mex until a non-present value is found
            while (b2[mex]) {
                mex++;
            }

            // Store the current mex value in the result array
            suffixMex[i] = mex;
        }

        List<Integer> bList = new ArrayList<>();
        int p = 0;

        while (p < n) {
            int j = p;
            Set<Integer> lowerElements = new HashSet<>();

            for (; j < n; j++) {
                if (arr[j] > suffixMex[p]) {
                    continue;
                }
                lowerElements.add(arr[j]);
                if (lowerElements.size() == suffixMex[p]) {
                    break;
                }
            }

            // Add this MEX to the array 𝑏
            bList.add(suffixMex[p]);

            // Do the same process starting from position 𝑗+1
            //, so 𝑝=𝑗+1
            p = j + 1;
        }

        // Convert List<Integer> to int[]
        int[] b = new int[bList.size()];
        for (int i = 0; i < bList.size(); i++) {
            b[i] = bList.get(i);
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(getMaxArray(new int[]{0, 1, 1, 0}))); // [2, 2]
    }
}
