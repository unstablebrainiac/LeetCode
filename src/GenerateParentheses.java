import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
 * https://leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateParenthesis(n, 0, 0);
    }

    private List<String> generateParenthesis(int n, int startCount, int endCount) {
        if (startCount == endCount && endCount == n) {
            return Collections.singletonList("");
        }
        List<String> list = new ArrayList<>();
        if (endCount < startCount) {
            list.addAll(generateParenthesis(n, startCount, endCount + 1).stream().map(s -> ")" + s).collect(toList()));
        }
        if (startCount < n) {
            list.addAll(generateParenthesis(n, startCount + 1, endCount).stream().map(s -> "(" + s).collect(toList()));
        }
        return removeDuplicates(list);
    }

    private List<String> removeDuplicates(List<String> list) {
        return list.stream().distinct().collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
//      [
//          "((()))",
//          "(()())",
//          "(())()",
//          "()(())",
//          "()()()"
//      ]
    }
}

//[((())()), (())(())]
//[((())())]