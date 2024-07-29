package companies.snowflake;

public class EfficientCost {

    public static int solve(int[] a, int threshold, int startIndex) {
        if (startIndex >= a.length) {
            return 0;
        }

        int currMaxi = a[startIndex];
        int ans = Integer.MAX_VALUE;

        for (int i = startIndex; i < Math.min(a.length, startIndex + threshold); i++) {
            currMaxi = Math.max(currMaxi, a[i]);
            ans = Math.min(ans, currMaxi + solve(a, threshold, i + 1));
        }

        return ans;
    }

    public int calculateCost(int[] arr, int threshold) {
        return solve(arr, threshold, 0);
    }

    public static void main(String[] args) {
        System.out.println(new EfficientCost().calculateCost(new int[]{1, 3, 4, 5, 2, 6}, 3)); // 10
    }
}
