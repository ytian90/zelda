package core.array;

/**
 * LC 27. Remove Element
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int res = 0;
        for (int n : nums) {
            if (n != val) {
                nums[res++] = n;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
