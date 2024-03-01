package core.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 40. Combination Sum II
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, list, res);
        return res;
    }

    private void helper(int[] nums, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            helper(nums, target - nums[i], i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    // T: O(2 ^ N)
    // S: O(N)
}
