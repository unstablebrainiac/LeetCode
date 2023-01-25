package dailychallenges.january2023;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
 */
public class FindClosestNodeToGivenTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        Set<Integer> visitedA = new HashSet<>();
        Set<Integer> visitedB = new HashSet<>();
        while (true) {
            if (node1 == node2) {
                if (node1 == -1) {
                    return -1;
                }
                return node1;
            }

            if (visitedA.contains(node2) && visitedB.contains(node1)) {
                return Math.min(node1, node2);
            }

            if (visitedA.contains(node2)) {
                return node2;
            }

            if (visitedB.contains(node1)) {
                return node1;
            }

            if (visitedA.contains(node1) && visitedB.contains(node2)) {
                return -1;
            }

            if (visitedA.contains(node1) && node2 == -1) {
                return -1;
            }

            if (visitedB.contains(node2) && node1 == -1) {
                return -1;
            }

            visitedA.add(node1);
            visitedB.add(node2);
            node1 = nextNode(edges, node1);
            node2 = nextNode(edges, node2);
        }
    }

    private int nextNode(int[] edges, int node) {
        if (node == -1) {
            return -1;
        }
        return edges[node];
    }

    public static void main(String[] args) {
        System.out.println(new FindClosestNodeToGivenTwoNodes().closestMeetingNode(
                new int[]{2, 2, 3, -1},
                0,
                1
        )); // 2
    }
}
