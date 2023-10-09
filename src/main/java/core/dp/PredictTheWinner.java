package core.dp;

import java.util.Arrays;

/**
 * LC 486. Predict the Winner
 */
public class PredictTheWinner {
    // Recursion
    public static boolean predictTheWinner(int[] nums) {
        return maxDiff(nums, 0, nums.length - 1) >= 0;
    }

    private static int maxDiff(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int leftScore = nums[left] - maxDiff(nums, left + 1, right);
        int rightScore = nums[right] - maxDiff(nums, left, right - 1);
        return Math.max(leftScore, rightScore);
    }
    // T: O(2 ^ N)
    // S: O(N)

    // Recursion + memorization / DP top-bottom
    public boolean predictTheWinner2(int[] nums) {
        int n = nums.length;
        Integer[][] memo = new Integer[n][n];
        return helper(nums, 0, n - 1, memo) >= 0;
    }

    private int helper(int[] nums, int left, int right, Integer[][] memo) {
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        if (left == right) {
            return nums[left];
        }
        int leftScore = nums[left] - helper(nums, left + 1, right, memo);
        int rightScore = nums[right] - helper(nums, left, right - 1, memo);
        memo[left][right] = Math.max(leftScore, rightScore);
        return memo[left][right];
    }
    // TS: O(N ^ 2)

    // DP bottom-up 2D
    public boolean predictTheWinner3(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int diff = 1; diff < n; diff++) {
            for (int left = 0; left < n - diff; left++) {
                int right = left + diff;
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right],
                        nums[right] - dp[left][right - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
    // TS: O(N ^ 2)

    // DP bottom-up 1D
    public boolean predictTheWinner4(int[] nums) {
        int n = nums.length;
        int[] dp = Arrays.copyOf(nums, n);
        for (int diff = 1; diff < n; diff++) {
            for (int left = 0; left < n - diff; left++) {
                int right = left + diff;
                dp[left] = Math.max(nums[left] - dp[left + 1], nums[right] - dp[left]);
            }
        }
        return dp[0] >= 0;
    }
    // T: O(N ^ 2)
    // S: O(N)

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1 ,5, 2}));
        System.out.println(predictTheWinner(new int[]{2,4,55,6,8}));
    }
}
