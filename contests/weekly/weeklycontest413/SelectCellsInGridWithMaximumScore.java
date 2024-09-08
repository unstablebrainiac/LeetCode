package contests.weekly.weeklycontest413;

import java.util.*;

/*
 * https://leetcode.com/problems/select-cells-in-grid-with-maximum-score/
 * Does not pass
 */
public class SelectCellsInGridWithMaximumScore {

    public int maxScore(List<List<Integer>> grid) {
        grid.forEach(list -> list.sort(Comparator.reverseOrder()));
        Map<Integer, Integer> valueToRow = new HashMap<>();
        Map<Integer, Integer> rowToColumn = new HashMap<>();
        for (int i = 0; i < grid.size(); i++) {
            insertValue(rowToColumn, grid, valueToRow, i, 0);
        }
        return valueToRow.keySet().stream().mapToInt(Integer::intValue).sum();
    }

    private void insertValue(Map<Integer, Integer> rowToColumn, List<List<Integer>> grid, Map<Integer, Integer> valueToRow, int row, int column) {
        System.out.println(valueToRow.keySet());
        if (column >= grid.get(row).size()) {
            return;
        }
        if (!valueToRow.containsKey(grid.get(row).get(column))) {
            valueToRow.put(grid.get(row).get(column), row);
            rowToColumn.put(row, column);
        }
        int value = grid.get(row).get(column);
        int nextValueInCurrentRow = column + 1 < grid.get(row).size() ? grid.get(row).get(column + 1) : 0;
        int existingRow = valueToRow.get(value);
        int nextValueInExistingRow = rowToColumn.get(existingRow) + 1 < grid.get(existingRow).size() ? grid.get(existingRow).get(rowToColumn.get(existingRow) + 1) : 0;
        if (nextValueInCurrentRow > nextValueInExistingRow) {
            insertValue(rowToColumn, grid, valueToRow, existingRow, rowToColumn.get(existingRow) + 1);
        } else {
            valueToRow.remove(value);
            rowToColumn.remove(existingRow);
            insertValue(rowToColumn, grid, valueToRow, row, column);
            insertValue(rowToColumn, grid, valueToRow, existingRow, rowToColumn.get(existingRow) + 1);
        }
    }

//    private int maxScore(List<List<Integer>> grid, int row, Set<Integer> taken, Map<String, Integer> dp, List<Integer> maxSum) {
//        String key = setString(taken);
//        if (dp.containsKey(key)) {
//            return dp.get(key);
//        }
//        boolean seen = false;
//        int best = 0;
//        for (Integer integer : grid.get(row)) {
//            if (!taken.contains(integer)) {
//                taken.add(integer);
//                int nextRow = row + 1;
//                int score = nextRow == grid.size() ? 0 : maxScore(grid, nextRow, taken, dp, maxSum);
//                taken.remove(integer);
//                if (score == maxSum.get(row)) {
//                    dp.put(key, integer + score);
//                    return score;
//                }
//                int applyAsInt = integer + score;
//                if (!seen || applyAsInt > best) {
//                    seen = true;
//                    best = applyAsInt;
//                }
//            }
//        }
//        int maxIfChosen = seen ? best : 0;
//        taken.add(-row);
//        int ans = Math.max(maxIfChosen, row == grid.size() - 1 ? 0 : maxScore(grid, row + 1, taken, dp, maxSum));
//        taken.remove(-row);
//        dp.put(key, ans);
//        return ans;
//    }
//
//    private String setString(Set<Integer> set) {
//        return set.stream().sorted().map(String::valueOf).reduce((a, b) -> a + "," + b).orElse("");
//    }

    public static void main(String[] args) {
        System.out.println(new SelectCellsInGridWithMaximumScore().maxScore(Arrays.asList(
                Arrays.asList(5, 10, 16),
                Arrays.asList(10, 2, 4),
                Arrays.asList(4, 12, 16),
                Arrays.asList(4, 20, 13)
        )));
    }
}
