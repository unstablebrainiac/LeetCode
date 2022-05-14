package dailychallenges.july2020;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3404/
 */
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, List<Character>> frequencyMap = IntStream.range(0, tasks.length)
                .mapToObj(value -> tasks[value])
                .collect(Collectors.groupingBy(character -> character));

        int maxFrequency = frequencyMap.values()
                .stream()
                .mapToInt(List::size)
                .max()
                .getAsInt();

        long count = frequencyMap.values()
                .stream()
                .filter(characters -> characters.size() == maxFrequency)
                .count();

        return (int) Math.max(tasks.length, count + (maxFrequency - 1) * (n + 1));
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().leastInterval(
                new char[]{'A', 'A', 'A', 'B', 'B', 'B'},
                2
        )); // 8
    }
}
