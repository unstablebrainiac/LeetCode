package weeklycontest407;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/number-of-bit-changes-to-make-two-integers-equal/
 */
public class NumberOfBitChangesToMakeTwoIntegersEqual {

    public int minChanges(int n, int k) {
        if (n == k) {
            return 0;
        }
        if (k > n) {
            return -1;
        }
        String nBinary = Integer.toBinaryString(n);
        String kBinary = Integer.toBinaryString(k);

        int diff = nBinary.length() - kBinary.length();
        int ans = (int) IntStream.range(0, diff).filter(i -> nBinary.charAt(i) == '1').count();

        for (int i = 0; i < kBinary.length(); i++) {
            char kChar = kBinary.charAt(i);
            char nChar = nBinary.charAt(diff + i);

            if (kChar != nChar) {
                if (kChar == '1') {
                    return -1;
                }
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfBitChangesToMakeTwoIntegersEqual().minChanges(13, 4)); // 2
    }
}
