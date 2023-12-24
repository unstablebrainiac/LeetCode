package dailychallenges.december2023;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/path-crossing/
 */
public class PathCrossing {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }
            int hash = 10000 * x + y;
            if (visited.contains(hash)) {
                return true;
            }
            visited.add(hash);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PathCrossing().isPathCrossing("NESWW")); // true
    }
}
