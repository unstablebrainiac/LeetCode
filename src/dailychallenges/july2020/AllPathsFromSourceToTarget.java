package dailychallenges.july2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3400/
 */
public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        allPathsSourceTarget(graph, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void allPathsSourceTarget(int[][] graph, int value, List<Integer> pathSoFar, List<List<Integer>> ans) {
        pathSoFar.add(value);
        if (value == graph.length - 1) {
            ans.add(new ArrayList<>(pathSoFar));
            pathSoFar.remove(Integer.valueOf(value));
            return;
        }
        Arrays.stream(graph[value])
                .forEach(i -> allPathsSourceTarget(graph, i, pathSoFar, ans));
        pathSoFar.remove(Integer.valueOf(value));
    }

    public static void main(String[] args) {
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(
                new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}
        )); // [[0, 4], [0, 3, 4], [0, 1, 3, 4], [0, 1, 2, 3, 4], [0, 1, 4]]
    }
}
