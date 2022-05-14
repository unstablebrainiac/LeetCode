package dailychallenges.october2020;

/*
 * https://leetcode.com/explore/featured/card/october-leetcoding-challenge/559/week-1-october-1st-october-7th/3484/
 */
public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        return N ^ Integer.parseInt("1".repeat(Integer.toBinaryString(N).length()), 2);
    }

    public static void main(String[] args) {
        System.out.println(new ComplementOfBase10Integer().bitwiseComplement(10)); // 5
    }
}
