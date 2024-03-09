package core.array.prefixsum;

/**
 * LC 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            res[i] *= right;
        }
        return res;
    }
    // TS: O(N)
}
