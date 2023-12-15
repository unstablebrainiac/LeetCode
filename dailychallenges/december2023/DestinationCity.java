package dailychallenges.december2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/destination-city/
 */
public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        Set<String> startNodes = paths.stream()
                .map(path -> path.get(0))
                .collect(Collectors.toSet());
        return paths.stream()
                .map(path -> path.get(1))
                .filter(node -> !startNodes.contains(node))
                .findFirst()
                .orElseThrow();
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));
        System.out.println(new DestinationCity().destCity(paths)); // "Sao Paulo"
    }
}
