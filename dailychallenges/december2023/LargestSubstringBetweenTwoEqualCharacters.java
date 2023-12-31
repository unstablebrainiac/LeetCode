package dailychallenges.december2023;

/*
 * https://leetcode.com/problems/largest-substring-between-two-equal-characters/
 */
public class LargestSubstringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        Integer[] firstIndex = new Integer[26];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (firstIndex[index] == null) {
                firstIndex[index] = i;
            } else {
                max = Math.max(max, i - firstIndex[index]);
            }
        }
        return max - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters().maxLengthBetweenEqualCharacters("abca")); // 2
    }
}
