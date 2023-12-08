package dailychallenges.december2023;

/*
 * https://leetcode.com/problems/largest-odd-number-in-string/
 */
public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        Integer lastIndex = null;
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Integer.parseInt("" + num.charAt(i)) % 2 != 0) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex == null) {
            return "";
        }
        return num.substring(0, lastIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LargestOddNumberInString().largestOddNumber("52")); // 5
    }
}
