import java.util.regex.Pattern;

/*
 * https://leetcode.com/problems/valid-number/
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        return s.matches("^[+\\-]?(\\d+\\.|\\.\\d+|\\d+\\.\\d+|\\d+)([Ee][+\\-]?\\d+)?$");
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("-123.456e789")); // true
    }
}
