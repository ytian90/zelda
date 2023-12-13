package core.array.twopointers;

/**
 * LC 80. Remove Duplicates from Sorted Array II
 */
public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < 2 || nums[index - 2] < nums[i]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
    // T: O(N)
    // S: O(1)
}
