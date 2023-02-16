package dailychallenges.february2023;

import common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        List<TreeNode> currentLevel = Arrays.asList(root);

        while (!currentLevel.isEmpty()) {
            currentLevel = currentLevel.stream()
                    .flatMap(node -> Stream.of(node.left, node.right))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(
                new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        )); // 
    }
}
