package dailychallenges.january2024;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 */
public class AmountOfTimeForBinaryTreeToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        Stack<TreeNode> ancestry = new Stack<>();
        TreeNode startNode = findNode(root, start, ancestry);
        int time = 0;
        List<TreeNode> current = new ArrayList<>();
        current.add(startNode);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(startNode);
        while (!current.isEmpty()) {
            List<TreeNode> next = current
                    .stream()
                    .flatMap(node -> Stream.of(node.left, node.right))
                    .filter(Objects::nonNull)
                    .filter(node -> !visited.contains(node))
                    .collect(Collectors.toList());
            if (!ancestry.isEmpty()) {
                TreeNode parent = ancestry.pop();
                next.add(parent);
                visited.add(parent);
            }
            current = next;
            time++;
        }
        return time - 1;
    }

    private TreeNode findNode(TreeNode root, int start, Stack<TreeNode> ancestry) {
        if (root == null) {
            return null;
        }
        if (root.val == start) {
            return root;
        }
        ancestry.push(root);
        TreeNode left = findNode(root.left, start, ancestry);
        if (left != null) {
            return left;
        }
        TreeNode right = findNode(root.right, start, ancestry);
        if (right != null) {
            return right;
        }
        ancestry.pop();
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new AmountOfTimeForBinaryTreeToBeInfected().amountOfTime(
                new TreeNode(
                        1,
                        new TreeNode(
                                5,
                                null,
                                new TreeNode(
                                        4,
                                        new TreeNode(9),
                                        new TreeNode(2)
                                )
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(10),
                                new TreeNode(6)
                        )
                ),
                3
        )); // 4
    }
}
