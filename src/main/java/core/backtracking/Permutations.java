package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 46. Permutations
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, new boolean[nums.length], list, res);
        return res;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, visited, list, res);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
    // T: O(N * N!)
    // S: O(N)
}
