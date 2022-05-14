package weeklycontest194;

import java.util.*;

/*
 * https://leetcode.com/contest/weekly-contest-194/problems/avoid-flood-in-the-city/
 */
public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        Queue<Integer> zeroIndexes = new PriorityQueue<>();
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        Map<Integer, Integer> fullLakes = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                ans[i] = -1;
                Integer index = fullLakes.get(rains[i]);
                if (index == null) {
                    fullLakes.put(rains[i], i);
                } else {
                    Integer poll = zeroIndexes.poll();
                    if (poll == null || poll > i) {
                        return new int[]{};
                    }
                    ans[poll] = rains[i];
                }
            } else {
                zeroIndexes.add(i);
            }
        }
        return ans;
    }

//    public int[] avoidFlood(int[] rains) {
//        int[] ans = new int[rains.length];
//        Set<Integer> fullLakes = new HashSet<>();
//        int numZeroes = 0;
//        for (int i = 0; i < rains.length; i++) {
//            if (rains[i] != 0) {
//                if (numZeroes == 0) {
//                    ans[i] = rains[i];
//                    fullLakes.add(rains[i]);
//                    continue;
//                }
//                if (fullLakes.size() <= numZeroes) {
//                    populateZeroes(ans, i, numZeroes, fullLakes);
//                }
//            } else {
//                numZeroes++;
//            }
//        }
//    }
//
//    private void populateZeroes(int[] ans, int endIndex, int numZeroes, Set<Integer> fullLakes) {
//        Iterator<Integer> iterator = fullLakes.iterator();
//        for (int i = endIndex - numZeroes; i < endIndex; i++) {
//            if (iterator.hasNext()) {
//                ans[i] = iterator.next();
//                fullLakes.remove(ans[i]);
//            } else {
//                ans[i] = 1;
//            }
//        }
//    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new AvoidFloodInTheCity().avoidFlood(
                new int[]{1, 2, 0, 0, 2, 1}
        )));
    }
}
