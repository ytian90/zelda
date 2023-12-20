package core.greedy;

/**
 * LC 670. Maximum Swap
 */
public class MaximumSwap {
    // buckets to store the last position of digit 0-9 in the num
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int[] buckets = new int[10];
        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }
        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char t = digits[i];
                    digits[i] = digits[buckets[k]];
                    digits[buckets[k]] = t;
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        return num;
    }
    // TS: O(N)
}
