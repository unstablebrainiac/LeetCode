package dailychallenges.august2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3427/
 */
public class DistributeCandiesToPeople {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int given = 0;
        int i = 1;
        while (given < candies) {
            int person = (i - 1) % num_people;
            ans[person] += (given + i > candies) ? candies - given : i;
            given += i;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DistributeCandiesToPeople().distributeCandies(10, 3))); // [5,2,3]
    }
}
