package biweeklycontest32;

/*
 * https://leetcode.com/contest/biweekly-contest-32/problems/minimum-insertions-to-balance-a-parentheses-string/
 */
public class MinimumInsertionsToBalanceAParenthesesString {
    public int minInsertions(String s) {
        int countRight = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (countRight % 2 == 0) {
                    countRight += 2;
                } else {
                    count++;
                    countRight++;
                }
            } else {
                if (countRight == 0) {
                    count++;
                    countRight++;
                } else {
                    countRight--;
                }
            }
        }
        return count + countRight;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumInsertionsToBalanceAParenthesesString().minInsertions("(()))(()))()())))")); // 4
    }
}
