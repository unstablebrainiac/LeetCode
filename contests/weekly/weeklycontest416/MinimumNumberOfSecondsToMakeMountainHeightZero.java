package contests.weekly.weeklycontest416;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/
 */
public class MinimumNumberOfSecondsToMakeMountainHeightZero {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        List<Long> stepsList = new ArrayList<>();
        long step = 1;
        long stepStep = 1;
        while (stepStep <= mountainHeight) {
            stepsList.add(step);
            stepStep++;
            step += stepStep;
        }

        long left = 1;
        long right = step * workerTimes[0];

        while (left < right) {
            long mid = left + (right - left) / 2;
            if (isPossible(mountainHeight, workerTimes, mid, stepsList)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isPossible(int mountainHeight, int[] workerTimes, long time, List<Long> stepsList) {
        long height = 0;
        for (int workerTime : workerTimes) {
            long steps = time / workerTime;
            int lowerBound = Collections.binarySearch(stepsList, steps);
            if (lowerBound < 0) {
                lowerBound = -lowerBound - 2;
            }
            height += lowerBound + 1;
        }
        return height >= mountainHeight;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfSecondsToMakeMountainHeightZero().minNumberOfSeconds(10, new int[]{3, 2, 2, 4})); // 12
    }
}
