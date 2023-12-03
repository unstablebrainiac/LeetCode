package weeklycontest372;

/*
 * https://leetcode.com/problems/make-three-strings-equal/
 */
public class MakeThreeStringsEqual {
    public int findMinimumOperations(String s1, String s2, String s3) {
        if (s1.charAt(0) != s2.charAt(0) || s2.charAt(0) != s3.charAt(0)) {
            return -1;
        }
        int i = 1;
        for (; i < Math.min(s1.length(), Math.min(s2.length(), s3.length())); i++) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
                continue;
            }
            break;
        }
        return s1.length() + s2.length() + s3.length() - 3 * i;
    }

    public static void main(String[] args) {
        System.out.println(new MakeThreeStringsEqual().findMinimumOperations(
                "abc",
                "abb",
                "ab"
        )); // 2
    }
}
