package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3383/
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    perimeter += getEdges(grid, i, j);
                }
            }
        }
        return perimeter;
    }

    private int getEdges(int[][] grid, int i, int j) {
        int numEdges = 0;
        if (i == 0 || grid[i - 1][j] == 0) {
            numEdges++;
        }
        if (i == grid.length - 1 || grid[i + 1][j] == 0) {
            numEdges++;
        }
        if (j == 0 || grid[i][j - 1] == 0) {
            numEdges++;
        }
        if (j == grid[0].length - 1 || grid[i][j + 1] == 0) {
            numEdges++;
        }
        return numEdges;
    }

    public static void main(String[] args) {
        System.out.println(new IslandPerimeter().islandPerimeter(
                new int[][]{
                        {0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
                }
        )); // 16
    }
}
