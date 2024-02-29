package core.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC 1235. Maximum Profit in Job Scheduling
 */
public class MaximumProfitInJobScheduling {
    // recursion + memo
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> (a[0] - b[0]));
        return dfs(jobs, 0, new HashMap<>());
    }

    private int dfs(int[][] jobs, int pos, Map<Integer, Integer> memo) {
        if (pos == jobs.length) {
            return 0;
        }
        if (memo.containsKey(pos)) {
            return memo.get(pos);
        }
        int next = findNext(jobs, pos);
        int includeCurr = jobs[pos][2] + dfs(jobs, next, memo);
        int excludeCurr = dfs(jobs, pos + 1, memo);
        int res = Math.max(includeCurr, excludeCurr);
        memo.put(pos, res);
        return res;
    }

    private int findNext(int[][] jobs, int pos) {
        int lo = pos + 1, hi = jobs.length - 1, next = jobs.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][0] >= jobs[pos][1]) {
                next = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return next;
    }
    // T: O(N * logN)
    // S: O(N)

    // DP
    public int jobScheduling2(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> (a[1] - b[1]));
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = jobs[i][2];
            int next = findPrev(jobs, i);
            dp[i] = Math.max(dp[i], jobs[i][2] + (next == -1 ? 0 : dp[next]));
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

    private int findPrev(int[][] jobs, int pos) {
        int lo = 0, hi = pos - 1, next = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (jobs[mid][1] <= jobs[pos][0]) {
                next = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return next;
    }
    // T: O(N * logN)
    // S: O(N)

    public static void main(String[] args) {
        MaximumProfitInJobScheduling o = new MaximumProfitInJobScheduling();
        System.out.println(o.jobScheduling(new int[]{1,2,3,3}, new int[]{3,4,5,6}, new int[]{50,10,40,70}));
    }

}
