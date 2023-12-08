package dailychallenges.december2023;

import common.TreeNode;

/*
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        return root == null ? "" : (
                root.val +
                        (
                                root.left == null && root.right == null ? "" :
                                        "(" + tree2str(root.left) + ")" +
                                                (root.right == null ? "" : "(" + tree2str(root.right) + ")")
                        )
        );
    }

    public static void main(String[] args) {
        System.out.println(new ConstructStringFromBinaryTree().tree2str(
                new TreeNode(
                        1,
                        new TreeNode(2, new TreeNode(4), null),
                        new TreeNode(3)
                )
        )); // 1(2(4))(3)
    }
}
