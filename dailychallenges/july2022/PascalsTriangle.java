package dailychallenges.july2022;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        current.add(1);
        ans.add(current);

        for (int i = 1; i < numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 0; j < current.size() - 1; j++) {
                newList.add(current.get(j) + current.get(j + 1));
            }
            newList.add(1);
            current = newList;
            ans.add(current);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().generate(5)); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    }
}
