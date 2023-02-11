package dailychallenges.february2023;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/shortest-path-with-alternating-colors/
 */
public class ShortestPathWithAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redNext = computeNextNodes(redEdges);
        Map<Integer, List<Integer>> blueNext = computeNextNodes(blueEdges);

        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        navigate(n, redNext, blueNext, ans, false);
        navigate(n, redNext, blueNext, ans, true);

        return ans;
    }

    private void navigate(int n, Map<Integer, List<Integer>> redNext, Map<Integer, List<Integer>> blueNext, int[] ans, boolean red) {
        boolean[][] visited = new boolean[n][2];
        visited[0][0] = true;
        visited[0][1] = true;

        List<Integer> current = new ArrayList<>();
        current.add(0);
        int steps = 1;
        while (!current.isEmpty()) {
            int visitedIndex = red ? 0 : 1;
            if (red) {
                current = nextNodes(redNext, current, visited, visitedIndex);
                red = false;
            } else {
                current = nextNodes(blueNext, current, visited, visitedIndex);
                red = true;
            }
            current.forEach(value -> visited[value][visitedIndex] = true);
            int finalSteps = steps;
            current.forEach(value -> ans[value] = ans[value] == -1 ? finalSteps : Math.min(ans[value], finalSteps));
            steps++;
        }
    }

    private List<Integer> nextNodes(Map<Integer, List<Integer>> redNext, List<Integer> current, boolean[][] visited, int visitedIndex) {
        return current.stream()
                .filter(redNext::containsKey)
                .map(redNext::get)
                .flatMap(Collection::stream)
                .filter(value -> !visited[value][visitedIndex])
                .collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> computeNextNodes(int[][] edges) {
        return Arrays.stream(edges)
                .collect(Collectors.groupingBy(edge -> edge[0]))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().stream().map(edge -> edge[1]).collect(Collectors.toList())));
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestPathWithAlternatingColors().shortestAlternatingPaths(
                3,
                new int[][]{
                        new int[]{0, 1}
                },
                new int[][]{
                        new int[]{2, 1}
                }
        ))); // [0, 1, -1]
    }
}
