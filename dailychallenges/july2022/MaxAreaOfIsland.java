package dailychallenges.july2022;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans = Math.max(area(grid, i, j), ans);
            }
        }
        return ans;
    }

    private int area(int[][] grid, int i, int j) {
        int area = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return area;
        }
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            area++;
            area += area(grid, i + 1, j);
            area += area(grid, i - 1, j);
            area += area(grid, i, j + 1);
            area += area(grid, i, j - 1);
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(
                new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }
        )); // 6
    }
}
