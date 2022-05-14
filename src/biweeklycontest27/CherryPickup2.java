package biweeklycontest27;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/biweekly-contest-27/problems/cherry-pickup-ii/
 */
public class CherryPickup2 {
    public int cherryPickup(int[][] grid) {
        return cherryPickup(grid, 0, 0, grid[0].length - 1);
    }

    private int cherryPickup(int[][] grid, int currentRow, int index1, int index2) {
        if (index1 > index2) {
            return cherryPickup(grid, currentRow, index2, index1);
        }
        int[] curRow = grid[currentRow];
        if (currentRow == grid.length - 1) {
            if (index1 == index2) {
                return curRow[index1];
            }
            return curRow[index1] + curRow[index2];
        }
        int maximum = Integer.MIN_VALUE;
        if (index1 == index2) {
            if (index1 == 0) {
                maximum = maximum(
                        cherryPickup(grid, currentRow + 1, 0, 0),
                        cherryPickup(grid, currentRow + 1, 0, 1),
                        cherryPickup(grid, currentRow + 1, 1, 1)
                );
            } else if (index1 == curRow.length - 1) {
                maximum = maximum(
                        cherryPickup(grid, currentRow + 1, index1, index1),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1 - 1)
                );
            } else {
                maximum = maximum(
                        cherryPickup(grid, currentRow + 1, index1, index1),
                        cherryPickup(grid, currentRow + 1, index1, index1 + 1),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1 + 1),
                        cherryPickup(grid, currentRow + 1, index1 - 1, index1 - 1),
                        cherryPickup(grid, currentRow + 1, index1 + 1, index1 + 1)
                );
            }
            return curRow[index1] + maximum;
        }
        if (index1 == 0 && index2 == curRow.length - 1) {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, 0, index2),
                    cherryPickup(grid, currentRow + 1, 0, index2 - 1),
                    cherryPickup(grid, currentRow + 1, 1, index2),
                    cherryPickup(grid, currentRow + 1, 1, index2 - 1)
            );
        } else if (index1 == 0) {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, 0, index2),
                    cherryPickup(grid, currentRow + 1, 0, index2 + 1),
                    cherryPickup(grid, currentRow + 1, 0, index2 - 1),
                    cherryPickup(grid, currentRow + 1, 1, index2),
                    cherryPickup(grid, currentRow + 1, 1, index2 + 1),
                    cherryPickup(grid, currentRow + 1, 1, index2 - 1)
            );
        } else if (index2 == curRow.length - 1) {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, index1, index2),
                    cherryPickup(grid, currentRow + 1, index1, index2 - 1),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2 - 1),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2 - 1)
            );
        } else {
            maximum = maximum(
                    cherryPickup(grid, currentRow + 1, index1, index2),
                    cherryPickup(grid, currentRow + 1, index1, index2 + 1),
                    cherryPickup(grid, currentRow + 1, index1, index2 - 1),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2 + 1),
                    cherryPickup(grid, currentRow + 1, index1 - 1, index2 - 1),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2 + 1),
                    cherryPickup(grid, currentRow + 1, index1 + 1, index2 - 1)
            );
        }
        return curRow[index1] + curRow[index2] + maximum;
    }

    private int maximum(int... values) {
        return Arrays.stream(values).max().getAsInt();
    }

    public static void main(String[] args) {
//        System.out.println(new CherryPickup2().cherryPickup(
//                new int[][]{{1, 0, 0, 3}, {0, 0, 0, 3}, {0, 0, 3, 3}, {9, 0, 3, 3}}
//        )); // 22
        System.out.println(new CherryPickup2().cherryPickup(
                new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}
        )); // 22
    }
}
