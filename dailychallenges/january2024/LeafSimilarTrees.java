package dailychallenges.january2024;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/leaf-similar-trees/
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        getLeaves(root.left, leaves);
        getLeaves(root.right, leaves);
    }

    public static void main(String[] args) {
        System.out.println(new LeafSimilarTrees().leafSimilar(
                new TreeNode(
                        3,
                        new TreeNode(
                                5,
                                new TreeNode(6),
                                new TreeNode(2,
                                        new TreeNode(7),
                                        new TreeNode(4)
                                )
                        ),
                        new TreeNode(
                                1,
                                new TreeNode(9),
                                new TreeNode(8)
                        )
                ),
                new TreeNode(
                        3,
                        new TreeNode(
                                5,
                                new TreeNode(6),
                                new TreeNode(7)
                        ),
                        new TreeNode(
                                1,
                                new TreeNode(4),
                                new TreeNode(
                                        2,
                                        new TreeNode(9),
                                        new TreeNode(8)
                                )
                        )
                )
        )); // true
    }
}
