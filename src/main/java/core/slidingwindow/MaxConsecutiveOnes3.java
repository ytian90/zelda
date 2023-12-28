package core.slidingwindow;

/**
 * LC 1004. Max Consecutive Ones III
 */
public class MaxConsecutiveOnes3 {
    public static int longestOnes(int[] nums, int k) {
        int start = 0, res = 0, zeroCount = 0;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (start <= i && zeroCount > k) {
                if (nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        System.out.println(longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }
}
