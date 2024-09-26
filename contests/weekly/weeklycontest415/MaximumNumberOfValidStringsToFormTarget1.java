package contests.weekly.weeklycontest415;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/*
 * https://leetcode.com/problems/minimum-number-of-valid-strings-to-form-target-i/
 * Does not pass
 */
public class MaximumNumberOfValidStringsToFormTarget1 {

    public int minValidStrings(String[] words, String target) {
        Set<String> prefixes = new HashSet<>();
        for (String word : words) {
            for (int i = 1; i <= word.length(); i++) {
                prefixes.add(word.substring(0, i));
            }
        }
        return minValidStrings(prefixes, target, 0, new Integer[target.length()]);
    }

    private int minValidStrings(Set<String> prefixes, String target, int startIndex, Integer[] dp) {
        if (startIndex == target.length()) {
            return 0;
        }
        if (dp[startIndex] != null) {
            return dp[startIndex];
        }
        int min = Integer.MAX_VALUE;
        for (int i = startIndex + 1; i <= target.length(); i++) {
            if (prefixes.contains(target.substring(startIndex, i))) {
                int next = minValidStrings(prefixes, target, i, dp);
                if (next != -1) {
                    min = Math.min(min, 1 + next);
                }
            } else {
                break;
            }
        }
        dp[startIndex] = min == Integer.MAX_VALUE ? -1 : min;
        return dp[startIndex];
    }

//    public int minValidStrings(String[] words, String target) {
//        Trie trie = new Trie();
//        for (String word : words) {
//            trie.insert(word);
//        }
//        return minValidStrings(trie, target, 0, new Integer[target.length()]);
//    }
//
//    private int minValidStrings(Trie trie, String target, int startIndex, Integer[] dp) {
//        if (startIndex == target.length()) {
//            return 0;
//        }
//        if (dp[startIndex] != null) {
//            return dp[startIndex];
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = startIndex + 1; i <= target.length(); i++) {
//            if (trie.startsWith(target.substring(startIndex, i))) {
//                int next = minValidStrings(trie, target, i, dp);
//                if (next != -1) {
//                    min = Math.min(min, 1 + next);
//                }
//            } else {
//                break;
//            }
//        }
//        dp[startIndex] = min == Integer.MAX_VALUE ? -1 : min;
//        return dp[startIndex];
//    }
//
//    static class Trie {
//
//        private final TreeNode root;
//
//        /**
//         * Initialize your data structure here.
//         */
//        public Trie() {
//            root = new TreeNode(' ');
//        }
//
//        /**
//         * Inserts a word into the trie.
//         */
//        public void insert(String word) {
//            insert(root, word + '\n', 0);
//        }
//
//        private void insert(TreeNode node, String word, int index) {
//            if (index == word.length()) {
//                return;
//            }
//            TreeNode child = node.children.computeIfAbsent(word.charAt(index), TreeNode::new);
//            insert(child, word, index + 1);
//        }
//
//        /**
//         * Returns if the word is in the trie.
//         */
//        public boolean search(String word) {
//            return search(root, ' ' + word, 0, treeNode -> treeNode.children.containsKey('\n'));
//        }
//
//        /**
//         * Returns if there is any word in the trie that starts with the given prefix.
//         */
//        public boolean startsWith(String prefix) {
//            return search(root, ' ' + prefix, 0, treeNode -> true);
//        }
//
//        private boolean search(TreeNode node, String word, int index, Predicate<TreeNode> finalCheck) {
//            if (node == null) {
//                return false;
//            }
//            if (index == word.length() - 1) {
//                return finalCheck.test(node);
//            }
//            char c = word.charAt(index);
//            return node.val == c && search(node.children.get(word.charAt(index + 1)), word, index + 1, finalCheck);
//        }
//
//        static class TreeNode {
//            char val;
//            Map<Character, TreeNode> children;
//
//            public TreeNode(char val) {
//                this.val = val;
//                this.children = new HashMap<>();
//            }
//
//            public TreeNode(char val, Map<Character, TreeNode> children) {
//                this.val = val;
//                this.children = children;
//            }
//
//            @Override
//            public String toString() {
//                return String.valueOf(val);
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfValidStringsToFormTarget1().minValidStrings(new String[]{"abc", "aaaaa", "bcdef"}, "aabcdabc")); // 3
    }
}
