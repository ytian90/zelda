package core.dp;

/**
 * LC 213. House Robber II
 */
public class HouseRobber2 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int a = rob(nums, 0, nums.length - 2);
        int b = rob(nums, 1, nums.length - 1);
        return Math.max(a, b);
    }

    private int rob(int[] n, int start, int end) {
        int rob = 0, noRob = 0;
        for (int i = start; i <= end; i++) {
            int t = rob;
            rob = Math.max(rob, noRob + n[i]);
            noRob = t;
        }
        return rob;
    }
    // T: O(N)
    // S: O(1)
}
