import java.util.Arrays;

/*
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        short[][][] possibilitiesBoard = new short[9][9][10];
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    possibilitiesBoard[i][j][0] = 0;
                    for (short k = 1; k < 10; k++) {
                        possibilitiesBoard[i][j][k] = k;
                    }
                } else {
                    possibilitiesBoard[i][j][0] = (short) (board[i][j] - '0');
                }
            }
        }

        removePossibilities(possibilitiesBoard);
        fillSingularities(possibilitiesBoard);
        solveSudoku(possibilitiesBoard);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = Character.forDigit(possibilitiesBoard[i][j][0], 10);
            }
        }
    }

    private boolean solveSudoku(short[][][] possibilitiesBoard) {
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                if (possibilitiesBoard[i][j][0] == 0) {
                    for (short k = 1; k < 10; k++) {
                        if (possibilitiesBoard[i][j][k] != 0) {
                            if (tryDigit(possibilitiesBoard, i, j, k)) {
                                return true;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean tryDigit(short[][][] possibilitiesBoard, short i, short j, short digit) {
        short[][][] temp = clone(possibilitiesBoard);
        temp[i][j][0] = digit;
        removePossibilities(temp, i, j, digit, true);
        if (fillSingularities(temp) && solveSudoku(temp)) {
            for (int i1 = 0; i1 < 9; i1++) {
                for (int j1 = 0; j1 < 9; j1++) {
                    System.arraycopy(temp[i1][j1], 0, possibilitiesBoard[i1][j1], 0, 10);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private short[][][] clone(short[][][] possibilitiesBoard) {
        short[][][] clone = new short[9][9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                for (int k = 0; k < 10; k++) {
                    clone[i][j][k] = possibilitiesBoard[i][j][k];
                }
            }
        }
        return clone;
    }

    private void removePossibilities(short[][][] possibilitiesBoard) {
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                if (possibilitiesBoard[i][j][0] != 0) {
                    removePossibilities(possibilitiesBoard, i, j, possibilitiesBoard[i][j][0]);
                }
            }
        }
    }

    private void removePossibilities(short[][][] possibilitiesBoard, short i, short j, short digit, boolean self) {
        if (self) {
            removeSelfPossibilities(possibilitiesBoard, i, j);
        }
        removeRowPossibilities(possibilitiesBoard, i, digit);
        removeColumnPossibilities(possibilitiesBoard, j, digit);
        removeBoxPossibilities(possibilitiesBoard, i, j, digit);
    }

    private void removePossibilities(short[][][] possibilitiesBoard, short i, short j, short digit) {
        removePossibilities(possibilitiesBoard, i, j, digit, false);
    }

    private void removeSelfPossibilities(short[][][] possibilitiesBoard, short i, short j) {
        for (int k = 1; k < 10; k++) {
            possibilitiesBoard[i][j][k] = 0;
        }
    }

    private void removeRowPossibilities(short[][][] possibilitiesBoard, short i, short digit) {
        for (int j = 0; j < 9; j++) {
            if (possibilitiesBoard[i][j][0] == 0) {
                possibilitiesBoard[i][j][digit] = 0;
            }
        }
    }

    private void removeColumnPossibilities(short[][][] possibilitiesBoard, short j, short digit) {
        for (int i = 0; i < 9; i++) {
            if (possibilitiesBoard[i][j][0] == 0) {
                possibilitiesBoard[i][j][digit] = 0;
            }
        }
    }

    private void removeBoxPossibilities(short[][][] possibilitiesBoard, short i, short j, short digit) {
        short i3 = (short) ((i / 3) * 3);
        short j3 = (short) ((j / 3) * 3);
        for (short i1 = i3; i1 < i3 + 3; i1++) {
            for (short j1 = j3; j1 < j3 + 3; j1++) {
                if (possibilitiesBoard[i1][j1][0] == 0) {
                    possibilitiesBoard[i1][j1][digit] = 0;
                }
            }
        }
    }

    private boolean fillSingularities(short[][][] possibilitiesBoard) {
        for (short i = 0; i < 9; i++) {
            for (short j = 0; j < 9; j++) {
                if (possibilitiesBoard[i][j][0] == 0) {
                    short digit = 0;
                    short count = 0;
                    for (short k = 1; k < 10; k++) {
                        if (possibilitiesBoard[i][j][k] != 0) {
                            count++;
                            digit = k;
                        }
                    }
                    if (count == 1) {
                        possibilitiesBoard[i][j][0] = digit;
                        removePossibilities(possibilitiesBoard, i, j, digit, true);
                    } else if (count == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new SudokuSolver().solveSudoku(
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
        );
    }
}
