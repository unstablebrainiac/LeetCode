package weeklycontest407;

/*
 * https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end/
 */
public class MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public int maxOperations(String s) {
        int count = 0, ans = 0, previous = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                count++;
                previous = 1;
            } else if (previous == 1) {
                ans += count;
                previous = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfOperationsToMoveOnesToTheEnd().maxOperations("1001101")); // 4
    }
}
