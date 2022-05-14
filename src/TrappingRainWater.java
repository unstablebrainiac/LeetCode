/*
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int min = 0, max = height.length - 1, total = 0, level = 0;
        while (min < max) {
            if (height[min] < height[max]) {
                level = Math.max(height[min++], level);
                total += Math.max(level - height[min], 0);
            } else {
                level = Math.max(height[max--], level);
                total += Math.max(level - height[max], 0);
            }
        }
        return total;
    }

    private int trap(int[] height, int depth) {
        int i, j;
        for (i = 0; i < height.length; i++) {
            if (height[i] > depth) {
                break;
            }
        }
        for (j = height.length - 1; j >= 0; j--) {
            if (height[j] > depth) {
                break;
            }
        }
        if (i >= j) {
            return 0;
        }
        return hollow(height, i, j, depth) + trap(height, depth + 1);
    }

    private int hollow(int[] height, int i, int j, int depth) {
        int hollow = 0;
        for (int k = i + 1; k < j; k++) {
            if (height[k] <= depth) {
                hollow++;
            }
        }
        return hollow;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater().trap(
                new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}
        )); // 6
    }
}
