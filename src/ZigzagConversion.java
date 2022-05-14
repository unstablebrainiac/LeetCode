import java.util.Arrays;
import java.util.Objects;

/*
 * https://leetcode.com/problems/zigzag-conversion/
 */
public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        int j = 0;
        boolean addition = true;
        for (int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (stringBuilders[j] == null) {
                stringBuilders[j] = new StringBuilder();
            }
            stringBuilders[j].append(c);
            if (addition) {
                j++;
                if (j == numRows - 1) {
                    addition = false;
                }
            } else {
                j--;
                if (j == 0) {
                    addition = true;
                }
            }
        }
        return new String(Arrays.stream(stringBuilders).filter(Objects::nonNull).reduce(StringBuilder::append).get());
    }

    public static void main(String[] args) {
        System.out.println(new ZigzagConversion().convert("AB", 1)); // PAHNAPLSIIGYIR
    }
}
