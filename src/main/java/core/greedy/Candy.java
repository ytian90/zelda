package core.greedy;

import java.util.Arrays;

/**
 * LC 135. Candy
 */
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length, res = 0;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                right[i] = right[i + 1] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
    // TS: O(N)
}
