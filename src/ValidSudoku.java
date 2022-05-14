/*
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] box = new boolean[9][9];
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int digitMinusOne = c - '1';
                    if (row[i][digitMinusOne]) {
                        return false;
                    }
                    row[i][digitMinusOne] = true;
                    if (column[j][digitMinusOne]) {
                        return false;
                    }
                    column[j][digitMinusOne] = true;
                    int boxNumber = getBoxNumber(i, j);
                    if (box[boxNumber][digitMinusOne]) {
                        return false;
                    }
                    box[boxNumber][digitMinusOne] = true;
                }
            }
        }
        return true;
    }

    private int getBoxNumber(int i, int j) {
        return i / 3 + j - j % 3;
    }

    public static void main(String[] args) {
        System.out.println(new ValidSudoku().isValidSudoku(
                new char[][]{
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                }
        )); // true
    }
}
