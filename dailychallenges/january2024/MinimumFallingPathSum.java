package dailychallenges.january2024;

/*
 * https://leetcode.com/problems/minimum-falling-path-sum/
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(min, minFallingPathSum(matrix, 0, i, dp));
        }
        return min;
    }

    private int minFallingPathSum(int[][] matrix, int row, int column, Integer[][] dp) {
        if (row == matrix.length) {
            return 0;
        }
        if (dp[row][column] != null) {
            return dp[row][column];
        }
        int min = Integer.MAX_VALUE;
        for (int i = -1; i <= 1; i++) {
            if (column + i >= 0 && column + i < matrix[0].length) {
                min = Math.min(min, matrix[row][column] + minFallingPathSum(matrix, row + 1, column + i, dp));
            }
        }
        return dp[row][column] = min;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(
                new int[][]{
                        {2, 1, 3},
                        {6, 5, 4},
                        {7, 8, 9}
                }
        )); // 13
    }
}
