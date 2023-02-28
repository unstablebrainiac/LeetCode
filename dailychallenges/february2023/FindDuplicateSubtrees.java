package dailychallenges.february2023;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<Integer, TreeNode> ans = new HashMap<>();
        postOrderTraversal(root, new HashMap<>(), ans);
        return new ArrayList<>(ans.values());
    }

    private int postOrderTraversal(TreeNode node, Map<String, Integer> tripletToID, Map<Integer, TreeNode> ans) {
        if (node == null) {
            return 0;
        }
        int left = postOrderTraversal(node.left, tripletToID, ans);
        int right = postOrderTraversal(node.right, tripletToID, ans);
        String triplet = left + "," + node.val + "," + right;
        if (tripletToID.containsKey(triplet)) {
            ans.put(tripletToID.get(triplet), node);
        } else {
            tripletToID.put(triplet, tripletToID.size() + 1);
        }
        return tripletToID.get(triplet);
    }

    public static void main(String[] args) {
        System.out.println(new FindDuplicateSubtrees().findDuplicateSubtrees(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(4),
                                null
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        2,
                                        new TreeNode(4),
                                        null
                                ),
                                new TreeNode(4)
                        )
                )
        )); // [TreeNode{val=4, left=null, right=null}, TreeNode{val=2, left=TreeNode{val=4, left=null, right=null}, right=null}]
    }
}
