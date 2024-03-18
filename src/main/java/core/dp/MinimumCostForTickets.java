package core.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * LC 983. Minimum Cost for Tickets
 */
public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n - 1];
        Integer[] memo = new Integer[lastDay + 1];
        Set<Integer> travelDays = new HashSet<>();
        for (int d : days) {
            travelDays.add(d);
        }
        return helper(days, costs, memo, travelDays, 1);
    }

    private int helper(int[] days, int[] costs, Integer[] memo, Set<Integer> travelDays, int currDay) {
        if (currDay > days[days.length - 1]) {
            return 0;
        }
        if (!travelDays.contains(currDay)) {
            return helper(days, costs, memo, travelDays, currDay + 1);
        }
        if (memo[currDay] != null) {
            return memo[currDay];
        }
        int oneDay = costs[0] + helper(days, costs, memo, travelDays, currDay + 1);
        int sevenDay = costs[1] + helper(days, costs, memo, travelDays, currDay + 7);
        int thirtyDay = costs[2] + helper(days, costs, memo, travelDays, currDay + 30);
        return memo[currDay] = Math.min(Math.min(oneDay, sevenDay), thirtyDay);
    }
    // TS: O(K), where K is the last day need to travel.

    public int mincostTickets2(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n - 1];
        int[] dp = new int[lastDay + 1];
        for (int i = 0, day = 1; day <= lastDay; day++) {
            if (day < days[i]) {
                dp[day] = dp[day - 1];
            } else {
                i++;
                dp[day] = Math.min(Math.min(dp[day - 1] + costs[0],
                                dp[Math.max(0, day - 7)] + costs[1]),
                                dp[Math.max(0, day - 30)] + costs[2]);
            }
        }
        return dp[lastDay];
    }
    // TS: O(K), where K is the last day need to travel.
}
