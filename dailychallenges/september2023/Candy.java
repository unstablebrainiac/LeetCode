package dailychallenges.september2023;

/*
 * https://leetcode.com/problems/candy/
 */
public class Candy {

    public int candy(int[] ratings) {
        int increasingSequenceLength = 0, decreasingSequenceLength = 0, currentCandy = 0, totalCandy = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                increasingSequenceLength++;
                decreasingSequenceLength = 0;
                currentCandy = increasingSequenceLength + 1;
                totalCandy += currentCandy;
            } else if (ratings[i] == ratings[i - 1]) {
                increasingSequenceLength = 0;
                decreasingSequenceLength = 0;
                currentCandy = 0;
                totalCandy++;
            } else {
                decreasingSequenceLength++;
                increasingSequenceLength = 0;
                totalCandy += decreasingSequenceLength + (decreasingSequenceLength >= currentCandy ? 1 : 0);
            }
        }
        return totalCandy;
    }

    public static void main(String[] args) {
        System.out.println(new Candy().candy(new int[]{1, 0, 2})); // 5
    }
}
