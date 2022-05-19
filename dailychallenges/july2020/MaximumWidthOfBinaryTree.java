package dailychallenges.july2020;

import common.TreeNode;

import java.util.*;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3385/
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        int max = 1;
        List<TreeNode> temp;
        while (!nodes.isEmpty()) {
            temp = new ArrayList<>();
            for (TreeNode node : nodes) {
                if (node == null) {
                    temp.add(null);
                    temp.add(null);
                } else {
                    temp.add(node.left);
                    temp.add(node.right);
                }
            }
            nodes = trim(temp);
            max = Math.max(max, nodes.size());
        }
        return max;
    }

    private List<TreeNode> trim(List<TreeNode> nodes) {
        int min = nodes.size();
        int max = 0;
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null) {
                min = i;
                break;
            }
        }
        if (min == nodes.size()) {
            return Collections.emptyList();
        }
        for (int i = nodes.size() - 1; i >= 0; i--) {
            if (nodes.get(i) != null) {
                max = i;
                break;
            }
        }
        return nodes.subList(min, max + 1);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumWidthOfBinaryTree().widthOfBinaryTree(
                new TreeNode(
                        1,
                        new TreeNode(
                                3,
                                new TreeNode(5),
                                new TreeNode(3)
                        ),
                        null
                )
        ));
    }
}
