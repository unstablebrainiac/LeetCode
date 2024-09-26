package contests.weekly.weeklycontest416;

/*
 * https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-ii/
 */
public class CountSubstringsThatCanBeRearrangedToContainAString2 {

    public long validSubstringCount(String word1, String word2) {
        int[] word2Count = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            word2Count[word2.charAt(i) - 'a']++;
        }

        int startInclusive = 0;
        int endExclusive = 0;
        long count = 0;
        int[] currentCount = new int[26];
        while (endExclusive < word1.length()) {
            if (isPossible(currentCount, word2Count)) {
                count += word1.length() - endExclusive + 1;
                currentCount[word1.charAt(startInclusive) - 'a']--;
                startInclusive++;
            } else {
                currentCount[word1.charAt(endExclusive) - 'a']++;
                endExclusive++;
            }
        }
        while (startInclusive < word1.length()) {
            if (isPossible(currentCount, word2Count)) {
                count++;
            } else {
                break;
            }
            currentCount[word1.charAt(startInclusive) - 'a']--;
            startInclusive++;
        }

        return count;
    }

    private boolean isPossible(int[] currentCount, int[] word2Count) {
        for (int i = 0; i < 26; i++) {
            if (currentCount[i] < word2Count[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstringsThatCanBeRearrangedToContainAString2().validSubstringCount("ddccdddccdddccccdddccdcdcd", "ddc")); // 279
    }
}
