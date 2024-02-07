package core.array.prefixsum;

/**
 * LC 303. Range Sum Query - Immutable
 */
public class RangeSumQueryImmutable {
    int[] preSum;

    public RangeSumQueryImmutable(int[] nums) {
        int n = nums.length;
        preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
    }
    // TS: O(N)

    public int sumRange(int left, int right) {
        return preSum[right + 1] - preSum[left];
    }
    // TS: O(1)
}
