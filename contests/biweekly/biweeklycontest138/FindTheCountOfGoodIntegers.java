package contests.biweekly.biweeklycontest138;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/find-the-count-of-good-integers/
 */
public class FindTheCountOfGoodIntegers {

    public long countGoodIntegers(int n, int k) {
        long count = 0;

        int digitChoices = (int) Math.ceil((double) n / 2);
        Set<String> checkedSortedPalindromes = new HashSet<>();
        for (int i = (int) Math.pow(10, digitChoices - 1); i < Math.pow(10, digitChoices); i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s);
            sb.reverse();
            if (n % 2 == 1) {
                sb.deleteCharAt(0);
            }
            String palindrome = s + sb.toString();
            long num = Long.parseLong(palindrome);
            if (num % k == 0) {
                String sortedPalindrome = new String(palindrome.chars().sorted().toArray(), 0, palindrome.length());
                if (checkedSortedPalindromes.contains(sortedPalindrome)) {
                    continue;
                }
                checkedSortedPalindromes.add(sortedPalindrome);
                long count1 = permutationCount(palindrome, true);
                count += count1;
            }
        }
        return count;
    }

    private long permutationCount(String s, boolean checkLeadingZero) {
        long count = 1;
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }
        long factorial = 1;
        for (int i = 1; i <= s.length(); i++) {
            factorial *= i;
        }
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 1) {
                long f = 1;
                for (int j = 1; j <= freq[i]; j++) {
                    f *= j;
                }
                count *= f;
            }
        }
        long permutations = factorial / count;
        if (checkLeadingZero && s.contains("0")) {
            String sWithoutOneZero = s.replaceFirst("0", "");
            long permutationsWithoutOneZero = permutationCount(sWithoutOneZero, false);
            permutations -= permutationsWithoutOneZero;
        }
        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheCountOfGoodIntegers().countGoodIntegers(5, 6)); // 2468
    }
}
