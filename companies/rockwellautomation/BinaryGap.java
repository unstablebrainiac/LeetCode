package companies.rockwellautomation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BinaryGap {

    public static void main(String[] args) {
        try {
            // Read input from test.txt
            BufferedReader reader = new BufferedReader(new FileReader("rockwellautomation/test.txt"));
            String line;
            StringBuilder output = new StringBuilder();

            // Process each input and append the results to output
            while ((line = reader.readLine()) != null) {
                int N = Integer.parseInt(line.trim());
                int result = solution(N);
                output.append(result);
            }

            System.out.println(output);

            // Close resources
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solution(int N) {
        // Convert N to binary representation
        String binaryString = Integer.toBinaryString(N);

        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                // If 1 is encountered, check if it's the end of a gap
                if (counting) {
                    maxGap = Math.max(maxGap, currentGap);
                    currentGap = 0;
                } else {
                    counting = true;
                }
            } else if (counting) {
                // If 0 is encountered while counting, increment the current gap
                currentGap++;
            }
        }

        return maxGap;
    }
}

