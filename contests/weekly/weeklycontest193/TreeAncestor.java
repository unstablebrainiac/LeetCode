package contests.weekly.weeklycontest193;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-193/problems/kth-ancestor-of-a-tree-node/
 */
public class TreeAncestor {

    Map<Integer, Map<Integer, Integer>> ancestry;

    public TreeAncestor(int n, int[] parent) {
        ancestry = new HashMap<>();
        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, parent[i]);
            ancestry.put(i, map);
            for (int j = 1; j < n; j++) {
                if (map.get(j - 1) == -1) {
                    break;
                }
                map.put(j, parent[map.get(j - 1)]);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        Map<Integer, Integer> map = ancestry.get(node);
        if (map.size() < k) {
            return -1;
        }
        return map.get(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new TreeAncestor(
                5,
                new int[]{-1, 0, 0, 0, 3}
        ).getKthAncestor(1, 5));
    }
}
