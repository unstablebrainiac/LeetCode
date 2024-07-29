package contests.weekly.weeklycontest367;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/construct-product-matrix/
 */
public class ConstructProductMatrix {
    public int[][] constructProductMatrix(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        long[][] postProducts = new long[grid.length][grid[0].length];
        long pre = 1, post = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                postProducts[i][j] = post;
                post = (post * grid[i][j]) % 12345;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                ans[i][j] = (int) ((pre * postProducts[i][j]) % 12345);
                pre = (pre * grid[i][j]) % 12345;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new ConstructProductMatrix().constructProductMatrix(
                new int[][]{
                        {1, 2},
                        {3, 4},
                }
        ))); // [[24, 12], [8, 6]]
    }
}
