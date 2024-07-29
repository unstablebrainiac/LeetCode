package contests.weekly.weeklycontest384;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/maximum-palindromes-after-operations/
 */
public class MaximumPalindromesAfterOperations {
    public int maxPalindromesAfterOperations(String[] words) {
        List<Integer> lengths = Arrays.stream(words)
                .mapToInt(String::length)
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        Map<Character, Long> frequency = Arrays.stream(words)
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int odds = (int) frequency.values().stream().filter(num -> num % 2 == 1).count();
        int evens = frequency.values().stream().mapToInt(Math::toIntExact).sum() - odds;

        int count = 0;
        for (int i = 0; i < lengths.size(); i++) {
            int length = lengths.get(i);
            if (length % 2 == 1) {
                odds--;
                length--;
            }
            evens -= length;

            if (odds < 0) {
                odds += 2;
                evens -= 2;
            }
            if (evens < 0) {
                break;
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumPalindromesAfterOperations().maxPalindromesAfterOperations(new String[]{"abbb", "ba", "aa"})); // 3
    }
}
