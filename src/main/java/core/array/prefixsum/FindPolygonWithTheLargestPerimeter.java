package core.array.prefixsum;

import java.util.Arrays;

/**
 * LC 2971. Find Polygon With the Largest Perimeter
 */
public class FindPolygonWithTheLargestPerimeter {
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        long res = -1;
        for (int i = 1; i < n; i++) {
            if (preSum[i] > nums[i]) {
                res = preSum[i + 1];
            }
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(N)

    public long largestPerimeter2(int[] nums) {
        Arrays.sort(nums);
        long sum = 0, res = -1;
        for (int n : nums) {
            if (n < sum) {
                res = n + sum;
            }
            sum += n;
        }
        return res;
    }
    // T: O(N * logN)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{5,5,5}));
    }
}
