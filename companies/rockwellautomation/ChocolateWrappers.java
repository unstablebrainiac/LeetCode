package companies.rockwellautomation;

// 1000 250 62  16  4   1
// 1000 250 64  16  4   1

import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ChocolateWrappers {
    public static void main(String[] args) {
        int chocolates = 1000;
        int packets = 1000;
        while (packets >= 4) {
            chocolates++;
            packets -= 3;
        }
        System.out.println(chocolates);
        System.out.println(packets);

        long[] S = new long[1000];
        Stream.of(
                        IntStream.range(0, S.length - 1).mapToLong(i -> S[i + 1] - S[i]),
                        Stream.of(S[0]),
                        Stream.of(1000 - S[S.length - 1])
                )
                .flatMapToLong(s -> (LongStream) s)
                .map(distance -> distance / 10)
                .sum();
    }
}
