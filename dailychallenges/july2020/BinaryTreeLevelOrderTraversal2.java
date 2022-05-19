package dailychallenges.july2020;

import common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3378/
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> ans = new LinkedList<>();
        List<TreeNode> list = Collections.singletonList(root);
        while (!list.isEmpty()) {
            ans.add(0, list.stream().map(treeNode -> treeNode.val).collect(Collectors.toList()));

            list = list.stream()
                    .map(node -> Arrays.asList(node.left, node.right))
                    .flatMap(Collection::stream)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal2().levelOrderBottom(
                new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        )); // [[15, 7], [9, 20], [3]]
    }
}
