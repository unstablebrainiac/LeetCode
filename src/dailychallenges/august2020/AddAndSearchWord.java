package dailychallenges.august2020;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3413/
 */
public class AddAndSearchWord {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // false
        System.out.println(wordDictionary.search("bad")); // true
        System.out.println(wordDictionary.search(".ad")); // true
        System.out.println(wordDictionary.search("b..")); // true
    }

    static class WordDictionary {

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode(' ');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            addWord(root, word + '\n', 0);
        }

        private void addWord(TrieNode node, String word, int index) {
            if (index == word.length()) {
                return;
            }
            TrieNode child = node.children.computeIfAbsent(word.charAt(index), TrieNode::new);
            addWord(child, word, index + 1);
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, ' ' + word, 0, treeNode -> treeNode.children.containsKey('\n'));
        }

        private boolean search(TrieNode node, String word, int index, Predicate<TrieNode> finalCheck) {
            if (node == null) {
                return false;
            }
            if (index == word.length() - 1) {
                return finalCheck.test(node);
            }
            char c = word.charAt(index);
            if (c != '.' && node.val != c) {
                return false;
            }
            if (word.charAt(index + 1) == '.') {
                return node.children
                        .values()
                        .stream()
                        .anyMatch(trieNode -> search(trieNode, word, index + 1, finalCheck));
            } else {
                return search(node.children.get(word.charAt(index + 1)), word, index + 1, finalCheck);
            }
        }

        static class TrieNode {
            char val;
            Map<Character, TrieNode> children;

            public TrieNode(char val) {
                this.val = val;
                this.children = new HashMap<>();
            }

            public TrieNode(char val, Map<Character, TrieNode> children) {
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
