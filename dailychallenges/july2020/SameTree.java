package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3389/
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        if (q == null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        System.out.println(new SameTree().isSameTree(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                ),
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                )
        )); // true
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
    }
}
