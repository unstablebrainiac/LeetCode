package dailychallenges.december2023;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 */
public class Largest3SameDigitNumberInString {
    public String largestGoodInteger(String num) {
        return IntStream.range(0, num.length() - 2)
                .filter(i -> num.charAt(i) == num.charAt(i + 1) && num.charAt(i) == num.charAt(i + 2))
                .mapToObj(num::charAt)
                .map(String::valueOf)
                .max(String::compareTo)
                .map(c -> c.repeat(3))
                .orElse("");
    }

    public static void main(String[] args) {
        System.out.println(new Largest3SameDigitNumberInString().largestGoodInteger("6777133339")); // 777
    }
}
