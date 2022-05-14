package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3361/
 */
public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        }
        TreeNode child = root.val > val ? root.left : root.right;
        if (child == null) {
            return null;
        }
        return searchBST(child, val);
    }

    public static void main(String[] args) {
        System.out.println(new SearchInABinarySearchTree().searchBST(
                new TreeNode(
                        4,
                        new TreeNode(
                                2,
                                new TreeNode(1),
                                new TreeNode(3)
                        ),
                        new TreeNode(7)
                ),
                2
        )); // 2
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
