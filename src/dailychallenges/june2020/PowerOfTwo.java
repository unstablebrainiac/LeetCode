package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n != 0 && n != Integer.MIN_VALUE && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(16)); // true
    }
}
