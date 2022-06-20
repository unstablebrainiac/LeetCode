package dailychallenges.june2022;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ShortEncodingOfWords {
    public int minimumLengthEncoding(String[] words) {
        return minimumLengthEncoding(Arrays.stream(words).collect(Collectors.toList()), 0, 0);
    }

    private int minimumLengthEncoding(List<String> words, int startIndex, int count) {
        if (words.size() == 1) {
            return words.get(0).length() + 1;
        }
        Map<Character, List<String>> lastCharToWordsMap = words
                .stream()
                .filter(word -> word.length() > startIndex)
                .collect(Collectors.groupingBy(word -> word.charAt(word.length() - startIndex - 1)));
        if (lastCharToWordsMap.size() == 0) {
            return count + 1;
        }
        return lastCharToWordsMap
                .values()
                .stream()
                .mapToInt(list -> minimumLengthEncoding(list, startIndex + 1, count + 1))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new ShortEncodingOfWords().minimumLengthEncoding(
                new String[]{"time", "me", "bell"}
        )); // 10
    }
}
