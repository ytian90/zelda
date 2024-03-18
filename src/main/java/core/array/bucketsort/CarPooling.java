package core.array.bucketsort;

/**
 * LC 1094. Car Pooling
 */
public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] ts = new int[1001];
        for (int[] e : trips) {
            ts[e[1]] += e[0];
            ts[e[2]] -= e[0];
        }
        int cap = 0;
        for (int n : ts) {
            cap += n;
            if (cap > capacity) {
                return false;
            }
        }
        return true;
    }
    // T: O(N)
    // S: O(1)
}
