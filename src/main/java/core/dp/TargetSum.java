package core.dp;

/**
 * LC 494. Target Sum
 */
public class TargetSum {
    // recursion
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, target, 0, 0);
    }

    private int helper(int[] nums, int target, int pos, int sum) {
        if (pos == nums.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }
        return helper(nums, target, pos + 1, sum + nums[pos]) + helper(nums, target, pos + 1, sum - nums[pos]);
    }
    // T: (2 ^ N)
    // S: O(N)

    // recursion + memo
    public int findTargetSumWays2(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        Integer[][] memo = new Integer[n + 1][2 * sum + 1];
        return helper(nums, target, 0, 0, sum, memo);
    }

    private int helper(int[] nums, int target, int pos, int sum, int offset, Integer[][] memo) {
        if (pos == nums.length) {
            if (target == sum) {
                return 1;
            }
            return 0;
        }
        if (memo[pos][sum + offset] != null) {
            return memo[pos][sum + offset];
        }
        int res = helper(nums, target, pos + 1, sum + nums[pos], offset, memo) +
                helper(nums, target, pos + 1, sum - nums[pos], offset, memo);
        memo[pos][sum + offset] = res;
        return res;
    }
    // TS: O(N * M)

    // 2D DP
    public int findTargetSumWays3(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int[][] dp = new int[n][2 * sum + 1];
        int offset = sum;
        dp[0][nums[0] + offset] = 1;
        dp[0][-nums[0] + offset] += 1;
        for (int i = 1; i < n; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i - 1][j + offset] > 0) {
                    dp[i][j + offset + nums[i]] += dp[i - 1][j + offset];
                    dp[i][j + offset - nums[i]] += dp[i - 1][j + offset];
                }
            }
        }
        return Math.abs(target) > sum ? 0 : dp[n - 1][target + offset];
    }
    // TS: O(N * M)

    // 1D DP
    public int findTargetSumWays4(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int[] dp = new int[2 * sum + 1];
        int offset = sum;
        dp[nums[0] + offset] = 1;
        dp[-nums[0] + offset] += 1;
        for (int i = 1; i < n; i++) {
            int[] next = new int[2 * sum + 1];
            for (int j = -sum; j <= sum; j++) {
                if (dp[j + offset] > 0) {
                    next[j + offset + nums[i]] += dp[j + offset];
                    next[j + offset - nums[i]] += dp[j + offset];
                }
            }
            dp = next;
        }
        return Math.abs(target) > sum ? 0 : dp[target + offset];
    }
    // T: O(N * M)
    // S: O(M)
}
