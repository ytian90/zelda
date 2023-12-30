package core.array.prefixsum;

/**
 * LC 304. Range Sum Query 2D - Immutable
 */
public class RangeSumQuery2DImmutable {
    int[][] preSum;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        preSum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        System.out.println();
    }
    // TS: O(N * M)

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
    // TS: O(1)

    public static void main(String[] args) {
        RangeSumQuery2DImmutable o = new RangeSumQuery2DImmutable(new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        });
        System.out.println(o.sumRegion(2,1,4,3));
    }

}
