package core.array.twopointers;

/**
 * LC 88. Merge Sorted Array
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int p = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[p] = nums1[i];
                i--;
            } else {
                nums1[p] = nums2[j];
                j--;
            }
            p--;
        }
        while (j >= 0) {
            nums1[p] = nums2[j];
            j--;
            p--;
        }
    }
    // T: O(N + M)
    // S: O(1)
}
