package core.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC 2597. The Number of Beautiful Subsets
 */
public class TheNumberOfBeautifulSubsets {
    private Map<Integer, Integer> freq;

    public int beautifulSubsets(int[] nums, int k) {
        this.freq = new HashMap<>();
        Arrays.sort(nums);
        return dfs(nums, k, 0) - 1; // -1 for empty subset
    }

    private int dfs(int[] nums, int k, int i) {
        if (i == nums.length) {
            return 1;
        }
        int res = dfs(nums, k, i + 1);
        if (!freq.containsKey(nums[i] - k)) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            res += dfs(nums, k, i + 1);
            freq.put(nums[i], freq.get(nums[i]) - 1);
            if (freq.get(nums[i]) == 0) {
                freq.remove(nums[i]);
            }
        }
        return res;
    }
    // T: O(2 ^ N)
    // S: O(N)

}
