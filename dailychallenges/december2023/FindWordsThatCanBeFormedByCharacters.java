package dailychallenges.december2023;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> frequencyMap = chars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        return Arrays.stream(words)
                .filter(word -> {
                    Map<Character, Integer> wordFrequencyMap = word.chars()
                            .mapToObj(c -> (char) c)
                            .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));
                    return wordFrequencyMap.entrySet().stream()
                            .allMatch(entry -> frequencyMap.containsKey(entry.getKey()) && frequencyMap.get(entry.getKey()) >= entry.getValue());
                })
                .mapToInt(String::length)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new FindWordsThatCanBeFormedByCharacters().countCharacters(
                new String[]{"cat", "bt", "hat", "tree"},
                "atach"
        )); // 6
    }
}
