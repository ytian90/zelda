package core.binarysearch;

/**
 * LC 540. Single Element in a Sorted Array
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        int res = 0;
        for (int i : nums) {
            res ^= i;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public int singleNonDuplicate2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean rightEven = (hi - mid) % 2 == 0;
            if (nums[mid + 1] == nums[mid]) {
                if (rightEven) {
                    lo = mid + 2;
                } else {
                    hi = mid - 1;
                }
            } else if (nums[mid - 1] == nums[mid]) {
                if (rightEven) {
                    hi = mid - 2;
                } else {
                    lo = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
    // T: O(logN)
    // S: O(1)

}
