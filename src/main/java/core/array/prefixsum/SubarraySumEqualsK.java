package core.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 560. Subarray Sum Equals K
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        // <sum, sum counter>
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
    // TS: O(N)
}
