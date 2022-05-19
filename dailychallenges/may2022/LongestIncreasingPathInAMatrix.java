package dailychallenges.may2022;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] lengths = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                lengths[i][j] = longestIncreasingPaths(matrix, lengths, i, j, -1);
            }
        }

        return Arrays.stream(lengths)
                .flatMapToInt(Arrays::stream)
                .max().orElseThrow();
    }

    private int longestIncreasingPaths(int[][] matrix, int[][] lengths, int i, int j, int num) {
        if (i < 0 || i >= matrix.length) {
            return 0;
        }
        if (j < 0 || j >= matrix[0].length) {
            return 0;
        }
        if (lengths[i][j] == -1) {
            return 0;
        }
        if (matrix[i][j] <= num) {
            return 0;
        }
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }
        lengths[i][j] = -1; // computing
        int max = IntStream.of(
                longestIncreasingPaths(matrix, lengths, i - 1, j, matrix[i][j]),
                longestIncreasingPaths(matrix, lengths, i + 1, j, matrix[i][j]),
                longestIncreasingPaths(matrix, lengths, i, j + 1, matrix[i][j]),
                longestIncreasingPaths(matrix, lengths, i, j - 1, matrix[i][j])
        ).max().orElseThrow();
        lengths[i][j] = max + 1;
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(
                new int[][]{
                        new int[]{9, 9, 4},
                        new int[]{6, 6, 8},
                        new int[]{2, 1, 1}
                }
        )); // 4
        System.out.println(new LongestIncreasingPathInAMatrix().longestIncreasingPath(
                new int[][]{
                        new int[]{7, 7, 5},
                        new int[]{2, 4, 6},
                        new int[]{8, 2, 0}
                }
        )); // 4
    }
}
