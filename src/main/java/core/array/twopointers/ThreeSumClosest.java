package core.array.twopointers;

import java.util.Arrays;

/**
 * LC 16. 3Sum Closest
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, res = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[i] + nums[hi];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
                if (sum < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return res;
    }
    // T: O(N ^ 2)
    // S: O(N)
}
