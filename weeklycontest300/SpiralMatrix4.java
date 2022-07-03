package weeklycontest300;

import common.ListNode;

import java.util.Arrays;

public class SpiralMatrix4 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int[] ints : matrix) {
            Arrays.fill(ints, -1);
        }
        spiralMatrix(m, n, head, matrix, 0, 0, 0, new int[]{n - 1, m - 1, 0, 1});
        return matrix;
    }

    private void spiralMatrix(int m, int n, ListNode head, int[][] matrix, int a, int b, int direction, int[] edges) {
        if (head == null) {
            return;
        }
        if (matrix[a][b] == -1) {
            matrix[a][b] = head.val;
            head = head.next;
        }
        switch (direction) {
            case 0:
                if (b == edges[0]) {
                    spiralMatrix(m, n, head, matrix, a, b, 1, new int[]{edges[0] - 1, edges[1], edges[2], edges[3]});
                } else {
                    spiralMatrix(m, n, head, matrix, a, b + 1, 0, edges);
                }
                break;
            case 1:
                if (a == edges[1]) {
                    spiralMatrix(m, n, head, matrix, a, b, 2, new int[]{edges[0], edges[1] - 1, edges[2], edges[3]});
                } else {
                    spiralMatrix(m, n, head, matrix, a + 1, b, 1, edges);
                }
                break;
            case 2:
                if (b == edges[2]) {
                    spiralMatrix(m, n, head, matrix, a, b, 3, new int[]{edges[0], edges[1], edges[2] + 1, edges[3]});
                } else {
                    spiralMatrix(m, n, head, matrix, a, b - 1, 2, edges);
                }
                break;
            case 3:
                if (a == edges[3]) {
                    spiralMatrix(m, n, head, matrix, a, b, 0, new int[]{edges[0], edges[1], edges[2], edges[3] + 1});
                } else {
                    spiralMatrix(m, n, head, matrix, a - 1, b, 3, edges);
                }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new SpiralMatrix4().spiralMatrix(
                                3,
                                4,
                                new ListNode(
                                        3,
                                        new ListNode(
                                                0,
                                                new ListNode(
                                                        2,
                                                        new ListNode(
                                                                6,
                                                                new ListNode(
                                                                        8,
                                                                        new ListNode(
                                                                                1,
                                                                                new ListNode(
                                                                                        7,
                                                                                        new ListNode(
                                                                                                9,
                                                                                                new ListNode(
                                                                                                        4,
                                                                                                        new ListNode(
                                                                                                                5,
                                                                                                                new ListNode(6)
                                                                                                        )
                                                                                                )
                                                                                        )
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                )
        );
    }
}
