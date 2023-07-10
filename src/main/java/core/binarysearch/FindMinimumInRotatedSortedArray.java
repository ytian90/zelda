package core.binarysearch;

/**
 * LC 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) { // cannot use <=
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
    }
    // T: O(logN)
    // S: O(1)
}
