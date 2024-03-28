package core.array.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 18. 4Sum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private List<List<Integer>> kSum(int[] nums, long target, int start, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (start == n) {
            return res;
        }
        long average_target = target / k;
        if (nums[start] > average_target || nums[n - 1] < average_target) {
            return res;
        }
        if (k == 2) {
            return twoSum(nums, target, start);
        }
        for (int i = start; i < n; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            for (List<Integer> subset : kSum(nums, target - nums[i], i + 1, k - 1)) {
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
                res.get(res.size() - 1).addAll(subset);
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, long target, int start) {
        List<List<Integer>> res = new ArrayList<>();
        int lo = start, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target || lo > start && nums[lo] == nums[lo - 1]) {
                lo++;
            } else if (sum > target || hi < nums.length - 1 && nums[hi] == nums[hi + 1]) {
                hi--;
            } else {
                res.add(Arrays.asList(nums[lo], nums[hi]));
                lo++;
                hi--;
            }
        }
        return res;
    }
    // T: O(N ^ 3)
    // S: O(N)
}
