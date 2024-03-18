package core.array;

/**
 * LC 918. Maximum Sum Circular Subarray
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], currMax = 0, minSum = nums[0], currMin = 0;
        for (int a : nums) {
            currMax = Math.max(currMax + a, a); // Kadane's algo
            maxSum = Math.max(maxSum, currMax);
            currMin = Math.min(currMin + a, a);
            minSum = Math.min(minSum, currMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
    // T: O(N)
    // S: O(1)
}
