/*
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i ; j--) {
                int area = (j - i) * Math.min(height[i], height[j]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }
}
