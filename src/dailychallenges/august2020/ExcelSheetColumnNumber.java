package dailychallenges.august2020;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3419/
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if (s.length() == 1) {
            return s.charAt(0) - 'A' + 1;
        }
        return 26 * titleToNumber(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1) - 'A' + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY")); // 701
    }
}
