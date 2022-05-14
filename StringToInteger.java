import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String pattern = "^ *([+\\-]?(\\d+))";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            String result = m.group(1);
            boolean isNegative = result.charAt(0) == '-';
            try {
                return Integer.parseInt(result);
            } catch (NumberFormatException e) {
                if (isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("   -42 with words")); // -42
    }
}
