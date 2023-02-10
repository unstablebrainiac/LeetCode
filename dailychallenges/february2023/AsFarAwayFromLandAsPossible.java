package dailychallenges.february2023;

/*
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 */
public class AsFarAwayFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        boolean flag = true;
        int currentDistance = 0;
        while (flag) {
            currentDistance++;
            flag = false;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == currentDistance) {
                        populateNeighbors(grid, i, j);
                        flag = true;
                    }
                }
            }
        }
        return currentDistance == 2 ? -1 : currentDistance - 2;
    }

    private void populateNeighbors(int[][] grid, int i, int j) {
        if (i != 0 && grid[i - 1][j] == 0) {
            grid[i - 1][j] = grid[i][j] + 1;
        }
        if (j != 0 && grid[i][j - 1] == 0) {
            grid[i][j - 1] = grid[i][j] + 1;
        }
        if (i != grid.length - 1 && grid[i + 1][j] == 0) {
            grid[i + 1][j] = grid[i][j] + 1;
        }
        if (j != grid[i].length - 1 && grid[i][j + 1] == 0) {
            grid[i][j + 1] = grid[i][j] + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new AsFarAwayFromLandAsPossible().maxDistance(
                new int[][]{
                        new int[]{1, 0, 1},
                        new int[]{0, 0, 0},
                        new int[]{1, 0, 1}
                }
        )); // 2
    }
}
