package dailychallenges.july2022;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        current.add(root);

        while (!current.isEmpty()) {
            ans.add(
                    current.stream()
                            .map(node -> node.val)
                            .collect(Collectors.toList())
            );
            current = current.stream()
                    .flatMap(node -> Stream.of(node.left, node.right))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(
                new TreeNode(
                        3,
                        new TreeNode(9),
                        new TreeNode(
                                20,
                                new TreeNode(15),
                                new TreeNode(7)
                        )
                )
        )); // [[3],[9,20],[15,7]]
    }
}
