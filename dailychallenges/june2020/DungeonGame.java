package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        Integer[][] hp = new Integer[dungeon.length][dungeon[0].length];
        return calculateMinimumHP(dungeon, hp, 0, 0);
    }

    private int calculateMinimumHP(int[][] dungeon, Integer[][] hp, int i0, int j0) {
        if (hp[i0][j0] != null) {
            return hp[i0][j0];
        }
        if (i0 == dungeon.length - 1 && j0 == dungeon[0].length - 1) {
            int minHP = Math.max(1, 1 - dungeon[i0][j0]);
            hp[i0][j0] = minHP;
            return minHP;
        }
        int minHP1 = i0 == dungeon.length - 1 ? Integer.MAX_VALUE : calculateMinimumHP(dungeon, hp, i0 + 1, j0);
        int minHP2 = j0 == dungeon[0].length - 1 ? Integer.MAX_VALUE : calculateMinimumHP(dungeon, hp, i0, j0 + 1);

        int minHP = Math.max(1, Math.min(minHP1, minHP2) - dungeon[i0][j0]);
        hp[i0][j0] = minHP;
        return minHP;
    }

    public static void main(String[] args) {
        System.out.println(new DungeonGame().calculateMinimumHP(
                new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                }
        )); // 7
    }
}
