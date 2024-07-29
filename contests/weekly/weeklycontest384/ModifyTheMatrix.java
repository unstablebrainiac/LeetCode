package contests.weekly.weeklycontest384;

/*
 * https://leetcode.com/problems/modify-the-matrix/
 */
public class ModifyTheMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] columnMax = new int[matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int max = 0;
            for (int i = 0; i < matrix.length; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            columnMax[j] = max;
        }

        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] == -1) {
                    ans[i][j] = columnMax[j];
                } else {
                    ans[i][j] = matrix[i][j];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.deepToString(new ModifyTheMatrix().modifiedMatrix(
                new int[][]{
                        {1, 2, -1},
                        {4, -1, 6},
                        {7, 8, 9}
                }
        ))); // [[1, 2, 9], [4, 8, 6], [7, 8, 9]]
    }
}
