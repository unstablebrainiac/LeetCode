package contests.weekly.weeklycontest414;

import java.util.*;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/maximum-number-of-moves-to-kill-all-pawns/
 */
public class MaximumNumberOfMovesToKillAllPawns {

    public int maxMoves(int kx, int ky, int[][] positions) {
        int[][] positionsWithKnight = new int[positions.length + 1][2];
        System.arraycopy(positions, 0, positionsWithKnight, 0, positions.length);
        positionsWithKnight[positions.length] = new int[]{kx, ky};
        int[][][] distances = new int[positionsWithKnight.length][50][50];

        for (int i = 0; i < positionsWithKnight.length; i++) {
            bfs(positionsWithKnight, i, distances[i]);
        }

        int[][] pawnDistances = new int[positionsWithKnight.length][positionsWithKnight.length];

        for (int i = 0; i < positionsWithKnight.length; i++) {
            for (int j = 0; j < positionsWithKnight.length; j++) {
                pawnDistances[i][j] = distances[i][positionsWithKnight[j][0]][positionsWithKnight[j][1]];
            }
        }

        int taken = 0;
        int[][] dp = new int[positions.length + 1][1 << positions.length + 1];
        taken |= 1 << positions.length;
        return maxMoves(positions.length, positions, pawnDistances, taken, dp);
    }

    private int maxMoves(int i, int[][] positions, int[][] pawnDistances, int taken, int[][] dp) {
        if (dp[i][taken] != 0) {
            return dp[i][taken];
        }
        IntBinaryOperator objective = Integer.bitCount(taken) % 2 == 0 ? Math::min : Math::max;
        int ans = IntStream.range(0, positions.length)
                .filter(j -> (taken & (1 << j)) == 0)
                .map(j -> pawnDistances[i][j] + maxMoves(j, positions, pawnDistances, taken | 1 << j, dp))
                .reduce(objective)
                .orElse(0);
        dp[i][taken] = ans;
        return ans;
    }

    private void bfs(int[][] positions, int i, int[][] distances) {
        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{positions[i][0], positions[i][1]});
        boolean[][] visited = new boolean[50][50];
        visited[positions[i][0]][positions[i][1]] = true;
        distances[positions[i][0]][positions[i][1]] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int j = 0; j < 8; j++) {
                int x = current[0] + dx[j];
                int y = current[1] + dy[j];
                if (x >= 0 && x < 50 && y >= 0 && y < 50 && distances[x][y] == 0) {
                    if (visited[x][y]) {
                        continue;
                    }
                    distances[x][y] = distances[current[0]][current[1]] + 1;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfMovesToKillAllPawns().maxMoves(0, 2, new int[][]{{1, 1}, {2, 2}, {3, 3}})); // 8
    }
}
