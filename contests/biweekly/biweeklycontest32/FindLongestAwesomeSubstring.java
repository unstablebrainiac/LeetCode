package contests.biweekly.biweeklycontest32;

/*
 * https://leetcode.com/contest/biweekly-contest-32/problems/find-longest-awesome-substring/
 */
public class FindLongestAwesomeSubstring {
    public int longestAwesome(String s) {
        int[] totalCounts = new int[10];
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            totalCounts[digit]++;
        }
        int maxCount = 0;
        boolean atLeastOneOdd = false;
        for (int i = 0; i < 10; i++) {
            if (totalCounts[i] % 2 == 0) {
                maxCount += totalCounts[i];
            } else {
                maxCount += totalCounts[i] - 1;
                atLeastOneOdd = true;
            }
        }
        if (atLeastOneOdd) {
            maxCount++;
        }

        for (int i = maxCount; i > 1; i--) {
            if (hasAwesomeSubstring(s, i)) {
                return i;
            }
        }
        return 1;
    }

    private boolean hasAwesomeSubstring(String s, int i) {
        if (i % 2 == 0) {
            return hasEvenSubstring(s, i);
        } else {
            return hasOddSubstring(s, i);
        }
    }

    private boolean hasOddSubstring(String s, int i) {
        boolean[] oddOccurences = new boolean[10];
        for (int j = 0; j < i; j++) {
            int digit = s.charAt(j) - '0';
            toggle(oddOccurences, digit);
        }
        if (checkAtMostOneTrue(oddOccurences)) {
            return true;
        }
        for (int j = 0; j < s.length() - i; j++) {
            toggle(oddOccurences, s.charAt(j) - '0');
            toggle(oddOccurences, s.charAt(j + i) - '0');
            if (checkAtMostOneTrue(oddOccurences)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkAtMostOneTrue(boolean[] oddOccurences) {
        boolean oneTrue = false;
        for (int i = 0; i < 10; i++) {
            if (oddOccurences[i]) {
                if (oneTrue) {
                    return false;
                } else {
                    oneTrue = true;
                }
            }
        }
        return true;
    }

    private boolean hasEvenSubstring(String s, int i) {
        boolean[] oddOccurences = new boolean[10];
        for (int j = 0; j < i; j++) {
            int digit = s.charAt(j) - '0';
            toggle(oddOccurences, digit);
        }
        if (checkAllFalse(oddOccurences)) {
            return true;
        }
        for (int j = 0; j < s.length() - i; j++) {
            toggle(oddOccurences, s.charAt(j) - '0');
            toggle(oddOccurences, s.charAt(j + i) - '0');
            if (checkAllFalse(oddOccurences)) {
                return true;
            }
        }
        return false;
    }

    private void toggle(boolean[] oddOccurences, int digit) {
        oddOccurences[digit] = !oddOccurences[digit];
    }

    private boolean checkAllFalse(boolean[] oddOccurences) {
        for (boolean oddOccurence : oddOccurences) {
            if (oddOccurence) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new FindLongestAwesomeSubstring().longestAwesome("3242415")); // 5
        System.out.println(new FindLongestAwesomeSubstring().longestAwesome("9498331")); // 5
    }
}
