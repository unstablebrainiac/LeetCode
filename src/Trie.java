import java.util.*;
import java.util.function.Predicate;

/*
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Trie {

    private final TreeNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(root, word + '\n', 0);
    }

    private void insert(TreeNode node, String word, int index) {
        if (index == word.length()) {
            return;
        }
        TreeNode child = node.children.computeIfAbsent(word.charAt(index), TreeNode::new);
        insert(child, word, index + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(root, ' ' + word, 0, treeNode -> treeNode.children.containsKey('\n'));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(root, ' ' + prefix, 0, treeNode -> true);
    }

    private boolean search(TreeNode node, String word, int index, Predicate<TreeNode> finalCheck) {
        if (node == null) {
            return false;
        }
        if (index == word.length() - 1) {
            return finalCheck.test(node);
        }
        char c = word.charAt(index);
        return node.val == c && search(node.children.get(word.charAt(index + 1)), word, index + 1, finalCheck);
    }

    static class TreeNode {
        char val;
        Map<Character, TreeNode> children;

        public TreeNode(char val) {
            this.val = val;
            this.children = new HashMap<>();
        }

        public TreeNode(char val, Map<Character, TreeNode> children) {
            this.val = val;
            this.children = children;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}