package contests.weekly.weeklycontest413;

/*
 * https://leetcode.com/problems/check-if-two-chessboard-squares-have-the-same-color/
 */
public class CheckIfTwoChessboardSquaresHaveTheSameColor {

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int row1 = coordinate1.charAt(0) - 'a';
        int col1 = Integer.parseInt("" + coordinate1.charAt(1));
        boolean white1 = row1 % 2 == 0 && col1 % 2 == 0 || row1 % 2 == 1 && col1 % 2 == 1;

        int row2 = coordinate2.charAt(0) - 'a';
        int col2 = Integer.parseInt("" + coordinate2.charAt(1));
        boolean white2 = row2 % 2 == 0 && col2 % 2 == 0 || row2 % 2 == 1 && col2 % 2 == 1;

        return (white1 && white2) || (!white1 && !white2);
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfTwoChessboardSquaresHaveTheSameColor().checkTwoChessboards("a1", "h3")); // false
    }
}
