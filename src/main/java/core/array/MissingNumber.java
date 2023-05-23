package core.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * LC 268. Missing Number
 */
public class MissingNumber {
    // sort + binary search
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > mid) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    // T: O(N * logN)
    // S: O(1)

    // HashSet
    public int missingNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
    // T/S: O(N)

    // Bit manipulation
    public int missingNumber3(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    // Math - Gauss' Formula
    public int missingNumber4(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
    // T: O(N)
    // S: O(1)
}
