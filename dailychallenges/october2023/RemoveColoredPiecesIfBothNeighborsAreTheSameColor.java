package dailychallenges.october2023;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/remove-colored-pieces-if-both-neighbors-are-the-same-color/
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public boolean winnerOfGame(String colors) {
        char current = 'A';
        int currentCount = 0;
        Map<Character, Integer> count = new HashMap<>(Map.of('A', 0, 'B', 0));
        for (char c : colors.toCharArray()) {
            if (current == c) {
                currentCount++;
            } else {
                current = c;
                currentCount = 1;
            }
            if (currentCount > 2) {
                count.put(current, count.get(current) + 1);
            }
        }
        return count.get('A') > count.get('B');
    }

    public static void main(String[] args) {
        System.out.println(new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().winnerOfGame("AAABABB")); // true
    }
}
