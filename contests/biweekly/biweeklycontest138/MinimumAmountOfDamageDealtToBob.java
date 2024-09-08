package contests.biweekly.biweeklycontest138;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/minimum-amount-of-damage-dealt-to-bob/
 */
public class MinimumAmountOfDamageDealtToBob {

    public long minDamage(int power, int[] damage, int[] health) {
        int[] hits = new int[health.length];
        for (int i = 0; i < health.length; i++) {
            hits[i] = (int) Math.ceil((double) health[i] / power);
        }

        long currentDamage = Arrays.stream(damage).sum();
        long totalDamage = 0;

        List<Integer> killingOrder = IntStream.range(0, hits.length)
                .boxed()
                .sorted((a, b) -> damage[b] * hits[a] - damage[a] * hits[b])
                .toList();

        for (int i = 0; i < hits.length; i++) {
            int enemyToKill = killingOrder.get(i);

            totalDamage += currentDamage * hits[enemyToKill];
            currentDamage -= damage[enemyToKill];
        }

        return totalDamage;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumAmountOfDamageDealtToBob().minDamage(4, new int[]{1, 2, 3, 4}, new int[]{4, 5, 6, 8})); // 39
    }
}
