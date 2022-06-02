package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/transpose-matrix/
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        int[][] ans = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new TransposeMatrix().transpose(
                new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6}
                }
        )));
    }
}
