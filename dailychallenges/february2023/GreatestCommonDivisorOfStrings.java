package dailychallenges.february2023;

/*
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 */
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        for (int i = Math.min(length1, length2); i > 0; i--) {
            if (length1 % i != 0 || length2 % i != 0) {
                continue;
            }
            String substring = str1.substring(0, i);
            if (substring.repeat(length1 / i).equals(str1) && substring.repeat(length2 / i).equals(str2)) {
                return substring;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings(
                "ABABAB",
                "ABAB"
        )); // AB
    }
}
