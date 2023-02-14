import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */
public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minSoFar = Integer.MAX_VALUE, index = -1;
        for (int i = 0; i < points.length; i++) {
            int[] coordinates = points[i];
            int distX = Math.abs(x - coordinates[0]);
            int distY = Math.abs(y - coordinates[1]);

            if (distX != 0 && distY != 0) {
                continue;
            }

            if (distX + distY < minSoFar) {
                minSoFar = distX + distY;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new FindNearestPointThatHasTheSameXOrYCoordinate().nearestValidPoint(
                3,
                4,
                new int[][]{
                        new int[]{1, 2},
                        new int[]{3, 1},
                        new int[]{2, 4},
                        new int[]{2, 3},
                        new int[]{4, 4}
                }
        )); // 2
    }
}
