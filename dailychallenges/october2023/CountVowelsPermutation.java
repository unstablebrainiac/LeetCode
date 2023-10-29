package dailychallenges.october2023;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/count-vowels-permutation/
 */
public class CountVowelsPermutation {
    public int countVowelPermutation(int n) {
        Map<Character, List<Character>> next = Map.of(
                'a', List.of('e'),
                'e', List.of('a', 'i'),
                'i', List.of('a', 'e', 'o', 'u'),
                'o', List.of('i', 'u'),
                'u', List.of('a')
        );

        Map<Character, Long> count = new HashMap<>(Map.of(
                'a', 1L,
                'e', 1L,
                'i', 1L,
                'o', 1L,
                'u', 1L
        ));

        for (int i = 1; i < n; i++) {
            Map<Character, Long> nextCount = next.entrySet()
                    .stream()
                    .flatMap(entry -> entry.getValue().stream().map(c -> Map.entry(c, count.get(entry.getKey()))))
                    .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue() % 1000000007, Long::sum));

            count.putAll(nextCount);
        }

        return (int) (count.values().stream().mapToLong(a -> a).sum() % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new CountVowelsPermutation().countVowelPermutation(5)); // 68
    }
}
