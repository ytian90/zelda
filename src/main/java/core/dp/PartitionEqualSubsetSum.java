package core.dp;

/**
 * LC 416. Partition Equal Subset Sum
 */
public class PartitionEqualSubsetSum {
    // Recursive + memo
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        Boolean[][] memo = new Boolean[nums.length + 1][sum + 1];
        return dfs(nums, 0, sum, memo);
    }

    private boolean dfs(int[] nums, int pos, int sum, Boolean[][] memo) {
        if (sum == 0) {
            return true;
        }
        if (pos >= nums.length || sum < 0) {
            return false;
        }
        if (memo[pos][sum] != null) {
            return memo[pos][sum];
        }
        boolean res = dfs(nums, pos + 1, sum - nums[pos], memo) || dfs(nums, pos + 1, sum, memo);
        return memo[pos][sum] = res;
    }
    // TS: O(N * M), N is the length of nums, M is the sum / 2.

    // DP 2D bottom-up
    public static boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
    // TS: O(N * M), N is the length of nums, M is the sum / 2.

    public static void main(String[] args) {
        System.out.println(canPartition2(new int[]{11, 11}));
    }

    // DP 1D bottom-up
    public boolean canPartition3(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= n) {
                    dp[i] = dp[i] || dp[i - n];
                }
            }
        }
        return dp[sum];
    }
    // T: O(N * M), N is the length of nums, M is the sum / 2.
    // S: O(M)
}
