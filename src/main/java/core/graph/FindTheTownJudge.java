package core.graph;

/**
 * LC 997. Find the Town Judge
 */
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (trust.length < n - 1) {
            return -1;
        }
        int[] count = new int[n + 1];
        for (int[] e : trust) {
            count[e[0]]--;
            count[e[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
    // TS: O(N)
}
