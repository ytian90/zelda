package core.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 448. Find All Numbers Disappeared in an Array
 */
public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int n : nums) {
            int i = Math.abs(n) - 1;
            if (nums[i] > 0) {
                nums[i] = -nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
