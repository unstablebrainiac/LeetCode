package contests.biweekly.biweeklycontest27;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/biweekly-contest-27/problems/cherry-pickup-ii/
 */
public class CherryPickup2 {
    public int cherryPickup(int[][] grid) {
        return cherryPickup(grid, 0, 0, grid[0].length - 1, new Integer[grid.length][grid[0].length][grid[0].length]);
    }

    private int cherryPickup(int[][] grid, int currentRow, int index1, int index2, Integer[][][] dp) {
        if (index1 > index2) {
            return cherryPickup(grid, currentRow, index2, index1, dp);
        }
        if (dp[currentRow][index1][index2] != null) {
            return dp[currentRow][index1][index2];
        }
        int[] curRow = grid[currentRow];
        if (currentRow == grid.length - 1) {
            if (index1 == index2) {
                return curRow[index1];
            }

            int ans = curRow[index1] + curRow[index2];
            dp[currentRow][index1][index2] = ans;
            return ans;
        }
        int maximum;
        if (index1 == index2) {
            if (index1 == 0) {
                maximum = maximum(
                        cherryPickup(grid, currentRow + 1, 0, 0, dp),
                        cherryPickup(grid, currentRow + 1, 0, 1, dp),
                        cherryPickup(grid, currentRow + 1, 1, 1, dp)
                );
            } else if (index1 == curRow.length - 1) {
                maximum = maximum(
                        cherryPickup(grid, currentRow + 1, index1, index1, dp),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1, dp),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1 - 1, dp)
                );
            } else {
                maximum = maximum(
                        cherryPickup(grid, currentRow + 1, index1, index1, dp),
                        cherryPickup(grid, currentRow + 1, index1, index1 + 1, dp),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1, dp),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1 + 1, dp),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1 - 1, dp),
                        cherryPickup(grid, currentRow + 1, index1 + 1, index1 + 1, dp)
                );
            }
            int ans = curRow[index1] + maximum;
            dp[currentRow][index1][index2] = ans;
            return ans;
        }
        if (index1 == 0 && index2 == curRow.length - 1) {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, 0, index2, dp),
                    cherryPickup(grid, currentRow + 1, 0, index2 - 1, dp),
                    cherryPickup(grid, currentRow + 1, 1, index2, dp),
                    cherryPickup(grid, currentRow + 1, 1, index2 - 1, dp)
            );
        } else if (index1 == 0) {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, 0, index2, dp),
                    cherryPickup(grid, currentRow + 1, 0, index2 + 1, dp),
                    cherryPickup(grid, currentRow + 1, 0, index2 - 1, dp),
                    cherryPickup(grid, currentRow + 1, 1, index2, dp),
                    cherryPickup(grid, currentRow + 1, 1, index2 + 1, dp),
                    cherryPickup(grid, currentRow + 1, 1, index2 - 1, dp)
            );
        } else if (index2 == curRow.length - 1) {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, index1, index2, dp),
                    cherryPickup(grid, currentRow + 1, index1, index2 - 1, dp),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2, dp),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2 - 1, dp),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2, dp),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2 - 1, dp)
            );
        } else {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, index1, index2, dp),
                    cherryPickup(grid, currentRow + 1, index1, index2 + 1, dp),
                    cherryPickup(grid, currentRow + 1, index1, index2 - 1, dp),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2, dp),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2 + 1, dp),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2 - 1, dp),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2, dp),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2 + 1, dp),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2 - 1, dp)
            );
        }
        int ans = curRow[index1] + curRow[index2] + maximum;
        dp[currentRow][index1][index2] = ans;
        return ans;
    }

    private int maximum(int... values) {
        return Arrays.stream(values).max().orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(new CherryPickup2().cherryPickup(
                new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}
        )); // 24
    }
}
