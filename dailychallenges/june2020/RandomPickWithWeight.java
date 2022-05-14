package dailychallenges.june2020;

import java.util.Arrays;
import java.util.Random;

public class RandomPickWithWeight {

    private final int[] arr;
    private final int count;

    public RandomPickWithWeight(int[] w) {
        arr = w;
        count = Arrays.stream(w).sum();
    }

    public int pickIndex() {
        Random random = new Random();
        int index = random.nextInt(count);
        for (int i = 0; i < arr.length; i++) {
            if (index < arr[i]) {
                return i;
            }
            index -= arr[i];
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        System.out.println(new RandomPickWithWeight(new int[]{1, 3}).pickIndex());
    }
}
