package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3381/
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4)); // 2
    }
}
