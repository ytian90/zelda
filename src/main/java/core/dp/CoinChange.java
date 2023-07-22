package core.dp;

import java.util.Arrays;

/**
 * LC 322. Coin Change
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return helper(coins, amount, new Integer[amount + 1]);
    }

    private int helper(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != null) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = helper(coins, amount - coin, memo);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        return memo[amount] = min == Integer.MAX_VALUE ? -1: min;
    }
    // TS: O(N)

    public static int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(coinChange2(new int[]{2}, 3));
    }
}
