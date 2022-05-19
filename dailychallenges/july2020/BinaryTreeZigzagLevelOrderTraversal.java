package dailychallenges.july2020;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3398/
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> list = Collections.singletonList(root);
        int i = 0;
        while (list.stream().anyMatch(Objects::nonNull)) {
            ans.add(list.stream().filter(Objects::nonNull).map(treeNode -> treeNode.val).collect(Collectors.toList()));
            if (i % 2 != 0) {
                Collections.reverse(list);
            }
            list = list.stream()
                    .filter(Objects::nonNull)
                    .flatMap(treeNode -> Stream.of(treeNode.left, treeNode.right))
                    .collect(Collectors.toList());
            if (i % 2 == 0) {
                Collections.reverse(list);
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(
                new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        ));
    }
}
