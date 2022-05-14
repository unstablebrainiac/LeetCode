package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3364/
 */
public class HIndex2 {
    public int hIndex(int[] citations) {
        return binarySearch(citations);
    }

    private int binarySearch(int[] citations) {
        int low = 0;
        int high = citations.length - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = citations[mid];

            if (midVal < citations.length - mid)
                low = mid + 1;
            else if (midVal > citations.length - mid)
                high = mid - 1;
            else
                return midVal; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static void main(String[] args) {
        System.out.println(new HIndex2().hIndex(
                new int[]{0, 1, 4, 5, 6}
        ));
    }
}
