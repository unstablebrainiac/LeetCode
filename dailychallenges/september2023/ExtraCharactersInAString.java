package dailychallenges.september2023;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExtraCharactersInAString {

    private void insertIntoTrie(String word, TrieNode root) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            current = current.children.computeIfAbsent(c, TrieNode::new);
        }
    }

    public int minExtraChar(String s, String[] dictionary) {
        TrieNode root = new TrieNode(' ');
        Arrays.stream(dictionary).forEach(word -> insertIntoTrie(word + '.', root));
        return minExtraChar(s, root, 0, new HashMap<>());
    }

    private int minExtraChar(String s, TrieNode dictionary, int index, Map<Integer, Integer> dp) {
        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        int ans = s.length() - index;
        for (int i = index; i < s.length(); i++) {
            TrieNode current = dictionary;
            for (int j = i; j < s.length(); j++) {
                if (!current.children.containsKey(s.charAt(j))) {
                    break;
                }
                current = current.children.get(s.charAt(j));
                if (current.children.containsKey('.')) {
                    ans = Math.min(ans, i - index + minExtraChar(s, dictionary, j + 1, dp));
                }
            }
        }
        dp.put(index, ans);
        return ans;
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
            return "{" + val + " : " + children.values() + "}";
        }
    }

    public static void main(String[] args) {
        System.out.println(new ExtraCharactersInAString().minExtraChar(
                "sayhelloworld",
                new String[]{"hello", "world"}
        )); // 3
    }
}
