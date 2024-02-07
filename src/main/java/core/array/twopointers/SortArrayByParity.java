package core.array.twopointers;

/**
 * LC 905. Sort Array By Parity
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            if (nums[lo] % 2 == 1 && nums[hi] % 2 == 0) {
                int t = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = t;
            }
            if (nums[lo] % 2 == 0) {
                lo++;
            }
            if (nums[hi] % 2 == 1) {
                hi--;
            }
        }
        return nums;
    }
    // T: O(N)
    // S: O(1)
}
