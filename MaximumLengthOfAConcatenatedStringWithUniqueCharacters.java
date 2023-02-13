import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        List<Set<Character>> words = arr.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        str -> str.chars()
                                .mapToObj(value -> (char) value)
                                .collect(Collectors.toSet())
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().length() == entry.getValue().size())
                .map(Map.Entry::getValue)
                .distinct()
                .collect(Collectors.toList());

        return maxLength(words, 0, new HashSet<>());
    }

    private int maxLength(List<Set<Character>> words, int startIndex, Set<Character> stringSoFar) {
        if (startIndex == words.size()) {
            return stringSoFar.size();
        }
        Set<Character> currentWord = words.get(startIndex);

        int maxWithoutCurrentWord = maxLength(words, startIndex + 1, stringSoFar);
        if (stringSoFar.stream().anyMatch(currentWord::contains)) {
            return maxWithoutCurrentWord;
        }
        Set<Character> clone = new HashSet<>(stringSoFar);
        clone.addAll(currentWord);
        return Math.max(maxWithoutCurrentWord, maxLength(words, startIndex + 1, clone));
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfAConcatenatedStringWithUniqueCharacters().maxLength(
                Arrays.asList("un", "iq", "ue")
        ));
    }
}
