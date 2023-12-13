package core.array;

/**
 * LC 169. Majority Element
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                res = nums[i];
                count = 1;
            } else if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
