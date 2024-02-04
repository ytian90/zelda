package core.array.twopointers;

/**
 * LC 977. Squares of a Sorted Array
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int i = 0, j = n - 1, index = n - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
                res[index] = nums[i] * nums[i];
                index--;
                i++;
            } else {
                res[index] = nums[j] * nums[j];
                index--;
                j--;
            }
        }
        return res;
    }
    // TS: O(N)
}
