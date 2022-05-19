package dailychallenges.june2020;

import common.TreeNode;

import java.util.stream.Stream;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return listNumbers(root)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private Stream<String> listNumbers(TreeNode root) {
        if (root == null) {
            return Stream.empty();
        }
        if (root.right == null && root.left == null) {
            return Stream.of("" + root.val);
        }
        return Stream
                .concat(
                        listNumbers(root.left),
                        listNumbers(root.right)
                )
                .map(s -> root.val + s);
    }

    public static void main(String[] args) {
        System.out.println(new SumRootToLeafNumbers().sumNumbers(
                new TreeNode(
                        4,
                        new TreeNode(
                                9,
                                new TreeNode(5),
                                new TreeNode(1)
                        ),
                        new TreeNode(0)
                )
        )); // 1026
    }
}
