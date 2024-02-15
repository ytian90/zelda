package core.array.prefixsum;

/**
 * LC 724. Find Pivot Index
 * This question is the same as LC 1991
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int sum = 0, leftSum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
    // T: O(N)
    // S: O(1)
}
