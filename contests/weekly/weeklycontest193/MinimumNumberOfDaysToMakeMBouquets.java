package contests.weekly.weeklycontest193;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-193/problems/minimum-number-of-days-to-make-m-bouquets/
 */
public class MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int[] max = new int[bloomDay.length - k + 1];
        for (int i = 0; i < bloomDay.length - k + 1; i++) {
            max[i] = maximum(bloomDay, i, k);
        }
        int[] possibilities = Arrays.copyOf(max, max.length);
        Arrays.sort(possibilities);
        int i = binarySearch(possibilities, max, m, k);
        if (i == possibilities.length - 1) {
            if (checkPossibility(max, m, k, possibilities[possibilities.length - 1])) {
                return possibilities[possibilities.length - 1];
            }
            return -1;
        }
        return possibilities[i];
    }

    private int binarySearch(int[] possibilities, int[] max, int m, int k) {
        int low = 0;
        int high = possibilities.length - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            boolean midVal = checkPossibility(max, m, k, possibilities[mid]);

            if (!midVal)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return high;  // key not found.
    }

    private boolean checkPossibility(int[] max, int m, int k, int possibility) {
        int x = 0;
        for (int i = 0; i < max.length; i++) {
            int value = max[i];
            if (value <= possibility) {
                x++;
                if (x == m) {
                    return true;
                }
                i += k - 1;
            }
        }
        return false;
    }

    private int maximum(int[] bloomDay, int i, int k) {
        return Arrays.stream(bloomDay, i, i + k)
                .max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfDaysToMakeMBouquets().minDays(
                new int[]{1, 10, 2, 9, 3, 8, 4, 7, 5, 6},
                4,
                2
        ));
    }
}
