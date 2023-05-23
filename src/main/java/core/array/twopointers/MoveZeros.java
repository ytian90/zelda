package core.array.twopointers;

/**
 * LC 283. Move Zeros
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[prev] = nums[i];
                prev++;
            }
        }
        while (prev < nums.length) {
            nums[prev] = 0;
            prev++;
        }
    }
    // T: O(N)
    // S: O(1)
}
