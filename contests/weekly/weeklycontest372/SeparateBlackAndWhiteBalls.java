package contests.weekly.weeklycontest372;

/*
 * https://leetcode.com/problems/separate-black-and-white-balls/
 */
public class SeparateBlackAndWhiteBalls {
    public long minimumSteps(String s) {
        int black = 0;
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                black++;
            } else {
                ans += black;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SeparateBlackAndWhiteBalls().minimumSteps("101")); // 1
    }
}
