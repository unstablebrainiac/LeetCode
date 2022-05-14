package google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlienPiano {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(read.readLine());
            int[] notes = Arrays.stream(read.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = 1;
            int min = 1;
            int note = 4;
            int count = 0;
            for (int j = 1; j < notes.length; j++) {
                max = Math.max(max, note);
                min = Math.min(min, note);
                if (notes[j] > notes[j - 1]) {
                    note++;
                } else if (notes[j] < notes[j - 1]) {
                    note--;
                }
                if (note == 0 || note == 8) {
                    note = 4;
                    count++;
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + Math.max(max - min - 4, 0));
        }
    }
}
