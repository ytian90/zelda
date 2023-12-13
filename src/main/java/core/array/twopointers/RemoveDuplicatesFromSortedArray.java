package core.array.twopointers;

/**
 * LC 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index == 0 || nums[index - 1] < nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    // T: O(N)
    // S: O(1)
}
