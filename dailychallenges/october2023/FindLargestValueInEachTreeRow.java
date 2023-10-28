package dailychallenges.october2023;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        current.add(root);
        while (!current.isEmpty()) {
            ans.add(
                    current.stream()
                            .map(node -> node.val)
                            .max(Integer::compareTo)
                            .get()
            );
            current = current.stream()
                    .flatMap(node -> Stream.of(node.left, node.right))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindLargestValueInEachTreeRow().largestValues(
                new TreeNode(
                        1,
                        new TreeNode(3, new TreeNode(5), new TreeNode(3)),
                        new TreeNode(2, null, new TreeNode(9))
                )
        )); // [1, 3, 9]
    }
}
