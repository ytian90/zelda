package core.array;

/**
 * LC 453. Minimum Moves to Equal Array Elements
 */
public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(i, min);
        }
        int res = 0;
        for (int i : nums) {
            res += i - min;
        }
        return res;
    }
    // T: O(N)
    // S: O(1)
}
