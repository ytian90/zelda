package core.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 2461. Maximum Sum of Distinct Subarrays With Length K
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0, sum = 0;
        int left = 0, right = 0;
        Set<Integer> set = new HashSet<>();
        while (right < nums.length) {
            while (left < right && (set.contains(nums[right]) || set.size() >= k)) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            right++;
            if (set.size() == k) {
                res = Math.max(res, sum);
            }
        }
        return res;
    }
    // TS: O(N)

    public long maximumSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long max = 0, sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i >= k - 1) {
                if (map.size() == k) {
                    max = Math.max(max, sum);
                }
                int prev = nums[i - k + 1];
                sum -= prev;
                map.put(prev, map.get(prev) - 1);
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }
            }
        }
        return max;
    }
    // TS: O(N)
}
