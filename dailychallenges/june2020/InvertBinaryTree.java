package dailychallenges.june2020;

import common.TreeNode;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            root.left = root.right;
            root.right = null;
            invertTree(root.left);
            return root;
        }
        if (root.right == null) {
            root.right = root.left;
            root.left = null;
            invertTree(root.right);
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(new InvertBinaryTree().invertTree(
                new TreeNode(
                        4,
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                new TreeNode(3)
                        ),
                        new TreeNode(
                                7,
                                new TreeNode(6),
                                new TreeNode(9)
                        )
                )
        ));
//                  4
//                /   \
//               7     2
//              / \   / \
//             9   6 3   1
    }
}
