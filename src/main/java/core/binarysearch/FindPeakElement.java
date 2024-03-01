package core.binarysearch;

/**
 * LC 162. Find Peak Element
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    // T: O(logN)
    // S: O(1)

    public int findPeakElement1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
    // T: O(N)
    // S: O(1)

    public int findPeakElement2(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, lo, mid);
        } else {
            return search(nums, mid + 1, hi);
        }
    }
    // TS: O(logN)

}
