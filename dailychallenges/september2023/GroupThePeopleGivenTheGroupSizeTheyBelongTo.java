package dailychallenges.september2023;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
 */
public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        return IntStream.range(0, groupSizes.length)
                .boxed()
                .collect(Collectors.groupingBy(i -> groupSizes[i]))
                .entrySet()
                .stream()
                .flatMap(entry ->
                        IntStream.range(0, entry.getValue().size() / entry.getKey())
                                .mapToObj(i -> entry.getValue().subList(i * entry.getKey(), (i + 1) * entry.getKey()))
                )
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new GroupThePeopleGivenTheGroupSizeTheyBelongTo().groupThePeople(
                new int[]{3, 3, 3, 3, 3, 1, 3}
        )); // [[5],[0,1,2],[3,4,6]]
    }
}
