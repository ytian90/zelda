package core.slidingwindow;

/**
 * LC 643. Maximum Average Subarray I
 */
public class MaximumAverageSubarray1 {
    public static double findMaxAverage(int[] nums, int k) {
        double max = -Double.MAX_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) { // start to calc res at after k - 1
                max = Math.max(max, sum / k);
            }
        }
        return max;
    }
    // T: O(N)
    // S: O(1)

    public double findMaxAverage2(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }
        return res / k;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{-1}, 1));
    }
}
