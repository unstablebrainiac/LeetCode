import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, new boolean[nums.length], new ArrayList<>());
    }

    private List<List<Integer>> permute(int[] nums, boolean[] visited, List<Integer> current) {
        if (current.size() == nums.length) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(new ArrayList<>(current));
            return lists;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            ans.addAll(permute(nums, visited, current));
            visited[i] = false;
            current.remove(Integer.valueOf(nums[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Permutations().permute(
                new int[]{1, 2, 3}
        )); // [[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
    }
}
