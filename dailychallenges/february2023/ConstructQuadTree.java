package dailychallenges.february2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/construct-quad-tree/
 */
public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }

    private Node construct(int[][] grid, int x, int y, int size) {
        if (size == 1) {
            return new Node(grid[x][y] == 1, true);
        }

        int halfSize = size / 2;
        List<Node> children = Arrays.asList(
                construct(grid, x, y, halfSize),
                construct(grid, x, y + halfSize, halfSize),
                construct(grid, x + halfSize, y, halfSize),
                construct(grid, x + halfSize, y + halfSize, halfSize)
        );

        if (children.stream().allMatch(node -> node.isLeaf)) {
            List<Boolean> values = children.stream().map(node -> node.val).distinct().collect(Collectors.toList());
            if (values.size() == 1) {
                return new Node(values.get(0), true);
            }
        }

        return new Node(true, false, children.get(0), children.get(1), children.get(2), children.get(3));
    }

    public static void main(String[] args) {
        System.out.println(new ConstructQuadTree().construct(
                new int[][]{
                        new int[]{1, 1, 1, 1, 0, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 0, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 1, 1, 1, 1},
                        new int[]{1, 1, 1, 1, 0, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 0, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 0, 0, 0, 0},
                        new int[]{1, 1, 1, 1, 0, 0, 0, 0}
                }
        )); // [1,0,[1,1],[1,0,[0,1],[0,1],[1,1],[1,1]],[1,1],[0,1]]
    }

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }

        @Override
        public String toString() {
            return "[" + (val ? 1 : 0) + "," + (isLeaf ? 1 : 0) + (isLeaf ? "" : "," + topLeft + "," + topRight + "," + bottomLeft + "," + bottomRight) + "]";
        }
    }
}
