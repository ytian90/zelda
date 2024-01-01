package core.backtracking;

/**
 * LC 996. Number of Squareful Arrays
 */
public class NumberOfSquarefulArrays {
    public int numSquarefulPerms(int[] nums) {
        return helper(nums, 0);
    }

    private int helper(int[] n, int start) {
        if (start >= n.length) {
            return 1;
        }
        int res = 0;
        for (int i = start; i < n.length; i++) {
            if (hasSameValueBefore(n, start, i)) {
                continue;
            }
            swap(n, start, i);
            if (start == 0 || sumSquare(n, start)) {
                res += helper(n, start + 1);
            }
            swap(n, start, i);
        }
        return res;
    }

    private boolean hasSameValueBefore(int[] n, int start, int end) {
        for (int i = start; i < end; i++) {
            if (n[i] == n[end]) {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] n, int i, int j) {
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    private boolean sumSquare(int[] n, int i) {
        int sq = (int) Math.sqrt(n[i - 1] + n[i]);
        return (sq * sq) == (n[i - 1] + n[i]);
    }
    // T: O(N!)
    // S: O(N)

}
