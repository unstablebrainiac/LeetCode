package dailychallenges.january2023;

import java.util.*;

/*
 * https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree
 */
public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adjacency.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adjacency.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        return traverse(0, -1, adjacency, hasApple);
    }

    private int traverse(int node, int parent, Map<Integer, List<Integer>> adjacency, List<Boolean> hasApple) {
        int childSum = adjacency.get(node)
                .stream()
                .filter(child -> child != parent)
                .mapToInt(child -> traverse(child, node, adjacency, hasApple))
                .sum();
        if (node != 0 && (childSum != 0 || hasApple.get(node))) {
            childSum += 2;
        }
        return childSum;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumTimeToCollectAllApplesInATree().minTime(
                7,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 4},
                        new int[]{1, 5},
                        new int[]{2, 3},
                        new int[]{2, 6}
                },
                Arrays.asList(false, false, true, false, true, true, false)
        )); // 8
    }
}
