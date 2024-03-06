package core.array.twopointers;

/**
 * LC 287. Find the Duplicate Number
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length < 2) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    // T: O(N)
    // S: O(1)
}
