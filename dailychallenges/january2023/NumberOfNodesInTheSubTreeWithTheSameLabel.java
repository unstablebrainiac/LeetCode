package dailychallenges.january2023;

import java.util.*;

/*
 * https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/
 */
public class NumberOfNodesInTheSubTreeWithTheSameLabel {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> adjacency = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adjacency.computeIfAbsent(a, value -> new ArrayList<>()).add(b);
            adjacency.computeIfAbsent(b, value -> new ArrayList<>()).add(a);
        }
        int[] nodes = new int[n];
        countLabels(0, -1, adjacency, labels, nodes);
        return nodes;
    }

    private int label(String labels, int node) {
        return labels.charAt(node) - 'a';
    }

    private int[] countLabels(int node, int parent, Map<Integer, List<Integer>> adjacency, String labels, int[] nodes) {
        int[] ans = new int[26];
        for (Integer child : adjacency.get(node)) {
            if (child == parent) {
                continue;
            }
            int[] childCount = countLabels(child, node, adjacency, labels, nodes);
            for (int i = 0; i < 26; i++) {
                ans[i] += childCount[i];
            }
        }
        int label = label(labels, node);
        ans[label]++;
        nodes[node] = ans[label];
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NumberOfNodesInTheSubTreeWithTheSameLabel().countSubTrees(
                7,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{0, 2},
                        new int[]{1, 4},
                        new int[]{1, 5},
                        new int[]{2, 3},
                        new int[]{2, 6}
                },
                "abaedcd"
        ))); // [2, 1, 1, 1, 1, 1, 1]
    }
}
