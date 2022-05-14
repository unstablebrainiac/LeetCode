import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * https://leetcode.com/problems/valid-parentheses/
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Map<Character, Integer> parentheses = new HashMap<>();
        parentheses.put('(', 1);
        parentheses.put(')', 1);
        parentheses.put('{', 2);
        parentheses.put('}', 2);
        parentheses.put('[', 3);
        parentheses.put(']', 3);
        if (s.isEmpty()) {
            return true;
        }
        if ((s.length() & 1) != 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(parentheses.get(c));
                    break;
                case ')':
                case '}':
                case ']':
                    if (!checkAndPopStack(stack, parentheses.get(c))) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return stack.size() == 0;
    }

    private boolean checkAndPopStack(Stack<Integer> stack, int i) {
        if (stack.isEmpty()) {
            return false;
        }
        return stack.pop() == i;
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("{[]}()")); // true
    }
}
