package core.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 930. Binary Subarrays with Sum
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            sum += n;
            if (sum == goal) {
                count++;
            }
            if (map.containsKey(sum - goal)) {
                count += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    // TS: O(N)

    public int numSubarraysWithSum2(int[] nums, int goal) {
        return slidingWindowAtMost(nums, goal) - slidingWindowAtMost(nums, goal - 1);
    }

    private int slidingWindowAtMost(int[] nums, int goal) {
        int start = 0, sum = 0, count = 0;
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (start <= end && sum > goal) {
                sum -= nums[start++];
            }
            count += end - start + 1;
        }
        return count;
    }
    // T: O(N)
    // S: O(1)
}
