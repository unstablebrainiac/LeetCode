package contests.biweekly.biweeklycontest31;

public class CountOddNumbersInAnIntervalRange {
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high - low) / 2;
        }
        if (low % 2 != 0) {
            return 1 + countOdds(low + 1, high);
        }
        return 1 + countOdds(low, high - 1);
    }

    public static void main(String[] args) {
        System.out.println(new CountOddNumbersInAnIntervalRange().countOdds(3, 7));
    }
}
