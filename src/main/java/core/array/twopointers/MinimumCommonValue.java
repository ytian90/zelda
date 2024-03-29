package core.array.twopointers;

/**
 * LC 2540. Minimum Common Value
 */
public class MinimumCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
    // T: O(N)
    // S: O(1)
}
