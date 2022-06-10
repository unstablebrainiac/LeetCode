import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/bus-routes/
 */
public class BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        List<Integer> current = Collections.singletonList(source);

        Map<Integer, List<Integer>> stopToBusesMap = new HashMap<>();
        for (int busNumber = 0; busNumber < routes.length; busNumber++) {
            for (int stop : routes[busNumber]) {
                addStop(stopToBusesMap, stop, busNumber);
            }
        }

        Set<Integer> visited = new HashSet<>();

        int ans = 0;
        while (current.stream().noneMatch(stop -> stop == target)) {
            current = current.stream()
                    .flatMap(stop -> Optional.ofNullable(stopToBusesMap.get(stop)).orElse(Collections.emptyList()).stream())
                    .filter(o -> !visited.contains(o))
                    .peek(visited::add)
                    .flatMapToInt(bus -> Arrays.stream(routes[bus]))
                    .distinct()
                    .boxed()
                    .collect(Collectors.toList());
            ans++;
            if (current.isEmpty()) {
                return -1;
            }
        }
        return ans;
    }

    private void addStop(Map<Integer, List<Integer>> nextStops, int prev, int next) {
        List<Integer> newList = new ArrayList<>();
        newList.add(next);
        nextStops.merge(prev, newList, (stops, newStop) -> {
            stops.add(newStop.get(0));
            return stops;
        });
    }

    public static void main(String[] args) {
        System.out.println(new BusRoutes().numBusesToDestination(
                new int[][]{
                        new int[]{1, 2, 7},
                        new int[]{3, 6, 7}
                },
                1,
                6
        )); // 2
    }
}
