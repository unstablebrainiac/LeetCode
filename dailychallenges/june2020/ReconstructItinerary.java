package dailychallenges.june2020;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
 */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        return findItinerary(tickets, "JFK", 0);
    }

    private List<String> findItinerary(List<List<String>> tickets, String from, int index) {
        long count = tickets.stream()
                .filter(strings -> strings.get(0).equals(from))
                .count();

        if (count == 0) {
            if (!tickets.isEmpty()) {
                return Collections.emptyList();
            }
            return new LinkedList<>(Collections.singletonList(from));
        }

        List<String> flight = tickets.stream()
                .filter(strings -> strings.get(0).equals(from))
                .sorted(Comparator.comparing(o -> o.get(1)))
                .skip(index)
                .findFirst()
                .get();

        tickets.remove(flight);
        List<String> itinerary = findItinerary(tickets, flight.get(1), 0);
        tickets.add(flight);
        if (!itinerary.isEmpty()) {
            itinerary.add(0, from);
            return itinerary;
        }
        if (count == index + 1) {
            return itinerary;
        }
        return findItinerary(tickets, from, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new ReconstructItinerary().findItinerary(
                new LinkedList<>(asList(
                        asList("JFK", "SFO"),
                        asList("JFK", "ATL"),
                        asList("SFO", "ATL"),
                        asList("ATL", "JFK"),
                        asList("ATL", "SFO")
                )
                ))); // [JFK, ATL, JFK, SFO, ATL, SFO]
    }
}
