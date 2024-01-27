package dailychallenges.january2024;

/*
 * https://leetcode.com/problems/out-of-boundary-paths/
 */
public class OutOfBoundaryPaths {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] dp = new Integer[m][n][maxMove + 1];
        return findPaths(m, n, maxMove, startRow, startColumn, dp);
    }

    private int findPaths(int m, int n, int maxMove, int startRow, int startColumn, Integer[][][] dp) {
        if (maxMove == 0) {
            return 0;
        }
        if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
            return 0;
        }
        if (dp[startRow][startColumn][maxMove] != null) {
            return dp[startRow][startColumn][maxMove];
        }
        long adjacentBoundaries = 0;
        if (startRow == 0) {
            adjacentBoundaries++;
        }
        if (startRow == m - 1) {
            adjacentBoundaries++;
        }
        if (startColumn == 0) {
            adjacentBoundaries++;
        }
        if (startColumn == n - 1) {
            adjacentBoundaries++;
        }
        if (maxMove == 1) {
            dp[startRow][startColumn][maxMove] = (int) adjacentBoundaries;
            return (int) adjacentBoundaries;
        }
        long ans = adjacentBoundaries
                + findPaths(m, n, maxMove - 1, startRow - 1, startColumn, dp)
                + findPaths(m, n, maxMove - 1, startRow + 1, startColumn, dp)
                + findPaths(m, n, maxMove - 1, startRow, startColumn - 1, dp)
                + findPaths(m, n, maxMove - 1, startRow, startColumn + 1, dp);
        int modAns = (int) (ans % 1_000_000_007);
        dp[startRow][startColumn][maxMove] = modAns;
        return modAns;
    }

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().findPaths(2, 2, 2, 0, 0)); // 6
    }
}
