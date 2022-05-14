package dailychallenges.june2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int length = board.length;
        if (length == 0 || length == 1) {
            return;
        }
        int width = board[0].length;
        if (width == 0 || width == 1) {
            return;
        }
        Set<IntegerPair> exclusions = new HashSet<>();
        for (int i = 0; i < length; i += length - 1) {
            for (int j = 0; j < width; j++) {
                checkBoundaryCell(board, i, j, exclusions);
            }
        }
        for (int j = 0; j < width; j += width - 1) {
            for (int i = 1; i < length - 1; i++) {
                checkBoundaryCell(board, i, j, exclusions);
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (exclusions.contains(new IntegerPair(i, j))) {
                    continue;
                }
                board[i][j] = 'X';
            }
        }
    }

    private void checkBoundaryCell(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        if (board[i][j] == 'O') {
            exclusions.add(new IntegerPair(i, j));
            excludeSurroundingOs(board, i, j, exclusions);
        }
    }

    private void excludeSurroundingOs(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        excludeTopO(board, i, j, exclusions);
        excludeBottomO(board, i, j, exclusions);
        excludeLeftO(board, i, j, exclusions);
        excludeRightO(board, i, j, exclusions);
    }

    private void excludeRightO(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        if (j == board[0].length - 1) {
            return;
        }
        excludeO(board, i, j + 1, exclusions);
    }

    private void excludeLeftO(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        if (j == 0) {
            return;
        }
        excludeO(board, i, j - 1, exclusions);
    }

    private void excludeBottomO(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        if (i == board.length - 1) {
            return;
        }
        excludeO(board, i + 1, j, exclusions);
    }

    private void excludeTopO(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        if (i == 0) {
            return;
        }
        excludeO(board, i - 1, j, exclusions);
    }

    private void excludeO(char[][] board, int i, int j, Set<IntegerPair> exclusions) {
        if (exclusions.contains(new IntegerPair(i, j))) {
            return;
        }
        if (board[i][j] == 'X') {
            return;
        }
        exclusions.add(new IntegerPair(i, j));
        excludeSurroundingOs(board, i, j, exclusions);
    }

    public static void main(String[] args) {
//        char[][] board = {
//                {'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'},
//        };
        char[][] board = {
                {'O', 'X', 'O'},
                {'X', 'O', 'X'},
                {'O', 'X', 'O'}
        };
        new SurroundedRegions().solve(board);
        System.out.println(Arrays.deepToString(board));
        // X, X, X, X
        // X, X, X, X
        // X, X, X, X
        // X, O, X, X
    }

    static class IntegerPair {
        int one;
        int two;

        public IntegerPair(int one, int two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public boolean equals(Object obj) {
            return one == ((IntegerPair) obj).one && two == ((IntegerPair) obj).two;
        }

        @Override
        public int hashCode() {
            return Objects.hash(one, two);
        }
    }
}
