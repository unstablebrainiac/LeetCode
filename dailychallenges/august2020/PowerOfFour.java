package dailychallenges.august2020;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3412/
 */
public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        return Integer.bitCount(num) == 1 && Integer.toBinaryString(num).length() % 2 == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(16)); // true
    }
}
