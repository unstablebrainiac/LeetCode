package companies.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RecordBreaker {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(read.readLine());
            int[] visitors = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = 0;
            int count = 0;
            for (int j = 0; j < visitors.length; j++) {
                if (visitors[j] > max && (j == visitors.length - 1 || visitors[j] > visitors[j + 1])) {
                    count++;
                }
                max = Math.max(max, visitors[j]);
            }
            System.out.println("Case #" + (i + 1) + ": " + count);
        }
    }
}
