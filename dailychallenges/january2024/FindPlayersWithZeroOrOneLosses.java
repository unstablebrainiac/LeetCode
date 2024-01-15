package dailychallenges.january2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 */
public class FindPlayersWithZeroOrOneLosses {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            losses.putIfAbsent(winner, 0);
            losses.merge(loser, 1, Integer::sum);
        }

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(losses.entrySet().stream().filter(entry -> entry.getValue() == 0).map(Map.Entry::getKey).sorted().collect(Collectors.toList()));
        ans.add(losses.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).sorted().collect(Collectors.toList()));

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindPlayersWithZeroOrOneLosses().findWinners(
                new int[][]{
                        {1, 3},
                        {2, 3},
                        {3, 6},
                        {5, 6},
                        {5, 7},
                        {4, 5},
                        {4, 8},
                        {4, 9},
                        {10, 4},
                        {10, 9}
                }
        )); // [[1, 2, 10], [4, 5, 7, 8]]
    }
}
