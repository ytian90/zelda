package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 78. Subsets
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, 0, list, res);
        return res;
    }

    private void helper(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
    // T: O(N * 2 ^ N)
    // S: O(N)
}
