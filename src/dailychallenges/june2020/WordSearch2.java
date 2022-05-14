package dailychallenges.june2020;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3376/
 */
public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Arrays.stream(words).forEach(trie::insert);
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                check(board, i, j, trie, ans);
            }
        }
        return ans.stream().distinct().collect(Collectors.toList());
    }

    private void check(char[][] board, int i, int j, Trie trie, List<String> ans) {
        String firstLetter = String.valueOf(board[i][j]);
        if (!trie.startsWith(firstLetter)) {
            return;
        }
        if (trie.search(firstLetter)) {
            ans.add(firstLetter);
        }
        boolean[][] word = new boolean[board.length][board[0].length];
        word[i][j] = true;
        check(board, i, j, trie, word, firstLetter, ans);
    }

    private void check(char[][] board, int i, int j, Trie trie, boolean[][] word, String prefix, List<String> ans) {
        if (i > 0 && !word[i - 1][j]) {
            checkWord(board, i - 1, j, trie, word, prefix, ans);
        }
        if (i < board.length - 1 && !word[i + 1][j]) {
            checkWord(board, i + 1, j, trie, word, prefix, ans);
        }
        if (j > 0 && !word[i][j - 1]) {
            checkWord(board, i, j - 1, trie, word, prefix, ans);
        }
        if (j < board[0].length - 1 && !word[i][j + 1]) {
            checkWord(board, i, j + 1, trie, word, prefix, ans);
        }
    }

    private void checkWord(char[][] board, int i, int j, Trie trie, boolean[][] word, String prefix, List<String> ans) {
        String currentWord = prefix + board[i][j];
        if (!trie.startsWith(currentWord)) {
            return;
        }
        if (trie.search(currentWord)) {
            ans.add(currentWord);
        }
        word[i][j] = true;
        check(board, i, j, trie, word, currentWord, ans);
        word[i][j] = false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch2().findWords(
                new char[][]{
                        {'o', 'a', 'a', 'n'},
                        {'e', 't', 'a', 'e'},
                        {'i', 'h', 'k', 'r'},
                        {'i', 'f', 'l', 'v'}
                },
                new String[]{"eat", "oath"}
        )); // ["eat","oath"]
    }

    static class Trie {

        private final TreeNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TreeNode(' ');
        }

        /**
         * Inserts a word into the trie.
         */
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

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return search(root, ' ' + word, 0, treeNode -> treeNode.children.containsKey('\n'));
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
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
    }
}
