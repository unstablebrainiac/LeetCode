package biweeklycontest135;

/*
 * https://leetcode.com/problems/find-the-winning-player-in-coin-game/
 */
public class FindTheWinningPlayerInCoinGame {

    public String losingPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 == 0 ? "Alice" : "Bob";
    }

    public static void main(String[] args) {
        System.out.println(new FindTheWinningPlayerInCoinGame().losingPlayer(2, 7)); // Alice
    }
}
