package contests.weekly.weeklycontest193;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-193/problems/least-number-of-unique-integers-after-k-removals/
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            frequency.merge(arr[i], 1, Integer::sum);
        }
        ArrayList<Integer> integers = new ArrayList<>(frequency.values());
        integers.sort(Integer::compareTo);
        int size = integers.size();
        for (Integer integer : integers) {
            if (integer > k) {
                return size;
            }
            k -= integer;
            size--;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new LeastNumberOfUniqueIntegersAfterKRemovals().findLeastNumOfUniqueInts(
                new int[]{4, 3, 1, 1, 3, 3, 2},
                3
        ));
    }
}
