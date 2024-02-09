package dailychallenges.february2024;

import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/sort-characters-by-frequency/
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        return s.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(entry -> entry.getKey().repeat(Math.toIntExact(entry.getValue())))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("tree")); // eert
    }
}
