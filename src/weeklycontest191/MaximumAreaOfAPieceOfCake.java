package weeklycontest191;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-191/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
 */
public class MaximumAreaOfAPieceOfCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int[] horizontalSizes = getSizesFromCuts(horizontalCuts, h);
        int[] verticalSizes = getSizesFromCuts(verticalCuts, w);
        Arrays.sort(horizontalSizes);
        Arrays.sort(verticalSizes);
        return (int) ((horizontalSizes[horizontalSizes.length - 1] * verticalSizes[verticalSizes.length - 1]) % (Math.pow(10, 9) + 7));
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
        System.out.println(new MaximumAreaOfAPieceOfCake().maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3})); // 6
    }
}
