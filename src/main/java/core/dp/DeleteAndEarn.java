package core.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 740. Delete and Earn
 */
public class DeleteAndEarn {
    private Map<Integer, Integer> points = new HashMap<>();
    private Map<Integer, Integer> memo = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int n : nums) {
            points.put(n, points.getOrDefault(n, 0) + n);
            max = Math.max(max, n);
        }
        return dfs(max);
    }

    private int dfs(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return points.getOrDefault(1, 0);
        }
        if (memo.containsKey(num)) {
            return memo.get(num);
        }
        int gain = points.getOrDefault(num, 0);
        memo.put(num, Math.max(dfs(num - 1), dfs(num - 2) + gain));
        return memo.get(num);
    }
    // TS: O(N + k), where N is the length of nums, and k is the maximum number in nums.




}
