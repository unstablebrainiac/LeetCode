package contests.biweekly.biweeklycontest26;

import common.TreeNode;

/*
 * https://leetcode.com/contest/biweekly-contest-26/problems/count-good-nodes-in-binary-tree/
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, -100_000);
    }

    public int goodNodes(TreeNode root, int maximum) {
        if (root == null) {
            return 0;
        }
        int num = 0;
        if (root.val >= maximum) {
            num++;
            maximum = root.val;
        }
        return num + goodNodes(root.left, maximum) + goodNodes(root.right, maximum);
    }

    public static void main(String[] args) {
        System.out.println(new CountGoodNodesInBinaryTree().goodNodes(
                new TreeNode(
                        3,
                        new TreeNode(
                                1,
                                new TreeNode(3),
                                null
                        ),
                        new TreeNode(
                                4,
                                new TreeNode(1),
                                new TreeNode(5)
                        )
                )
        )); // 4
    }
}