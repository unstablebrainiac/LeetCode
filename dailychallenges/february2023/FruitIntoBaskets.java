package dailychallenges.february2023;

/*
 * https://leetcode.com/problems/fruit-into-baskets/
 */
public class FruitIntoBaskets {
    public int totalFruit(int[] fruits) {
        int start = 0, end1 = -1, end2 = -1;
        int current1 = -1, current2 = -1;
        int maxSoFar = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] == current1) {
                end1 = i;
            } else if (fruits[i] == current2) {
                end2 = i;
            } else {
                if (end1 < end2) {
                    current1 = fruits[i];
                    start = end1 + 1;
                    end1 = i;
                } else {
                    current2 = fruits[i];
                    start = end2 + 1;
                    end2 = i;
                }
            }
            maxSoFar = Math.max(maxSoFar, i - start + 1);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new FruitIntoBaskets().totalFruit(
                new int[]{1, 1, 6, 5, 6, 6, 1, 1, 1, 1}
        )); // 6
    }
}
