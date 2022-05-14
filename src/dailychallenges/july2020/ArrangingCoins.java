package dailychallenges.july2020;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        for (long i = (long) Math.ceil(Math.sqrt(2) * Math.sqrt(n)); i >= 0; i--) {
            long product = i * (i + 1) / 2;
            if (product <= n) {
                return (int) i;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(8)); // 3
    }
}
