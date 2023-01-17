package dailychallenges.january2023;

/*
 * https://leetcode.com/problems/flip-string-to-monotone-increasing/
 */
public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        int totalOnes = s.chars().map(Character::getNumericValue).sum();
        int flips = s.length() - totalOnes;
        int minFlips = flips;
        for (int partition = 0; partition < s.length(); partition++) {
            if (s.charAt(partition) == '0') {
                flips--;
            } else {
                flips++;
            }
            minFlips = Math.min(flips, minFlips);
        }
        return minFlips;
    }

    public static void main(String[] args) {
        System.out.println(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr("00110")); // 1
    }
}
