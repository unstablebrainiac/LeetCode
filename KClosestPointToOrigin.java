import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/problems/k-closest-points-to-origin/
 */
public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        return Arrays.stream(points)
                .sorted(Comparator.comparing(point -> point[0] * point[0] + point[1] * point[1]))
                .limit(k)
                .toArray(size -> new int[size][2]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new KClosestPointToOrigin().kClosest(
                new int[][]{
                        new int[]{3, 3},
                        new int[]{5, -1},
                        new int[]{-2, 4}
                },
                2
        )));
    }
}
