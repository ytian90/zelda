package core.dp;

import java.util.Arrays;

/**
 * LC 698. Partition to K Equal Sum Subsets
 */
public class PartitionToKEqualSumSubsets {
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, k, sum / k, 0, 0, visited);
    }

    private static boolean helper(int[] nums, int k, int target, int total, int pos, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (total == target) {
            return helper(nums, k - 1, target, 0, 0, visited);
        }
        for (int i = pos; i < nums.length; i++) {
            if (visited[i] || total + nums[i] > target) continue;
            visited[i] = true;
            if (helper(nums, k, target, total + nums[i], i + 1, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
    // T: O(N!)
    // S: O(N)

    public boolean canPartitionKSubsets2(int[] nums, int k) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        return helper(nums, sum / k, nums.length - 1, new int[k]);
    }

    private boolean helper(int[] nums, int target, int i, int[] bucket) {
        if (i == -1) {
            return true;
        }
        for (int j = 0; j < bucket.length; j++) {
            if (bucket[j] + nums[i] > target) {
                continue;
            }
            bucket[j] += nums[i];
            if (helper(nums, target, i - 1, bucket)) {
                return true;
            }
            bucket[j] -= nums[i];
            if (bucket[j] == 0) {
                break;
            }
        }
        return false;
    }
    // T: O(2 ^ N)
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(canPartitionKSubsets(new int[]{4,3,2,3,5,2,1}, 4));
    }
}
