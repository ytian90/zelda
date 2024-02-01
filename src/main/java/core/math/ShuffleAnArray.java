package core.math;

import java.util.Random;

/**
 * LC 384. Shuffle an Array
 */
public class ShuffleAnArray {
    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        if (nums == null) {
            return null;
        }
        int[] res = nums.clone();
        for (int i = 0; i < res.length; i++) {
            swap(res, i, random.nextInt(i + 1));
        }
        return res;
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }
    // TS: O(N)
}
