package core.greedy;

/**
 * LC 55. Jump Game
 * LC 45. Jump Game II
 */
public class JumpGame1And2 {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
    // T: O(N)
    // S: O(1)

    public int jump(int[] nums) {
        int maxReach = 0, res = 0, currEnd = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currEnd) {
                currEnd = maxReach;
                res++;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{0}));
        System.out.println(canJump(new int[]{0, 1}));
        System.out.println(canJump(new int[]{1, 2, 3}));
    }

}
