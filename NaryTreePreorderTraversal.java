import java.util.*;

/*
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new LinkedList<>();
        ans.add(root.value);
        Optional.ofNullable(root.children)
                .orElse(Collections.emptyList())
                .stream()
                .map(this::preorder)
                .forEach(ans::addAll);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NaryTreePreorderTraversal().preorder(
                new Node(
                        1,
                        Arrays.asList(
                                new Node(
                                        3,
                                        Arrays.asList(
                                                new Node(5),
                                                new Node(6)
                                        )
                                ),
                                new Node(2),
                                new Node(4)
                        )
                )
        )); // [1, 3, 5, 6, 2, 4]
    }

    static class Node {
        public int value;
        public List<Node> children;

        public Node() {}

        public Node(int value) {
            this(value, null);
        }

        public Node(int value, List<Node> children) {
            this.value = value;
            this.children = children;
        }
    }
}
