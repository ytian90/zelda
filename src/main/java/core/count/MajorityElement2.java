package core.count;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 229. Majority Element II
 */
public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;
        for (int n : nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            } else if (candidate2 != null && candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for (int n: nums) {
            if (candidate1 != null && candidate1 == n) {
                count1++;
            }
            if (candidate2 != null && candidate2 == n) {
                count2++;
            }
        }
        int n = nums.length;
        if (count1 > n / 3) {
            res.add(candidate1);
        }
        if (count2 > n / 3) {
            res.add(candidate2);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
