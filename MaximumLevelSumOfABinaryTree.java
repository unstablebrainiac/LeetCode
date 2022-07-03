import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
 */
public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        int maxSoFar = Integer.MIN_VALUE;
        int maxIndex = 0;
        int index = 1;
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            int sum = current.stream().mapToInt(node -> node.val).sum();
            if (sum > maxSoFar) {
                maxSoFar = sum;
                maxIndex = index;
            }
            index++;
            current = current.stream().flatMap(treeNode -> Stream.of(treeNode.left, treeNode.right)).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLevelSumOfABinaryTree().maxLevelSum(
                new TreeNode(
                        1,
                        new TreeNode(
                                7,
                                new TreeNode(7),
                                new TreeNode(-8)
                        ),
                        new TreeNode(0)
                )
        )); // 2
    }
}
