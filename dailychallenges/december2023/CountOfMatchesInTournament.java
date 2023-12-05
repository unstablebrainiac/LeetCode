package dailychallenges.december2023;

/*
 * https://leetcode.com/problems/count-of-matches-in-tournament/
 */
public class CountOfMatchesInTournament {
    public int numberOfMatches(int n) {
        int count = 0;
        while (n > 1) {
            count += n / 2;
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = (n + 1) / 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountOfMatchesInTournament().numberOfMatches(7)); // 6
    }
}
