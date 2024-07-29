package companies.snowflake;

import java.util.Arrays;

public class JobExecution {
    public int getMinimumOperations(int[] executionTime, int x, int y) {
        int left = 0;
        int right = Arrays.stream(executionTime).max().orElseThrow();

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (areOperationsSufficient(executionTime, x, y, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean areOperationsSufficient(int[] executionTime, int x, int y, int operations) {
        long additionalOperations = 0; // int?

        for (int time : executionTime) {
            additionalOperations += Math.max(0, (time - operations * y + x - y - 1) / (x - y));
        }

        return additionalOperations <= operations;
    }

    public static void main(String[] args) {
        System.out.println(new JobExecution().getMinimumOperations(new int[]{3, 4, 1, 7, 6}, 4, 2)); // 3
    }
}
