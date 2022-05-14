import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/multiply-strings/
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        return removeLeadingZeroes(
                add(
                        IntStream.range(0, num2.length())
                                .mapToObj(index -> multiply(
                                        num1,
                                        num2.charAt(num2.length() - 1 - index) - '0',
                                        0)
                                        + "0".repeat(index))
                                .collect(Collectors.toList()),
                        0
                )
        );
    }

    private String removeLeadingZeroes(String ans) {
        int i;
        for (i = 0; i < ans.length() - 1; i++) {
            char c = ans.charAt(i);
            if (c != '0') {
                return ans.substring(i);
            }
        }
        return ans.substring(i);
    }

    private String multiply(String num, int digit, int carry) {
        if (digit == 0) {
            return "0";
        }
        if (num.isEmpty()) {
            return carry == 0 ? "" : String.valueOf(carry);
        }
        int product = lastDigit(num) * digit + carry;
        return multiply(num.substring(0, num.length() - 1), digit, product / 10) + product % 10;
    }

    private String add(List<String> strings, int carry) {
        if (strings.size() == 0) {
            return carry == 0 ? "" : String.valueOf(carry);
        }
        int sum = strings.stream().mapToInt(this::lastDigit).sum() + carry;
        return add(
                strings
                        .stream()
                        .map(s -> s.substring(0, s.length() - 1))
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.toList()),
                sum / 10)
                + sum % 10;
    }

    private int lastDigit(String num1) {
        return num1.charAt(num1.length() - 1) - '0';
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123", "456")); // "56088"
    }
}
