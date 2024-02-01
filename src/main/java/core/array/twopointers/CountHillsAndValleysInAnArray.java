package core.array.twopointers;

/**
 * LC 2210. Count Hills and Valleys in an Array
 */
public class CountHillsAndValleysInAnArray {
    public int countHillValley(int[] nums) {
        int res = 0;
        for (int i = 1, j = 0; i < nums.length - 1; i++) {
            if (nums[j] < nums[i] && nums[i] > nums[i + 1] || nums[j] > nums[i] && nums[i] < nums[i + 1]) {
                res++;
                j = i;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
