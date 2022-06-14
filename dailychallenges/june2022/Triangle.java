package dailychallenges.june2022;

import java.util.List;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/problems/triangle/
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0, new int[triangle.size()][triangle.size()]);
    }

    private int minimumTotal(List<List<Integer>> triangle, int i, int j, int[][] dp) {
        Integer current = triangle.get(i).get(j);
        if (i == triangle.size() - 1) {
            return current;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int ans = current + Math.min(minimumTotal(triangle, i + 1, j, dp), minimumTotal(triangle, i + 1, j + 1, dp));
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Triangle().minimumTotal(
                asList(
                        asList(2),
                        asList(3, 4),
                        asList(6, 5, 7),
                        asList(4, 1, 8, 3)
                )
        ));
    }
}
