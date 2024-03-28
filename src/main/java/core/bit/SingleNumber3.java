package core.bit;

import java.util.Arrays;

/**
 * LC 260. Single Number III
 */
public class SingleNumber3 {
    public static int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int n : nums) {
            diff ^= n;
        }
        diff &= -diff;
        int[] res = {0, 0};
        for (int n : nums) {
            if ((n & diff) == 0) {
                res[0] ^= n;
            } else {
                res[1] ^= n;
            }
        }
        return res;
    }
    // T: O(N)
    // S: O(1)

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{4, 8, 3, 3})));
    }
}
