package core.binarysearch;

/**
 * LC 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res;
        }
        res[0] = findFirstPosition(nums, target);
        res[1] = findLastPosition(nums, target);
        return res;
    }

    private int findFirstPosition(int[] n, int target) {
        int lo = 0, hi = n.length - 1, res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (n[mid] == target) {
                res = mid;
                hi = mid - 1;
            } else if (n[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    private int findLastPosition(int[] n, int target) {
        int lo = 0, hi = n.length - 1, res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (n[mid] == target) {
                res = mid;
                lo = mid + 1;
            } else if (n[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
    // T: O(logN)
    // S: O(1)

}
