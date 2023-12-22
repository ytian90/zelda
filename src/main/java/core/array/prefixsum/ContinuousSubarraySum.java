package core.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * LC 523. Continuous Subarray Sum
 */
public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }
    // T: O(N)
    // S: O(K)

    // O(N ^ 2), TLE
    public static boolean checkSubarraySum2(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = (preSum[i] + nums[i]) % k;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j > 1 && (preSum[i] - preSum[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{0}, 1));
        System.out.println(checkSubarraySum(new int[]{5,0,0,0}, 3));
    }
}
