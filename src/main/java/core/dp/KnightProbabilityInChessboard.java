package core.dp;

/**
 * LC 688. Knight Probability in Chessboard
 */
public class KnightProbabilityInChessboard {
    private int[][] dirs = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};

    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] memo = new Double[n][n][k + 1];
        return helper(n, k, row, column, memo);
    }

    private double helper(int n, int k, int i, int j, Double[][][] memo) {
        if (k == 0) {
            return 1;
        }
        if (memo[i][j][k] != null) {
            return memo[i][j][k];
        }
        double res = 0;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= n || y < 0 || y >= n) {
                continue;
            }
            res += 0.125 * helper(n, k - 1, x, y, memo);
        }
        return memo[i][j][k] = res;
    }
    // TS: O(N * N * K)
}
