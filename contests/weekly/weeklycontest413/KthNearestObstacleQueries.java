package contests.weekly.weeklycontest413;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/k-th-nearest-obstacle-queries/
 */
public class KthNearestObstacleQueries {

    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> distances = new PriorityQueue<>(Comparator.reverseOrder());
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int distance = Math.abs(x) + Math.abs(y);
            distances.add(distance);

            if (distances.size() > k) {
                distances.poll();
            }

            if (distances.size() < k) {
                result[i] = -1;
                continue;
            }
            result[i] = distances.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new KthNearestObstacleQueries().resultsArray(new int[][]{
                {1, 2},
                {3, 4},
                {2, 3},
                {-3, 0}
        }, 2))); // [-1, 7, 5, 3]
    }
}
