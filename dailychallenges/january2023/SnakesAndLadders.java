package dailychallenges.january2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/snakes-and-ladders/
 */
public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        List<Integer> possibleMaxPositions = new ArrayList<>();
        possibleMaxPositions.add(1);
        int n = board.length;
        int turns = 0;
        Set<Integer> visited = new HashSet<>();
        while (possibleMaxPositions.stream().noneMatch(position -> position == n * n)) {
            possibleMaxPositions = possibleMaxPositions
                    .stream()
                    .flatMap(position -> nextMove(position, board).stream())
                    .distinct()
                    .filter(value -> !visited.contains(value))
                    .peek(visited::add)
                    .collect(Collectors.toList());
            if (possibleMaxPositions.isEmpty()) {
                return -1;
            }
            turns++;
        }
        return turns;
    }

    private List<Integer> nextMove(int position, int[][] board) {
        List<Integer> ans = new ArrayList<>();
        boolean maxByDiceAdded = false;
        for (int i = 6; i >= 1; i--) {
            int destination = destination(position + i, board);
            if (destination != -1) {
                ans.add(destination);
            } else if (!maxByDiceAdded) {
                ans.add(position + i);
                maxByDiceAdded = true;
            }
        }
        return ans;
    }

    private int destination(int position, int[][] board) {
        int n = board.length;
        if (position >= n * n) {
            return n * n;
        }
        int row = n - (position - 1) / n - 1;
        int column = (n - row) % 2 == 1 ? (position - 1) % n : n - (position - 1) % n - 1;
        return board[row][column];
    }

    public static void main(String[] args) {
        System.out.println(new SnakesAndLadders().snakesAndLadders(
                new int[][]{
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, 35, -1, -1, 13, -1},
                        new int[]{-1, -1, -1, -1, -1, -1},
                        new int[]{-1, 15, -1, -1, -1, -1}
                }
        )); // 4
    }
}
