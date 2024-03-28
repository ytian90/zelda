package core.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 2958. Length of the Longest Subarray With At Most K Frequency
 */
public class LengthOfLongestSubarrayWithAtMostKFrequency {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > k) {
                map.put(nums[start], map.get(nums[start]) - 1);
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
    // TS: O(N)
}
