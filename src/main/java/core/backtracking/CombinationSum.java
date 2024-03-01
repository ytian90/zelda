package core.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 39. Combination Sum
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates, target, 0, list, res);
        return res;
    }

    private static void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0 && !list.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            helper(candidates, target - candidates[i], i, list, res);
            list.remove(list.size() - 1);
        }
    }
    // T: O(2 ^ N)
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}
