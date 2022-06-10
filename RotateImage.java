import java.util.Arrays;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                int i2 = length - i - 1;
                int j2 = length - j - 1;
                matrix[i][j] = matrix[j2][i];
                matrix[j2][i] = matrix[i2][j2];
                matrix[i2][j2] = matrix[j][i2];
                matrix[j][i2] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        new RotateImage().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix)); // [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    }
}
