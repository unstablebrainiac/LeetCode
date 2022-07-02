package dailychallenges.july2022;

import java.math.BigInteger;
import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] horizontalSizes = getSizesFromCuts(horizontalCuts, h);
        int[] verticalSizes = getSizesFromCuts(verticalCuts, w);
        Arrays.sort(horizontalSizes);
        Arrays.sort(verticalSizes);
        return new BigInteger(String.valueOf(horizontalSizes[horizontalSizes.length - 1]))
                .multiply(new BigInteger(String.valueOf(verticalSizes[verticalSizes.length - 1])))
                .mod(new BigInteger("1000000007")).intValue();
    }

    private int[] getSizesFromCuts(int[] cuts, int limit) {
        int[] sizes = new int[cuts.length + 1];
        if (cuts.length == 0) {
            sizes[0] = limit;
            return sizes;
        }
        sizes[0] = cuts[0];
        for (int i = 1; i < cuts.length; i++) {
            sizes[i] = cuts[i] - cuts[i - 1];
        }
        sizes[cuts.length] = limit - cuts[cuts.length - 1];
        return sizes;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts().maxArea(
                1000000000,
                1000000000,
                new int[]{2},
                new int[]{2}
        )); // 81
    }
}
