package dailychallenges.august2020;

/*
 * https://leetcode.com/explore/featured/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3409/
 */
public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        return word.toUpperCase().equals(word) || word.toLowerCase().equals(word) || word.substring(1).toLowerCase().equals(word.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(new DetectCapital().detectCapitalUse("FlaG")); // false
    }
}
