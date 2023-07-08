package core.binarysearch;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {
    // Binary Search
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                int j = binarySearch(res, nums[i]);
                if (j < 0) {
                    j = -(j + 1);
                }
                res.set(j, nums[i]);
            }
        }
        return res.size();
    }

    private int binarySearch(List<Integer> list, int num) {
        int lo = 0, hi = list.size() - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (list.get(mid) < num) {
                lo = mid + 1;
            } else if (list.get(mid) > num) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -(lo + 1);
    }
    // T: O(N * logN)
    // S: O(N)
}
