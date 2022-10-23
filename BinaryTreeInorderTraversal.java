import common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new LinkedList<>();
        ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(
                new TreeNode(
                        1,
                        null,
                        new TreeNode(
                                2,
                                new TreeNode(3),
                                null
                        )
                )
        )); // [1, 3, 2]
    }
}
