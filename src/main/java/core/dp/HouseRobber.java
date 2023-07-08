package core.dp;

import java.util.Arrays;

/**
 * LC 198. House Robber
 */
public class HouseRobber {
    // Recursive: top-down
    public int rob1(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] n, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob(n, i - 2) + n[i], rob(n, i - 1));
    }

    // Recursive + memo: top-down
    int[] memo;

    public int rob2(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1, memo);
    }

    private int rob(int[] n, int i, int[] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        return memo[i] = Math.max(rob(n, i - 2) + n[i], rob(n, i - 1));
    }

    // Iterative + memo: bottom-up
    public int rob3(int[] nums) {
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            memo[i] = Math.max(memo[i - 2] + nums[i - 1], memo[i - 1]);
        }
        return memo[nums.length];
    }

    // DP
    public int rob(int[] nums) {
        int rob = nums[0], noRob = 0;
        for (int i = 1; i < nums.length; i++) {
            int t = rob;
            rob = Math.max(rob, noRob + nums[i]);
            noRob = t;
        }
        return rob;
    }
    // T: O(N)
    // S: O(1)
}
