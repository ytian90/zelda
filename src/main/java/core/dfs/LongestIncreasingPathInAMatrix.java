package core.dfs;

/**
 * LC 329. Longest Increasing Path in a Matrix
 */
public class LongestIncreasingPathInAMatrix {
    int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Integer[][] memo = new Integer[n][m];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, dfs(matrix, i, j, memo));
            }
        }
        return res;
    }

    private int dfs(int[][] matrix, int i, int j, Integer[][] memo) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int res = 0;
        for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            res = Math.max(res, dfs(matrix, x, y, memo));
        }
        return memo[i][j] = 1 + res;
    }
    // TS: O(N * M)

    public static void main(String[] args) {
        LongestIncreasingPathInAMatrix o = new LongestIncreasingPathInAMatrix();
        System.out.println(o.longestIncreasingPath(new int[][]{{9,9,4}, {6,6,8}, {2,1,1}}));
    }

}
