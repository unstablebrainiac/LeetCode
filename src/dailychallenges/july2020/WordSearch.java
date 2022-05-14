package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3397/
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    used[i][j] = true;
                    if (exist(board, word.substring(1), used, i, j)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, String word, boolean[][] used, int i, int j) {
        if (word.isEmpty()) {
            return true;
        }
        char c = word.charAt(0);
        String next = word.substring(1);
        if (i != board.length - 1 && !used[i + 1][j] && board[i + 1][j] == c) {
            used[i + 1][j] = true;
            if (exist(board, next, used, i + 1, j)) {
                return true;
            }
            used[i + 1][j] = false;
        }
        if (i != 0 && !used[i - 1][j] && board[i - 1][j] == c) {
            used[i - 1][j] = true;
            if (exist(board, next, used, i - 1, j)) {
                return true;
            }
            used[i - 1][j] = false;
        }
        if (j != board[0].length - 1 && !used[i][j + 1] && board[i][j + 1] == c) {
            used[i][j + 1] = true;
            if (exist(board, next, used, i, j + 1)) {
                return true;
            }
            used[i][j + 1] = false;
        }
        if (j != 0 && !used[i][j - 1] && board[i][j - 1] == c) {
            used[i][j - 1] = true;
            if (exist(board, next, used, i, j - 1)) {
                return true;
            }
            used[i][j - 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordSearch().exist(
                new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                },
                "ABCCED"
        )); // true
    }
}
