package dailychallenges.july2022;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        List<Integer> ans = new ArrayList<>();

        while (!current.isEmpty()) {
            ans.add(current.get(current.size() - 1).val);
            current = current.stream()
                    .flatMap(treeNode -> Stream.of(treeNode.left, treeNode.right))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeRightSideView().rightSideView(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(5)
                        ),
                        new TreeNode(
                                3,
                                null,
                                new TreeNode(4)
                        )
                )
        )); // [1, 3, 4]
    }
}
