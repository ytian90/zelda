package core.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 47. Permutations II
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, new boolean[nums.length], list, res);
        return res;
    }

    private void helper(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i - 1] == nums[i] && visited[i - 1])) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            helper(nums, visited, list, res);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
    // T: O(N!)
    // S: O(N)
}
