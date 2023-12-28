package core.dp;

import java.util.Arrays;

/**
 * LC 689. Maximum Sum of 3 Non-Overlapping Subarrays
 */
public class MaximumSumOf3NonOverlappingSubarrays {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxSum = 0;
        int[] sum = new int[n + 1];
        // posLeft[i] is the starting index for the left interval in range [0, i];
        // posRight[i] is the starting index for the right interval in range [i, n-1];
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        int[] res = new int[3];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = k, total = sum[k] - sum[0]; i < n; i++) {
            int curr = sum[i + 1] - sum[i + 1 - k];
            if (curr > total) {
                posLeft[i] = i + 1 - k;
                total = curr;
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }

        posRight[n - k] = n - k;
        for (int i = n - k - 1, total = sum[n] - sum[n - k]; i >= 0; i--) {
            int curr = sum[i + k] - sum[i];
            if (curr >= total) {
                posRight[i] = i;
                total = curr;
            } else {
                posRight[i] = posRight[i + 1];
            }
        }

        for (int i = k; i <= n - 2 * k; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int total = (sum[i + k] - sum[i]) + (sum[l + k] - sum[l]) + (sum[r + k] - sum[r]);
            if (total > maxSum) {
                maxSum = total;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        return res;
    }
    // TS: O(N)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[]{1,2,1,2,6,7,5,1}, 2)));
    }

}
