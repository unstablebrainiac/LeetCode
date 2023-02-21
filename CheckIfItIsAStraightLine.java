import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/check-if-it-is-a-straight-line/
 */
public class CheckIfItIsAStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        return IntStream.range(2, coordinates.length)
                .allMatch(i -> (coordinates[i][1] - coordinates[0][1]) * (coordinates[1][0] - coordinates[0][0])
                            == (coordinates[i][0] - coordinates[0][0]) * (coordinates[1][1] - coordinates[0][1]));
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfItIsAStraightLine().checkStraightLine(
                new int[][]{
                        new int[]{1, 2},
                        new int[]{2, 3},
                        new int[]{3, 4},
                        new int[]{4, 5},
                        new int[]{5, 6},
                        new int[]{6, 7}
                }
        )); // true
    }
}
