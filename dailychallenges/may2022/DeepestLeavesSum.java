package dailychallenges.may2022;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.singletonList;

/*
 * https://leetcode.com/problems/deepest-leaves-sum/
 */
public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        List<TreeNode> children = singletonList(root);
        List<TreeNode> currentNodes = children;
        while(!children.isEmpty()) {
            currentNodes = children;
            children = getChildren(currentNodes);
        }
        return currentNodes.stream().mapToInt(node -> node.val).sum();
    }

    private List<TreeNode> getChildren(List<TreeNode> currentNodes) {
        return currentNodes
                .stream()
                .flatMap(treeNode -> Stream.of(treeNode.left, treeNode.right))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        System.out.println(new DeepestLeavesSum().deepestLeavesSum(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(
                                        4,
                                        new TreeNode(7),
                                        null
                                ),
                                new TreeNode(5)
                        ),
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(
                                        6,
                                        null,
                                        new TreeNode(8)
                                )
                        )
                )
        )); // 15
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}