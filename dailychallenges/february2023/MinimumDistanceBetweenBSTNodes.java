package dailychallenges.february2023;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class MinimumDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        List<Integer> orderedNodes = new ArrayList<>();
        traverseInOrder(root, orderedNodes);

        return IntStream.range(1, orderedNodes.size())
                .map(index -> orderedNodes.get(index) - orderedNodes.get(index - 1))
                .min()
                .orElse(-1);
    }

    private void traverseInOrder(TreeNode root, List<Integer> orderedNodes) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.left, orderedNodes);
        orderedNodes.add(root.val);
        traverseInOrder(root.right, orderedNodes);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(
                new TreeNode(
                        4,
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                new TreeNode(3)
                        ),
                        new TreeNode(6)
                )
        )); // 1
    }
}
