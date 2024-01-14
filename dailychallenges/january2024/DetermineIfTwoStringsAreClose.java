package dailychallenges.january2024;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/determine-if-two-strings-are-close/
 */
public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        Map<Character, Long> frequency1 = getFrequency(word1);
        Map<Character, Long> frequency2 = getFrequency(word2);

        if (!frequency1.keySet().equals(frequency2.keySet())) {
            return false;
        }

        Map<Long, Long> frequencyOfFrequency1 = getFrequencyOfFrequency(frequency1);
        Map<Long, Long> frequencyOfFrequency2 = getFrequencyOfFrequency(frequency2);

        return frequencyOfFrequency1.equals(frequencyOfFrequency2);
    }

    private Map<Character, Long> getFrequency(String str) {
        return str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private Map<Long, Long> getFrequencyOfFrequency(Map<Character, Long> frequency) {
        return frequency.values()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings("cabbba", "abbccc")); // true
    }
}
