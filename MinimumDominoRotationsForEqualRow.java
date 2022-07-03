import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        int length = A.length;
        int minSoFar = Integer.MAX_VALUE;
        outer:
        for (int num = 1; num <= 6; num++) {
            for (int i = 0; i < length; i++) {
                if (A[i] != num && B[i] != num) {
                    continue outer;
                }
            }
            int finalNum = num;
            int topCount = (int) Arrays.stream(A).filter(value -> value == finalNum).count();
            int bottomCount = (int) Arrays.stream(B).filter(value -> value == finalNum).count();
            minSoFar = Math.min(length - Math.max(topCount, bottomCount), minSoFar);
        }
        return minSoFar == Integer.MAX_VALUE ? -1 : minSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDominoRotationsForEqualRow().minDominoRotations(
                new int[]{2, 1, 2, 4, 2, 2},
                new int[]{5, 2, 6, 2, 3, 2}
        )); // 2
    }
}
