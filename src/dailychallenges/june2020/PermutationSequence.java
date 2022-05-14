package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        if (k == 0) {
            return "1".repeat(n);
        }
        return increment(getPermutation(n, k - 1), n);
    }

    private String increment(String num, int n) {
        int lastDigit = Integer.parseInt(num.substring(num.length() - 1));
        if (lastDigit == n) {
            return increment(num.substring(0, num.length() - 1), n) + "1";
        }
        return num.substring(0, num.length() - 1) + (lastDigit + 1);
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(4, 9)); // 2314
    }
}
