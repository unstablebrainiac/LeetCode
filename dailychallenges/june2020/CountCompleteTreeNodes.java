package dailychallenges.june2020;

import common.TreeNode;

import java.util.function.Function;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
 */
public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftBranchLength = branchLength(root, node1 -> node1.left);
        int rightBranchLength = branchLength(root, node1 -> node1.right);
        if (leftBranchLength == rightBranchLength) {
            return (int) (Math.pow(2, leftBranchLength) - 1);
        }
        int leftTreeRightBranchLength = branchLength(root.left, node1 -> node1.right);
        if (leftBranchLength == leftTreeRightBranchLength + 1) {
            return (int) (Math.pow(2, leftTreeRightBranchLength) + countNodes(root.right));
        } else {
            return (int) (Math.pow(2, leftTreeRightBranchLength) + countNodes(root.left));
        }
    }

    private int branchLength(TreeNode node, Function<TreeNode, TreeNode> childMapper) {
        if (node == null) {
            return 0;
        }
        return 1 + branchLength(childMapper.apply(node), childMapper);
    }

    public static void main(String[] args) {
        System.out.println(new CountCompleteTreeNodes().countNodes(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(4),
                                null
                        ),
                        new TreeNode(
                                3
                        )
                )
        ));
    }
}
