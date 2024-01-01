package core.binarysearch;

/**
 * LC 1060. Missing Element in Sorted Array
 * similar to LC 1539. Kth Missing Positive Number
 */
public class MissingElementInSortedArray {
    public int missingElement(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            int currMiss = nums[i] - nums[i - 1] - 1;
            if (currMiss >= k) {
                return nums[i - 1] + k;
            }
            k -= currMiss;
        }
        return nums[n - 1] + k;
    }
    // T: O(N)
    // S: O(1)

    public int missingElement2(int[] nums, int k) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] - nums[0] - mid < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return nums[0] + lo + k - 1;
    }
    // T: O(logN)
    // S: O(1)

}
