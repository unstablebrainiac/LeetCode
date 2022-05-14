import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int count = 0;
        int maxValid = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            } else {
                if (count == 0) {
                    return Math.max(maxValid, longestValidParentheses(s.substring(i + 1)));
                }
                count--;
                if (count == 0) {
                    maxValid = Math.max(i + 1, maxValid);
                }
            }
        }
        if (count == 0) {
            return s.length();
        }
        return Math.max(maxValid, longestValidParentheses(s.substring(1)));
    }

    public static void main(String[] args) {
        System.out.println(new LongestValidParentheses().longestValidParentheses(")()())")); // 4
    }
}
