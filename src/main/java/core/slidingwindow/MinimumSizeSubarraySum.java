package core.slidingwindow;

/**
 * LC 209. Minimum Size Subarray Sum
 */
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= target) {
                sum -= nums[start];
                if (i - start + 1 < minLen) {
                    minLen = i - start + 1;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
