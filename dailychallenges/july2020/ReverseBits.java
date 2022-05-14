package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3388/
 */
public class ReverseBits {
    public int reverseBits(int n) {
        StringBuilder reverse = new StringBuilder(Integer.toUnsignedString(n, 2)).reverse();
        return Integer.parseUnsignedInt(reverse + "0".repeat(32 - reverse.toString().length()), 2);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(43261596)); // -1073741825
    }
}
