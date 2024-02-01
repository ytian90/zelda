package core.slidingwindow;

/**
 * LC 713. Subarray Product Less Than K
 */
public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int res = 0, prod = 1, start = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[start++];
            }
            res += i - start + 1;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
